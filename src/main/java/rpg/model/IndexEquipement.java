package rpg.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity 
@Table(name="indexEquipement") 
public class IndexEquipement {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IND_ID")
	private int IdEquipement;
	@Column(name="IND_type", length = 50, nullable = false) 
	private String type;
	@Column(name="IND_idAttr",nullable = false) 
	private int idAttribut;
	@Column(name="IND_changement",nullable = false) 
	private int changement;
	@Column(name="IND_equip") 
	private int level;
	@Column(name="IND_prix")
	private BigDecimal prix;
	
	public int getIdEquipement() {
		return IdEquipement;
	}
	public void setIdEquipement(int idEquipement) {
		IdEquipement = idEquipement;
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
	public IndexEquipement() {
		super();
	}
	public IndexEquipement(int idEquipement, String type, int idAttribut, int changement) {
		super();
		IdEquipement = idEquipement;
		this.type = type;
		this.idAttribut = idAttribut;
		this.changement = changement;
	}
}