package fr.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.formation.dao.IObjetDaoJpaRepository;

@Controller
public class ObjetController {
	@Autowired
	IObjetDaoJpaRepository daoObjet;
	
	@GetMapping("/liste-objet")
	public String listeObjet(Model model){
		model.addAttribute("objets", daoObjet.findAll());
		return "liste-objet";
	}
}
