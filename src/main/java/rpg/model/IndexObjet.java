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
@Table(name="indexEquipement") 
public class IndexObjet {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IND_ID_OBJET")
	private int idObjet;
	
	@Column(name="IND_TYPE_OBJET", length = 50, nullable = false) 
	private String type;
	
	@ManyToOne
	@JoinColumn(name="IND_ID_ATTRIBUT",nullable = false) 
	private int idAttribut;
	
	@Column(name="IND_CHANGEMENT",nullable = false) 
	private int changement;
	
	@Column(name="IND_LEVEL_OBJET") 
	private int level;
	
	@Column(name="IND_PRIX")
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
	public int getIdAttribut() {
		return idAttribut;
	}
	public void setIdAttribut(int idAttribut) {
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
	
	public IndexObjet() {
	}
	public IndexObjet(int idEquipement, String type, int idAttribut, int changement) {
		super();
		idObjet = idEquipement;
		this.type = type;
		this.idAttribut = idAttribut;
		this.changement = changement;
	}
}