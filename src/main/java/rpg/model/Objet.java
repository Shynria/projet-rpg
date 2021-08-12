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
@Table(name="objet") 
public class Objet {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="OBJET_ID")
	private int idObjet;
	
	@Column(name="OBJET_TYPE", length = 50, nullable = false) 
	private String type;
	
	@ManyToOne
	@JoinColumn(name="OBJET_ID_ATTRIBUT",nullable = false) 
	private Attribut idAttribut;
	
	@Column(name="OBJET_CHANGEMENT",nullable = false) 
	private int changement;
	
	@Column(name="OBJET_LEVEL") 
	private int level;
	
	@Column(name="OBJET_PRIX")
	private BigDecimal prix;
	
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
	public Attribut getIdAttribut() {
		return idAttribut;
	}
	public void setIdAttribut(Attribut idAttribut) {
		this.idAttribut = idAttribut;
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
	public Objet(int idEquipement, String type, Attribut idAttribut, int changement) {
		super();
		idObjet = idEquipement;
		this.type = type;
		this.idAttribut = idAttribut;
		this.changement = changement;
	}
}