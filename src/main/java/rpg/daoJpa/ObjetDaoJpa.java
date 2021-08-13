package rpg.daoJpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import rpg.dao.IObjetDao;
import rpg.model.Objet;

public class ObjetDaoJpa implements IObjetDao{

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("EShopUnit");
	protected EntityManager em = emf.createEntityManager();
	
	@Override
	public List<Objet> findAll() {
		return em.createQuery("select o from Objet o", Objet.class).getResultList();
	}

	@Override
	public Objet findById(Integer id) {
		return em.find(Objet.class, id);
	}

	@Override
	public Objet insert(Objet entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		return entity;
	}

	@Override
	public Objet update(Objet entity) {
		em.getTransaction().begin();
		entity = em.merge(entity);
		em.getTransaction().commit();
		return entity;
	}

	@Override
	public Objet save(Objet entity) {
		if (entity.getIdObjet() > 0) {
			return update(entity);
		} else {
			return insert(entity);
		}
	}

	@Override
	public void delete(Objet entity) {
		em.getTransaction().begin();
		em.remove(em.merge(entity));
		em.getTransaction().commit();
		
	}

	@Override
	public void deleteById(Integer id) {
		Objet monObjetASupprimer = this.findById(id);
		this.delete(monObjetASupprimer);
		
	}
	
}
