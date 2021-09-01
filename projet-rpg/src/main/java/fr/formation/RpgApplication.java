package fr.formation;

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

import fr.formation.dao.IInventaireDao;
import fr.formation.dao.IObjetDao;
import fr.formation.dao.jpa.InventaireDaoJpa;
import fr.formation.dao.jpa.ObjetDaoJpa;
import fr.formation.model.Attribut;
import fr.formation.model.Bestiaire;
import fr.formation.model.Hero;
import fr.formation.model.Inventaire;
import fr.formation.model.Level;
import fr.formation.model.Objet;

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
