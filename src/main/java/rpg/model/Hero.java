package rpg.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Hero")
public class Hero {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "HERO_ID", nullable = false)
	private int idHero;
	
	@ManyToOne
	@JoinColumn(name="HERO_LEVEL_NIVEAU", nullable = false)
	private Level niveau;
	
	@Column(name = "HERO_NOM", length = 50, nullable = false)
	private String nom;
	
	@OneToOne(mappedBy = "hero")
	private Attribut idAttribut;
	
	@Column(name = "HERO_ARGENT", precision = 6, nullable = false)
	private BigDecimal argent;
	
	@Column(name = "HERO_PV_MAX", precision = 6)
	private int pvMax;
	
	@Column(name = "HERO_PV_ACTUEL", precision = 6)
	private int pvActuel;
	
	@Column(name = "HERO_XP", precision = 6, nullable = false)
	private int xp;
	
	@OneToOne(mappedBy = "hero")
	private Inventaire inventaire;
	
	
	public Level getNiveau() {
		return niveau;
	}
	public void setNiveau(Level niveau) {
		this.niveau = niveau;
	}
	
	public int getIdHero() {
		return idHero;
	}
	public void setIdHero(int idHero) {
		this.idHero = idHero;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public Attribut getIdAttribut() {
		return idAttribut;
	}
	public void setIdAttribut(Attribut idAttribut) {
		this.idAttribut = idAttribut;
	}
	
	
	public BigDecimal getArgent() {
		return argent;
	}
	public void setArgent(BigDecimal argent) {
		this.argent = argent;
	}
	
	public int getPvMax() {
		return pvMax;
	}
	public void setPvMax(int pvMax) {
		this.pvMax = pvMax;
	}
	
	public int getPvActuel() {
		return pvActuel;
	}
	public void setPvActuel(int pvActuel) {
		this.pvActuel = pvActuel;
	}
	
	public int getXp() {
		return xp;
	}
	public void setXp(int xp) {
		this.xp = xp;
	}
	
	public Inventaire getInventaire() {
		return inventaire;
	}
	public void setInventaire(Inventaire inventaire) {
		this.inventaire = inventaire;
	}
	
	
	public Hero() {
		super();
	}
	
	public Hero(int idHero, Level niveau, String nom, Attribut idAttribut, BigDecimal argent, int xp) {
		super();
		this.idHero = idHero;
		this.niveau = niveau;
		this.nom = nom;
		this.idAttribut = idAttribut;
		this.argent = argent;
		this.xp = xp;
	}
}
