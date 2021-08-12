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
@Table(name = "bestiaire")
public class Bestiaire {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BESTIAIRE_ID", nullable = false)
	private int id;
	
	@Column(name = "BESTIAIRE_LEVEL", nullable = false)
	private int level;
	
	@Column(name = "BESTIAIRE_NOM", length = 50)
	private String nom;
	
	@Column(name = "BESTIAIRE_XP_DONNE", nullable = false)
	private int XpDonnee;
	
	@OneToOne
	@JoinColumn(name = "BESTIAIRE_ATR_ID")
	private Attribut attribut;
	
	public Bestiaire() {
	}
	public Bestiaire(int level, String nom, int xpDonnee) {
	super();
	this.level = level;
	this.nom = nom;
	XpDonnee = xpDonnee;
	}
	public Bestiaire(int id, int level, String nom, int xpDonnee) {
		super();
		this.id = id;
		this.level = level;
		this.nom = nom;
		XpDonnee = xpDonnee;
	}

	 public Bestiaire(int level, String nom, Attribut attribut) {
	 this.level = level;
	 this.nom = nom;
	 this.attribut = attribut;
	 }
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
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
}
