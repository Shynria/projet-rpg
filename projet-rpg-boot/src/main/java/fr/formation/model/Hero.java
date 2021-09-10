package fr.formation.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "Hero")
public class Hero {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "HERO_ID", nullable = false)
	private int id;
	
	@Column(name="HERO_NIVEAU")
	private int niveau;
	
	@Column(name = "HERO_NOM", length = 50, nullable = false)
	private String nom;
	
	@OneToOne
	@JoinColumn(name = "HERO_ATR_ID")
	private Attribut attribut;
	
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
	
	@OneToOne
	@JoinColumn(name = "HERO_ARME")
	private Objet arme;
	
	@OneToOne
	@JoinColumn(name = "HERO_ARMURE")
	private Objet armure;
	
	@OneToOne
	@JoinColumn(name = "HERO_BIJOUX")
	private Objet bijoux;
	
	
	
	public Objet getArme() {
		return arme;
	}
	public void setArme(Objet arme) {
		this.arme = arme;
	}
	public Objet getArmure() {
		return armure;
	}
	public void setArmure(Objet armure) {
		this.armure = armure;
	}
	public Objet getBijoux() {
		return bijoux;
	}
	public void setBijoux(Objet bijoux) {
		this.bijoux = bijoux;
	}
	public int getNiveau() {
		return niveau;
	}
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public Attribut getAttribut() {
		return attribut;
	}
	public void setAttribut(Attribut attribut) {
		this.attribut = attribut;
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
	
	public Hero(int niveau, String nom, Attribut attribut, BigDecimal argent, int xp) {
		this.niveau = niveau;
		this.nom = nom;
		this.attribut = attribut;
		this.argent = argent;
		this.xp = xp;
	}
	
}
