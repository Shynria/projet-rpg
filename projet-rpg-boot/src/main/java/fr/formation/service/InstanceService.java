package fr.formation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import fr.formation.model.Hero;
import fr.formation.model.Inventaire;
import fr.formation.model.Objet;

@Component
@SessionScope
public class InstanceService {

	private Hero monHeroAJouer = new Hero();
	private List<Objet> liste = new ArrayList<Objet>();
	private Inventaire inventaire = new Inventaire();

	
	
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
	public void setliste(List<Objet> liste){
		this.liste=liste;
	}

	public Inventaire getInventaire() {
		return inventaire;
	}

	public void setInventaire(Inventaire inventaire) {
		this.inventaire = inventaire;
	}
}