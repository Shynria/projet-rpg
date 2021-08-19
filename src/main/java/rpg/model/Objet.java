package rpg.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity 
@Table(name="objet") 
public class Objet {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="OBJET_ID")
	private int id;
	
	@Column(name="OBJET_TYPE", length = 50, nullable = false) 
	private String type;
	
	@Column(name="OBJET_NOM", length = 50) 
	private String nom;
	
	@Column(name="OBJET_ID_ATTRIBUT",nullable = false) 
	private String attribut;
	
	@Column(name="OBJET_CHANGEMENT") 
	private int changement;
	
	@Column(name="OBJET_PV_RENDU")
	private int pvRendu;
	
	@Column(name="OBJET_LEVEL") 
	private int level;
	
	@Column(name="OBJET_PRIX")
	private BigDecimal prix;
	
	
	@ManyToMany(mappedBy = "objets")
	private List<Inventaire> inventaire;

	
	
	
	
	public int getPvRendu() {
		return pvRendu;
	}
	public void setPvRendu(int pvRendu) {
		this.pvRendu = pvRendu;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Inventaire> getInventaire() {
		return inventaire;
	}
	public void setInventaire(List<Inventaire> inventaire) {
		this.inventaire = inventaire;
	}
	public int getIdEquipement() {
		return id;
	}
	public void setIdEquipement(int idEquipement) {
		id = idEquipement;
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
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAttribut() {
		return attribut;
	}
	public void setAttribut(String attribut) {
		this.attribut = attribut;
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
	public Objet(String type, String nom, String attribut, int changement, int level, BigDecimal prix) {
		super();
		this.type = type;
		this.nom = nom;
		this.attribut = attribut;
		this.changement = changement;
		this.level = level;
		this.prix = prix;
	}
	public Objet(String type, String nom, String attribut, int changement, int level, BigDecimal prix,
			List<Inventaire> inventaire) {
		super();
		this.type = type;
		this.nom = nom;
		this.attribut = attribut;
		this.changement = changement;
		this.level = level;
		this.prix = prix;
		this.inventaire = inventaire;
	}
	
	public Objet(String type, String nom, String attribut, int pvRendu, BigDecimal prix) {
		super();
		this.type = type;
		this.nom = nom;
		this.attribut = attribut;
		this.pvRendu = pvRendu;
		this.prix = prix;
	}
	
	
	
	
}