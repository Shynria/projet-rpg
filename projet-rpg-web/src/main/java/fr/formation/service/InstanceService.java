package fr.formation.service;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import fr.formation.model.Hero;

@Component
@SessionScope
public class InstanceService {

	private Hero monHeroAJouer = new Hero();

	public Hero getMonHeroAJouer() {
		return monHeroAJouer;
	}

	public void setMonHeroAJouer(Hero monHeroAJouer) {
		this.monHeroAJouer = monHeroAJouer;
	}
	
	public void jeJoue(Hero monHero){
		this.monHeroAJouer = monHero;
	}
	
	public void arreterJeux(Hero monHero){
		this.monHeroAJouer = null;
	}
}
