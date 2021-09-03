package fr.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.formation.dao.IBestiaireDaoJpaRepository;

@Controller
public class BestiaireController {
	@Autowired
	IBestiaireDaoJpaRepository daoBestiaire;
	
	@GetMapping("/bestiaire")
	public String bestiaire(Model model){
		model.addAttribute("monstres", daoBestiaire.findAll());
		return "bestiaire";
	}
	
}
