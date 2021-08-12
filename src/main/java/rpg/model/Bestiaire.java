package rpg.model;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private List<Attribut> attributs;
	
	public Bestiaire() {
	}
	public Bestiaire(int level, String nom, List<Attribut> attributs) {
		this.level = level;
		this.nom = nom;
		this.attributs = attributs;
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
	
	public List<Attribut> getAttributs() {
		return attributs;
	}
	public void setAttributs(List<Attribut> attributs) {
		this.attributs = attributs;
	}
}
