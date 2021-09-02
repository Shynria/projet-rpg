package fr.formation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChargerHeroController {
	@GetMapping("/charger-hero")
	public String chargerHero(){
		return "charger-hero";
	}
}
