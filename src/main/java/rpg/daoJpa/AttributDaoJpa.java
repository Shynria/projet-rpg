package rpg.daoJpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import rpg.dao.IAttributDao;
import rpg.model.Attribut;

public class AttributDaoJpa implements IAttributDao {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("EShopUnit");

	protected EntityManager em = emf.createEntityManager();
	
	public static void close(){
		emf.close();
	}

	@Override
	public List<Attribut> findAll() {
		return em
				.createQuery("select a from Attribut a", Attribut.class)
				.getResultList(); 
	}

	@Override
	public Attribut findById(Integer id) {
		return em.find(Attribut.class, id);
	}

	@Override
	public Attribut insert(Attribut entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();

		return entity;
	}

	@Override
	public Attribut update(Attribut entity) {
		em.getTransaction().begin();
		entity = em.merge(entity);
		em.getTransaction().commit();

		return entity;
	}

	@Override
	public Attribut save(Attribut entity) {
		if (entity.getId() > 0){ // update car ici deja id donc produit deja créé
			return this.update(entity);
		}
		else { // insert car ici pas d'id donc pas de produit
		return this.insert(entity);
		}
	}

	@Override
	public void delete(Attribut entity) {
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
		Attribut monAttributAsupprimer = this.findById(id);
		this.delete(monAttributAsupprimer);
	}

}
