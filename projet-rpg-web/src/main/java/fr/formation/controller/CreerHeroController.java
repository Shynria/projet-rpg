package fr.formation.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.dao.IAttributDaoJpaRepository;
import fr.formation.dao.IHeroDaoJpaRepository;
import fr.formation.dao.IInventiaireDaoJpaRepository;
import fr.formation.model.Attribut;
import fr.formation.model.Hero;
import fr.formation.model.Inventaire;
import fr.formation.service.InstanceService;

@Controller
public class CreerHeroController {
	
	@Autowired
	private IHeroDaoJpaRepository daoHero;
	
	@Autowired
	private IInventiaireDaoJpaRepository daoInventaire;
	
	@Autowired
	private IAttributDaoJpaRepository daoAttribut;
	
	@Autowired
	private InstanceService sauvegarde;
	
	@GetMapping("/creer-hero")
	public String add(){
		return "creer-hero";
	}
	@PostMapping("creer-hero")
	public String add(Model model, @RequestParam String nom, @RequestParam int atk, @RequestParam int def, @RequestParam int agi, @RequestParam int vit){
		if (daoHero.findByNom(nom) == null){
			if (atk + def + agi + vit == 10){
				Hero monHero = new Hero();
				monHero.setNom(nom);
				monHero.setNiveau(1);
				monHero.setXp(0);
				monHero.setArgent(new BigDecimal(20));
				Attribut monAttribut = new Attribut(10+atk, 10+def, 10+vit, 10+agi, "hero");
				monHero.setPvMax(20 + 5 * vit);
				int pvMax = 20 + 5 * vit;
				monHero.setPvActuel(pvMax);
				monHero.setAttribut(monAttribut);
				Inventaire monInventaire = new Inventaire();
				monHero.setInventaire(monInventaire);
				daoAttribut.save(monAttribut);
				daoInventaire.save(monInventaire);
				daoHero.save(monHero);
				
				sauvegarde.setMonHeroAJouer(monHero);
				
				return "redirect:/accueil";
			} else {
				return "creer-hero";
			}
		} else {
			return "creer-hero";
		}
	}
	
}
