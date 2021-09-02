package fr.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.formation.dao.IObjetDaoJpaRepository;

@Controller
public class MarchandController {
	@Autowired
	private IObjetDaoJpaRepository daoObjet;
	
	@GetMapping("/marchand")
	public String marchand(){
		return "marchand";
	}
	@GetMapping("/shop")
	public String shop(Model model){
		System.out.println("heloo");
		
	model.addAttribute("objets", daoObjet.findAll());
	
		return "shop";
	}
	
}