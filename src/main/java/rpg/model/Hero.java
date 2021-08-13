package rpg.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import rpg.dao.IBestiaireDao;
import rpg.dao.IHeroDao;
import rpg.daoJpa.BestiaireDaoJpa;
import rpg.daoJpa.HeroDaoJpa;

@Entity
@Table(name = "Hero")
public class Hero {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "HERO_ID", nullable = false)
	private int id;
	
	@Column(name="HERO_NIVEAU")
	private int niveau;
	
	@Column(name = "HERO_NOM", length = 50, nullable = false)
	private String nom;
	
	@OneToOne
	@JoinColumn(name = "HERO_ATR_ID")
	private Attribut attribut;
	
	@Column(name = "HERO_ARGENT", precision = 6, nullable = false)
	private BigDecimal argent;
	
	@Column(name = "HERO_PV_MAX", precision = 6)
	private int pvMax;
	
	@Column(name = "HERO_PV_ACTUEL", precision = 6)
	private int pvActuel;
	
	@Column(name = "HERO_XP", precision = 6, nullable = false)
	private int xp;
	
	@OneToOne(mappedBy = "hero")
	private Inventaire inventaire;
	
	
	public int getNiveau() {
		return niveau;
	}
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	
	public BigDecimal getArgent() {
		return argent;
	}
	public void setArgent(BigDecimal argent) {
		this.argent = argent;
	}
	
	public int getPvMax() {
		return pvMax;
	}
	public void setPvMax(int pvMax) {
		this.pvMax = pvMax;
	}
	
	public int getPvActuel() {
		return pvActuel;
	}
	public void setPvActuel(int pvActuel) {
		this.pvActuel = pvActuel;
	}
	
	public int getXp() {
		return xp;
	}
	public void setXp(int xp) {
		this.xp = xp;
	}
	
	public Inventaire getInventaire() {
		return inventaire;
	}
	public void setInventaire(Inventaire inventaire) {
		this.inventaire = inventaire;
	}
	
	
	public Hero() {
		super();
	}
	
	public Hero(int niveau, String nom, Attribut attribut, BigDecimal argent, int xp) {
		this.niveau = niveau;
		this.nom = nom;
		this.attribut = attribut;
		this.argent = argent;
		this.xp = xp;
	}
	
	public static void creationHero(EntityManager em){
		System.out.println("-- creation d'un hero : --");
		
		Hero monHero = new Hero();
		monHero.setNiveau(1);
		monHero.setArgent(new BigDecimal(20));
		monHero.setXp(0);
		System.out.println("votre nom est :");
		Scanner clavier1 = new Scanner(System.in);
		String nom = clavier1.nextLine();
		monHero.setNom(nom);
		
		System.out.println("\n-- creation des attributs : --");
		Attribut monAttribut = new Attribut("hero");
		
		Scanner clavier2 = new Scanner(System.in);
		
		System.out.println("vous avez 10 points d'attributs, veuillez les ajouter :");
		System.out.println("stats d'attaque :");
		int ptAtk = clavier2.nextInt();
		
		System.out.println("stats de defence :");
		int ptDef = clavier2.nextInt();
		
		
		System.out.println("stats d'agilite :");
		int ptAgi = clavier2.nextInt();
		
		
		System.out.println("stats de vitalite :");
		int ptVit = clavier2.nextInt();
		
		if(ptAtk+ptDef+ptAgi+ptVit > 10){
			System.out.println("veuillez recommencer");
		}else{
		monAttribut.setAtk(10+ptAtk);
		monAttribut.setDef(10+ptDef);
		monAttribut.setAgi(10+ptAgi);
		monAttribut.setVit(10+ptVit);
		monHero.setPvMax(20 + 5*ptVit);
		int pvMax = 20 + 5*ptVit;
		monHero.setPvActuel(pvMax);
		System.out.println("-- Hero cree ! --");
		monHero.setAttribut(monAttribut);
		
		Inventaire inventaire1 = new Inventaire();
		inventaire1.setHero(monHero);
		
		em.getTransaction().begin();
		em.persist(monAttribut);
		em.persist(monHero);
		em.persist(inventaire1);
		em.getTransaction().commit();
		
		System.out.println(monHero.getNom() + "\nAtk\tDef\tAgi\tVit\n" + 
				monAttribut.getAtk() + "\t" + monAttribut.getDef() + "\t" + monAttribut.getAgi() + "\t" +
				monAttribut.getVit());
		}
		
	}
	
	public static void partirEnExpedition(EntityManager em){
		IHeroDao heroDao = new HeroDaoJpa();
		IBestiaireDao bestiaireDao = new BestiaireDaoJpa();
		
		System.out.println("Veuillez saisir l'id de votre hero :");
		Scanner clavier1 = new Scanner(System.in);
		int saisieId = clavier1.nextInt();
		Hero monHero = heroDao.findById(saisieId);
		System.out.println("hero selectionne : " + monHero.getNom());
		
		System.out.println("choisir une difficulte : \n1. dangereuse\t2. moyenne\t3. facile");
		int saisie = clavier1.nextInt();
		
		List<Bestiaire> monstres = new ArrayList<>();
		int PourcentPvPerdu;
		int pvPerdu;
		
		switch (saisie) {
		case 1:
			int recherche = monHero.getNiveau()+1;
			for (Bestiaire b : bestiaireDao.findAll()){
				if(b.getLevel() == recherche){
					monstres.add(b);
				}
			}
			Bestiaire monstreRandom = monstres.get(ThreadLocalRandom.current().nextInt(0,monstres.size() - 1));
			System.out.println("monstre rencontré : " + monstreRandom.getNom());
			Random random = new Random();
			PourcentPvPerdu = 40 + random.nextInt(30);
			pvPerdu = monHero.getPvActuel() * (PourcentPvPerdu/100);
			monHero.setPvActuel(monHero.getPvActuel() - pvPerdu);
			monHero.setXp(monHero.getXp() + monstreRandom.getXpDonnee());
			break;
		case 2:
			int recherche2 = monHero.getNiveau();
			for (Bestiaire b : bestiaireDao.findAll()){
				if(b.getLevel() == recherche2){
					monstres.add(b);
				}
			}
			Bestiaire monstreRandom2 = monstres.get(ThreadLocalRandom.current().nextInt(0,monstres.size() - 1));
			System.out.println("monstre rencontré : " + monstreRandom2.getNom());
			Random random2 = new Random();
			PourcentPvPerdu = 30 + random2.nextInt(20);
			pvPerdu = monHero.getPvActuel() * (PourcentPvPerdu/100);
			monHero.setPvActuel(monHero.getPvActuel() - pvPerdu);
			monHero.setXp(monHero.getXp() + monstreRandom2.getXpDonnee());
			break;
		case 3:
			if(monHero.getNiveau()>1){
			int recherche3 = monHero.getNiveau()-1;
			for (Bestiaire b : bestiaireDao.findAll()){
				if(b.getLevel() == recherche3){
					monstres.add(b);
				}
			}
			Bestiaire monstreRandom3 = monstres.get(ThreadLocalRandom.current().nextInt(0,monstres.size() - 1));
			System.out.println("monstre rencontré : " + monstreRandom3.getNom());
			Random random3 = new Random();
			PourcentPvPerdu = 5 + random3.nextInt(15);
			pvPerdu = monHero.getPvActuel() * (PourcentPvPerdu/100);
			monHero.setPvActuel(monHero.getPvActuel() - pvPerdu);
			monHero.setXp(monHero.getXp() + monstreRandom3.getXpDonnee());
			}
			else {
				int recherche3 = monHero.getNiveau();
				for (Bestiaire b : bestiaireDao.findAll()){
					if(b.getLevel() == recherche3){
						monstres.add(b);
					}
				}
				Bestiaire monstreRandom3 = monstres.get(ThreadLocalRandom.current().nextInt(0,monstres.size() - 1));
				System.out.println("monstre rencontré : " + monstreRandom3.getNom());
				Random random3 = new Random();
				PourcentPvPerdu = 30 + random3.nextInt(20);
				pvPerdu = monHero.getPvActuel() * (PourcentPvPerdu/100);
				monHero.setPvActuel(monHero.getPvActuel() - pvPerdu);
				monHero.setXp(monHero.getXp() + monstreRandom3.getXpDonnee());
			}
			
			break;
		}
		heroDao.update(monHero);
	}
	
}
