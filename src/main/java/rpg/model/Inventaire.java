package rpg.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "inventaire")
public class Inventaire {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "INVENTAIRE_ID", nullable = false)
	private int idInventaire;
	
	@OneToMany(mappedBy = "inventaire")
	private List<Objet> objets;
	
	@OneToOne
	@JoinColumn(name = "INVENTAIRE_HERO")
	private Hero hero;

	
	public int getIdInventaire() {
		return idInventaire;
	}
	public void setIdInventaire(int idInventaire) {
		this.idInventaire = idInventaire;
	}
	public List<Objet> getObjets() {
		return objets;
	}
	public void setObjets(List<Objet> objets) {
		this.objets = objets;
	}
	public Hero getHero() {
		return hero;
	}
	public void setHero(Hero hero) {
		this.hero = hero;
	}
	
	public Inventaire(List<Objet> objets, Hero hero) {
		super();
		this.objets = objets;
		this.hero = hero;
	}
	public Inventaire() {
		super();
	}

}
