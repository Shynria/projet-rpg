package fr.formation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.dao.IHeroDaoJpaRepository;
import fr.formation.dao.ILevelDaoJpaRepository;
import fr.formation.dao.IObjetDaoJpaRepository;
import fr.formation.model.Hero;
import fr.formation.model.Objet;
import fr.formation.service.InstanceService;

@Controller
public class InventaireController {
    @Autowired
	private InstanceService sauvegarde;

    @Autowired
	private ILevelDaoJpaRepository daoLevel;

    @Autowired
	private IHeroDaoJpaRepository daoHero;

    @Autowired
	private IObjetDaoJpaRepository daoObjet;

    @GetMapping("/inventaire")
	public String accueil(Model model){
		Hero hero = sauvegarde.getMonHeroAJouer();
        model.addAttribute("hero", daoHero.findById(hero.getId()).get());
        
        model.addAttribute("levels", daoLevel.findAll());

        List<Objet> objets = hero.getInventaire().getObjets();
        model.addAttribute("objets", hero.getInventaire().getObjets());
		
        
		return "inventaire";
	}

    @GetMapping("/equiper-objet")
    public String add(Model model, @RequestParam int id){
        Hero hero = sauvegarde.getMonHeroAJouer();
        model.addAttribute("hero", daoHero.findById(hero.getId()).get());

        Objet objetAequiper = daoObjet.findById(id).get();
        if(objetAequiper.getType().equals("arme")){
            hero.setArme(objetAequiper);
        }
        if(objetAequiper.getType().equals("armure")){
            hero.setArmure(objetAequiper);
        }
        if(objetAequiper.getType().equals("bijoux")){
            hero.setBijoux(objetAequiper);
        }

        daoHero.save(hero);

        return "redirect:/inventaire";
 
    }
}
