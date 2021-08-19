package rpg;

import java.lang.invoke.SwitchPoint;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
		//createMonstre(em, new Attribut(18, 15, 8, 12, "monstre"), new Bestiaire(2, "tortue carnivore", 35));
		//findAllHeros(em);
		//createLevel(em, new Level(900, 0));
		
		//rpg.model.Hero.creationHero(em);
		//rpg.model.Hero.partirEnExpedition(em);
		
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
//		Random R = new Random();
//		int nb = R.nextInt(20) + 100;
//		System.out.println(nb);
		
		em.close();
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
