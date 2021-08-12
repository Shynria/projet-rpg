package rpg.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity 
@Table(name="objet") 
public class Objet {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="OBJET_ID")
	private int idObjet;
	
	@Column(name="OBJET_TYPE", length = 50, nullable = false) 
	private String type;
	
	@Column(name="OBJET_ID_ATTRIBUT",nullable = false) 
	private String attribut;
	
	@Column(name="OBJET_CHANGEMENT",nullable = false) 
	private int changement;
	
	@Column(name="OBJET_LEVEL") 
	private int level;
	
	@Column(name="OBJET_PRIX")
	private BigDecimal prix;
	
	@ManyToOne
	@JoinColumn(name = "OBJET_INVENTAIRE")
	private Inventaire inventaire;
	
	
	public int getIdObjet() {
		return idObjet;
	}
	public void setIdObjet(int idObjet) {
		this.idObjet = idObjet;
	}
	public Inventaire getInventaire() {
		return inventaire;
	}
	public void setInventaire(Inventaire inventaire) {
		this.inventaire = inventaire;
	}
	public int getIdEquipement() {
		return idObjet;
	}
	public void setIdEquipement(int idEquipement) {
		idObjet = idEquipement;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getIdAttribut() {
		return attribut;
	}
	public void setIdAttribut(String attribut) {
		this.attribut = attribut;
	}
	public int getChangement() {
		return changement;
	}
	public void setChangement(int changement) {
		this.changement = changement;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public BigDecimal getPrix() {
		return prix;
	}
	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}
	
	
	
	public Objet() {
	}
	public Objet(String type, String attribut, int changement, BigDecimal prix) {
		super();
		this.type = type;
		this.attribut = attribut;
		this.changement = changement;
		this.prix = prix;
	}
	
	
}