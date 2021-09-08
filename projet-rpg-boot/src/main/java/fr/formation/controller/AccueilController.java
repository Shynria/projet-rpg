package fr.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.formation.dao.IHeroDaoJpaRepository;
import fr.formation.model.Hero;
import fr.formation.service.InstanceService;

@Controller
public class AccueilController {

	@Autowired
	private IHeroDaoJpaRepository daoHero;

	@Autowired
	private InstanceService sauvegarde;

	@GetMapping("/accueil")
	public String accueil(Model model){
		Hero monHero = sauvegarde.getMonHeroAJouer();

		model.addAttribute("hero", monHero);
		return "menu-central";
	}
}
