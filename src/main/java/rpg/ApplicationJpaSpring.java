package rpg;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import rpg.config.AppConfig;
import rpg.dao.IHeroDaoJpaRepository;
import rpg.model.Hero;

public class ApplicationJpaSpring {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext myContext = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		IHeroDaoJpaRepository daoHero = myContext.getBean(IHeroDaoJpaRepository.class);
		Hero monHero = daoHero.findFirstByOrderById();
		System.out.println(monHero.getNom());
	}

}
