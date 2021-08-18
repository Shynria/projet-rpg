package rpg.model;


import java.util.Scanner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	
	@OneToOne(mappedBy = "attribut")
	private Bestiaire monstre;
	
	@OneToOne(mappedBy = "attribut")
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
	
	public Bestiaire getMonstre() {
		return monstre;
	}
	public void setMonstre(Bestiaire monstre) {
		this.monstre = monstre;
	}
	public Hero getHero() {
		return hero;
	}
	public void setHero(Hero hero) {
		this.hero = hero;
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
	public Attribut(String type) {
		super();
		this.type = type;
	}
	
	public boolean attributLevelUp(EntityManager em, Hero monHero){
		System.out.println("-- vous avez level up ! --\nvous avez 5 point d'attribut à répartir :");
		Scanner clavier1 = new Scanner(System.in);
		
		System.out.println("stats d'attaque :");
		System.out.println("vous avez " + monHero.getAttribut().getAtk() + " Atk\nvous ajoutez :");
		int ptAtk = clavier1.nextInt();
		
		System.out.println("stats de defence :");
		System.out.println("vous avez " + monHero.getAttribut().getDef() + " Def\nvous ajoutez :");
		int ptDef = clavier1.nextInt();
		
		
		System.out.println("stats d'agilite :");
		System.out.println("vous avez " + monHero.getAttribut().getAgi() + " Agi\nvous ajoutez :");
		int ptAgi = clavier1.nextInt();
		
		
		System.out.println("stats de vitalite :");
		System.out.println("vous avez " + monHero.getAttribut().getVit() + " vit\nvous ajoutez :");
		int ptVit = clavier1.nextInt();
		
		if(ptAtk+ptDef+ptAgi+ptVit != 5){
			System.out.println("veuillez recommencer");
			return false;
		}else{
		monHero.getAttribut().setAtk(monHero.getAttribut().getAtk() + ptAtk);
		monHero.getAttribut().setDef(monHero.getAttribut().getDef() + ptDef);
		monHero.getAttribut().setAgi(monHero.getAttribut().getAgi() + ptAgi);
		monHero.getAttribut().setVit(monHero.getAttribut().getVit() + ptVit);
		monHero.setPvMax(monHero.getPvMax() + 5*ptVit);
		
		System.out.println("-- Attributs modifiés ! --");
		
		em.getTransaction().begin();
		em.persist(monHero);
		em.getTransaction().commit();
		return true;
		}
	}
}
