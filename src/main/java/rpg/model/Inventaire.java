package rpg.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import rpg.dao.IInventaireDao;
import rpg.dao.IObjetDao;
import rpg.daoJpa.InventaireDaoJpa;
import rpg.daoJpa.ObjetDaoJpa;

@Entity
@Table(name = "inventaire")
public class Inventaire {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "INVENTAIRE_ID", nullable = false)
	private int id;
	
	@ManyToMany
	@JoinTable(
			name = "INVENTAIRE_OBJET",
			joinColumns = @JoinColumn(name = "ID_INVENTAIRE", referencedColumnName = "INVENTAIRE_ID"),
			inverseJoinColumns = @JoinColumn(name = "ID_OBJET", referencedColumnName = "OBJET_ID"))
	private List<Objet> objets;
	
	@OneToOne
	@JoinColumn(name = "INVENTAIRE_HERO")
	private Hero hero;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Objet> getObjets() {
		return objets;
	}
	public void setObjets(List<Objet> objets) {
		this.objets = objets;
	}
	public Hero getHero() {
		return hero;
	}
	public void setHero(Hero hero) {
		this.hero = hero;
	}
	
	public Inventaire(List<Objet> objets, Hero hero) {
		super();
		this.objets = objets;
		this.hero = hero;
	}
	public Inventaire() {
		super();
	}
	
	
//	public void ListeObjetInventaire(int id){
//		IInventaireDao daoInventaire = new InventaireDaoJpa();
//		IObjetDao daoObjet = new ObjetDaoJpa();
//		
//		System.out.println(daoInventaire.findById(id).getId() + " " + daoInventaire.findById(id).getObjets());
//		
//		daoObjet.findAll();
//		
//		for (Objet o : daoObjet.findAll()){
//			System.out.println(o.getNom()+ " - " + o.getType());
//		}
//	}

}
