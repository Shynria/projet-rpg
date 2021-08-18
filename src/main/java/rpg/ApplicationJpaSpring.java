package rpg;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import rpg.config.AppConfig;
import rpg.dao.IHeroDaoJpaRepository;
import rpg.model.Hero;
import rpg.service.HeroService;

public class ApplicationJpaSpring {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext myContext = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		HeroService srvHero = myContext.getBean(HeroService.class);
		
		srvHero.partirEnExpedition();
	}

}
