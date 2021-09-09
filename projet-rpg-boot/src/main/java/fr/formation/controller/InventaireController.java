package fr.formation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.formation.dao.IHeroDaoJpaRepository;
import fr.formation.dao.ILevelDaoJpaRepository;
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

    @GetMapping("/inventaire")
	public String accueil(Model model){
		Hero hero = sauvegarde.getMonHeroAJouer();
        model.addAttribute("hero", daoHero.findById(hero.getId()).get());
        
        model.addAttribute("levels", daoLevel.findAll());

        List<Objet> objets = hero.getInventaire().getObjets();
        model.addAttribute("objets", hero.getInventaire().getObjets());
		
        
		return "inventaire";
	}
}
