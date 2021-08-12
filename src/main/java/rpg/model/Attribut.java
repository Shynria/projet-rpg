package rpg.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "attribut")
public class Attribut {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ATR_ID")
	private int id;
	
	@Column(name = "ATR_ATTACK", precision = 5 ,nullable = false)
	private int atk;
	
	@Column(name = "ATR_DEFENSE", precision = 5 ,nullable = false)
	private int def;
	
	@Column(name = "ATR_VITALITY", precision = 5 ,nullable = false)
	private int vit;
	
	@Column(name = "ATR_AGILITY", precision = 5 ,nullable = false)
	private int agi;
	
	@Column(name = "ATR_TYPE", length = 50, nullable = false)
	private String type;
	
	@OneToMany (mappedBy = "idAttribut")
	private List<Objet> objets;
	
	@OneToOne
	@JoinColumn(name = "ATR_MONSTRE")
	private Bestiaire monstre;
	
	@OneToOne
	@JoinColumn(name = "ATR_HERO")
	private Hero hero;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getAtk() {
		return atk;
	}
	public void setAtk(int atk) {
		this.atk = atk;
	}
	
	public int getDef() {
		return def;
	}
	public void setDef(int def) {
		this.def = def;
	}
	
	public int getVit() {
		return vit;
	}
	public void setVit(int vit) {
		this.vit = vit;
	}
	
	public int getAgi() {
		return agi;
	}
	public void setAgi(int agi) {
		this.agi = agi;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public List<Objet> getObjets() {
		return objets;
	}
	public void setObjets(List<Objet> objets) {
		this.objets = objets;
	}
	
	public Attribut() {
		super();
	}
	public Attribut(int atk, int def, int vit, int agi, String type) {
		super();
		this.atk = atk;
		this.def = def;
		this.vit = vit;
		this.agi = agi;
		this.type = type;
	}
	public Attribut(int id, int atk, int def, int vit, int agi, String type) {
		super();
		this.id = id;
		this.atk = atk;
		this.def = def;
		this.vit = vit;
		this.agi = agi;
		this.type = type;
	}
	
	
}
