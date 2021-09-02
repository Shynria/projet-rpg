package fr.formation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuDemarrerController {
	@GetMapping("/menu-demarrer")
	public String menuDemarrer(){
		return "menu-demarrer";
	}
	
}
