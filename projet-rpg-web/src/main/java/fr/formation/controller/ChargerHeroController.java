package fr.formation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.dao.IHeroDaoJpaRepository;
import fr.formation.dao.ILevelDaoJpaRepository;
import fr.formation.model.Hero;
import fr.formation.service.InstanceService;

@Controller
public class ChargerHeroController {
	@Autowired
	IHeroDaoJpaRepository daoHero;
	
	@Autowired
	ILevelDaoJpaRepository daoLevel;
	
	@Autowired
	private InstanceService sauvegarde;
	
	
	
	@GetMapping("/charger-hero")
	public String chargerHero(Model model){
		model.addAttribute("heros", daoHero.findAll());
		model.addAttribute("levels", daoLevel.findAll());
		return "charger-hero";
	}
	
	@GetMapping("/choisir-hero")
	public String choisirHero(Model model, @RequestParam int id){
		Hero monHeroAjouer = daoHero.findById(id).get();
		sauvegarde.setMonHeroAJouer(monHeroAjouer);
		return "redirect:/accueil";
	}
}
