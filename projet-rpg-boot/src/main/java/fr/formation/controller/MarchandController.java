package fr.formation.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.dao.IHeroDaoJpaRepository;
import fr.formation.dao.IInventiaireDaoJpaRepository;
import fr.formation.dao.IObjetDaoJpaRepository;
import fr.formation.model.Hero;
import fr.formation.model.Objet;
import fr.formation.service.InstanceService;

@Controller
public class MarchandController {
	@Autowired
	private IObjetDaoJpaRepository daoObjet;
	@Autowired
	InstanceService sauvegarde;
	
	@Autowired
	private IHeroDaoJpaRepository daoHero;
	
	@Autowired
	private IInventiaireDaoJpaRepository daoInventaire;

	@GetMapping("/marchand")
	public String marchand() {
		return "marchand";
	}

	@GetMapping("/shop")
	public String shop(Model model) {
		System.out.println("JE ME DEMANDE ?");
		Hero monHero = sauvegarde.getMonHeroAJouer();
		List<Objet> listByLevel = daoObjet.findAllByLevel(1);
		List<Objet> listRandom = new ArrayList<>();
		Random random = new Random();
		int i = 0;
		while (i < 4 && listByLevel.size() > 0) {
			int nombreAleatoire = random.nextInt(listByLevel.size());
			listRandom.add(listByLevel.remove(nombreAleatoire));
			i++;
			sauvegarde.setliste(listRandom);

		}
		model.addAttribute("objets", listRandom);

		return "shop";
	}
	@GetMapping("/achat")
	public String achat(@RequestParam int id) {

		Hero monHero = sauvegarde.getMonHeroAJouer();
		List<Objet> objets = monHero.getInventaire().getObjets();
		Objet objetAchete = daoObjet.findById(id).get();

		objets.add(objetAchete);
		System.out.println("objet attech� a la liset");
		monHero.getInventaire().setObjets(objets);
		System.out.println("liste attach� a linventaire");
		monHero.setArgent(monHero.getArgent().subtract(objetAchete.getPrix()));
		System.out.println("retrait des sous");
		daoInventaire.save(monHero.getInventaire());
		daoHero.save(monHero);
		return "redirect:/shop";

	}

}