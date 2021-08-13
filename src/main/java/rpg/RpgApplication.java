package rpg;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
		
		createHero(em);
		//createObjet(em);
		createMonstre(em);
		//findAllHeros(em);
		
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
		Attribut monAttribut = new Attribut(4, 3, 2, 2, "monstre");
		Bestiaire monstre1 = new Bestiaire(1, "blob rouge", monAttribut);
		
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
		
		em.getTransaction().begin();
		em.persist(monAttribut);
		em.persist(monHero);
		em.getTransaction().commit();
		
	}

}
