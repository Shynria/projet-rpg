package rpg;

import java.lang.invoke.SwitchPoint;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.management.monitor.MonitorSettingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.omg.PortableServer.IdAssignmentPolicyOperations;

import rpg.dao.IInventaireDao;
import rpg.dao.IObjetDao;
import rpg.daoJpa.InventaireDaoJpa;
import rpg.daoJpa.ObjetDaoJpa;
import rpg.model.Attribut;
import rpg.model.Bestiaire;
import rpg.model.Hero;
import rpg.model.Inventaire;
import rpg.model.Level;
import rpg.model.Objet;

public class RpgApplication {

	public static void main(String[] args) {
		// creation entity manager factory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EShopUnit");

		// creation entity manager
		EntityManager em = emf.createEntityManager();
		
		//createHero(em);
		//createObjet(em);
		//createMonstre(em);
		//findAllHeros(em);
		creationHero(em);
		
//		IInventaireDao daoInventaire = new InventaireDaoJpa();
//		IObjetDao daoObjet = new ObjetDaoJpa();
//		
//		System.out.println(daoInventaire.findById(1).getId() + " - " + daoInventaire.findById(1).getObjets());
//		
//		daoObjet.findAll();
//		
//		for (Objet o : daoObjet.findAll()){
//			System.out.println(o.getNom()+ " - " + o.getType());
//		}
//		
		
		em.close();
	}
	
	public static void creationHero(EntityManager em){
		System.out.println("-- creation d'un hero : --");
		
		Hero monHero = new Hero();
		monHero.setNiveau(1);
		monHero.setArgent(new BigDecimal(20));
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
	
	
	public static void findAllHeros(EntityManager em) {

		List<Hero> mesHeros = em
			
			.createQuery("SELECT h FROM Hero h where h.idHero > ?1", Hero.class)
			.setParameter(1, 0)
			.getResultList();
		
		for (Hero h : mesHeros) {
			System.out.println(h.getNom());
		}
	}
	
	public static void createMonstre(EntityManager em){
		Attribut monAttribut = new Attribut(1, 1, 1, 1, "monstre");
		Bestiaire monstre1 = new Bestiaire(1, "blob malade", monAttribut);
		
		em.getTransaction().begin();
		em.persist(monAttribut);
		em.persist(monstre1);
		em.getTransaction().commit();
	}
	
	public static void createObjet(EntityManager em){
		List<Objet> objets = new ArrayList<>();
		Objet monObjet = new Objet("epee molle", "atk", 1,new BigDecimal(2));
		monObjet.setLevel(1);
		objets.add(monObjet);
		Inventaire inventaire1 = new Inventaire();
		inventaire1.setObjets(objets);
		
		em.getTransaction().begin();
		em.persist(monObjet);
		em.persist(inventaire1);
		em.getTransaction().commit();
		
	}
	
	public static void createHero(EntityManager em){
		Attribut monAttribut = new Attribut(10, 10, 10, 10, "hero");
		//Level monLevel = new Level(50, 0);
		Hero monHero = new Hero(1, "zafiria", monAttribut, new BigDecimal(10), 1);
		Inventaire inventaire1 = new Inventaire();
		inventaire1.setHero(monHero);
		
		em.getTransaction().begin();
		em.persist(monAttribut);
		em.persist(monHero);
		em.persist(inventaire1);
		em.getTransaction().commit();
		
	}

}
