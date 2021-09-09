package fr.formation.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

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
		Hero monHero = sauvegarde.getMonHeroAJouer();
		daoHero.save(monHero);
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
	@Transactional
	@GetMapping("/achat")
	public String achat(@RequestParam int id) {
		Hero monHero = sauvegarde.getMonHeroAJouer();
		List<Objet> objets = monHero.getInventaire().getObjets();
		Objet objetAchete = daoObjet.findById(id).get();
		objets.add(objetAchete);
		monHero.getInventaire().setObjets(objets);
		 int comparaison =monHero.getArgent().compareTo(objetAchete.getPrix());
		 if (comparaison>0){
		monHero.setArgent(monHero.getArgent().subtract(objetAchete.getPrix()));
		daoInventaire.save(monHero.getInventaire());
		daoHero.save(monHero);
		return "redirect:/shop";
		 }else{ 
			 return "redirect:/marchand";
		 }

	}
@GetMapping("/vendre")
public String vendre(Model model){
	System.out.println("1");
Hero monHero = sauvegarde.getMonHeroAJouer();
daoHero.save(monHero);
model.addAttribute("objets", monHero.getInventaire().getObjets());
	return "vendre";
}

@GetMapping("/vente")
public String venteObjet(@RequestParam int id){
	Hero monHero = sauvegarde.getMonHeroAJouer();
	daoHero.save(monHero);
	List<Objet> objets = monHero.getInventaire().getObjets();
	Objet objetAVendre = null;

	for (Objet o : objets) {
		if (o.getId() == id) {
			objetAVendre = o;
			break;
		}
	}

	if (objetAVendre != null) {
		objets.remove(objetAVendre);
		BigDecimal argentRendu = objetAVendre.getPrix().divide(new BigDecimal(2));
		monHero.setArgent(monHero.getArgent().add(argentRendu));
		daoInventaire.save(monHero.getInventaire());
		daoHero.save(monHero);
	}

return "redirect:/vendre";
}
}