package fr.formation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CreerHeroController {
	@GetMapping("/creer-hero")
	public String creerHero(){
		return "creer-hero";
	}
}
