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
		
		//rpg.model.Hero.creationHero(em);
		rpg.model.Hero.partirEnExpedition(em);
		
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
		Attribut monAttribut = new Attribut(10, 13, 6, 9, "monstre");
		Bestiaire monstre1 = new Bestiaire(2, "sanglier", 30, monAttribut);
		
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
