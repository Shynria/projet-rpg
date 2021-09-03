package fr.formation;

import java.math.BigDecimal;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.formation.config.AppConfig;
import fr.formation.dao.IHeroDaoJpaRepository;
import fr.formation.dao.ILevelDaoJpaRepository;
import fr.formation.model.Attribut;
import fr.formation.model.Bestiaire;
import fr.formation.model.Hero;
import fr.formation.model.Objet;
import fr.formation.service.BestiaireService;
import fr.formation.service.HeroService;
import fr.formation.service.InventaireService;
import fr.formation.service.ObjetService;

public class ApplicationJpaSpring {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext myContext = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		HeroService srvHero = myContext.getBean(HeroService.class);
		ObjetService srvObjet = myContext.getBean(ObjetService.class);
		InventaireService srvInventaire = myContext.getBean(InventaireService.class);
		BestiaireService srvMonstre = myContext.getBean(BestiaireService.class);
		
		//ILevelDaoJpaRepository levelDao = myContext.getBean(ILevelDaoJpaRepository.class);
		
		//srvHero.partirEnExpedition();
		//srvHero.createHero();
		//srvObjet.createObjet(new Objet("armure", "armure en cuir", "agi", 2, 1, new BigDecimal(3)));
		//srvInventaire.ajouterObjetDansInventaire(1, 3);
		//srvInventaire.voirMonInventaire();
		//srvHero.equiperObjet();
		//srvMonstre.createMonstre(new Attribut(3, 2, 4, 3, "monstre"), new Bestiaire(1, "blob jaune", 15, 5));
	}

}
