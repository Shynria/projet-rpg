package rpg.daoJpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import rpg.dao.ILevelDao;
import rpg.model.Level;

public class LevelDaoJpa implements ILevelDao{

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("EShopUnit");

	protected EntityManager em = emf.createEntityManager();
	
	public static void close(){
		emf.close();
	}
	
	@Override
	public List<Level> findAll() {
		return em
				.createQuery("select l from Level l", Level.class)
				.getResultList(); 
	}

	@Override
	public Level findById(Integer id) {
		return em.find(Level.class, id);
	}

	@Override
	public Level insert(Level entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();

		return entity;
	}

	@Override
	public Level update(Level entity) {
		em.getTransaction().begin();
		entity = em.merge(entity);
		em.getTransaction().commit();

		return entity;
	}

	@Override
	public Level save(Level entity) {
		if (entity.getLevel() > 0){ // update car ici deja id donc produit deja créé
			return this.update(entity);
		}
		else { // insert car ici pas d'id donc pas de produit
		return this.insert(entity);
		}
	}

	@Override
	public void delete(Level entity) {
		// démarrage transaction
		em.getTransaction().begin();

		// on attache a entityManager avant de supprimer au cas ou l'entité
		// n'est pas déjà managée
		em.remove(em.merge(entity));

		// commit de la transaction
		em.getTransaction().commit();
	}

	@Override
	public void deleteById(Integer id) {
		Level monNiveauAsupprimer = this.findById(id);
		this.delete(monNiveauAsupprimer);
	}

}
