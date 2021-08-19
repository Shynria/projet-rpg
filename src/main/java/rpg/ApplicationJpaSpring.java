package rpg;

import java.math.BigDecimal;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import rpg.config.AppConfig;
import rpg.dao.IHeroDaoJpaRepository;
import rpg.dao.ILevelDaoJpaRepository;
import rpg.model.Hero;
import rpg.model.Objet;
import rpg.service.HeroService;
import rpg.service.InventaireService;
import rpg.service.ObjetService;

public class ApplicationJpaSpring {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext myContext = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		HeroService srvHero = myContext.getBean(HeroService.class);
		ObjetService srvObjet = myContext.getBean(ObjetService.class);
		InventaireService srvInventaire = myContext.getBean(InventaireService.class);
		
		//ILevelDaoJpaRepository levelDao = myContext.getBean(ILevelDaoJpaRepository.class);
		
		//srvHero.partirEnExpedition();
		//srvHero.createHero();
		//srvObjet.createObjet(new Objet("armure", "armure en cuir", "agi", 2, 1, new BigDecimal(3)));
		//srvInventaire.ajouterObjetDansInventaire(1, 3);
		srvInventaire.voirMonInventaire();
	}

}
