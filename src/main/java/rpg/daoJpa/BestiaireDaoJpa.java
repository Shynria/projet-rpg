package rpg.daoJpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import rpg.dao.IBestiaireDao;
import rpg.model.Bestiaire;

public class BestiaireDaoJpa implements IBestiaireDao {

	protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("EShopUnit");
	protected EntityManager em = emf.createEntityManager();
	
	public static void close(){
		emf.close();
	}

	@Override
	public List<Bestiaire> findAll() {

		return em.createQuery("select b from Bestiaire b", Bestiaire.class)
				.getResultList();
	}

	@Override
	public Bestiaire findById(Integer id) {
		return em.createQuery("select b from bestiaire b where b.id=?1", Bestiaire.class)
				.setParameter(1, id)
				.getSingleResult();
	}

	@Override
	public Bestiaire insert(Bestiaire entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		return entity;
	}

	@Override
	public Bestiaire update(Bestiaire entity) {
		em.getTransaction().begin();
		entity = em.merge(entity);
		em.getTransaction().commit();
		return entity;
	}

	@Override
	public Bestiaire save(Bestiaire entity) {
		if (entity.getId() > 0) {
			return this.update(entity);
		} else {
			return this.insert(entity);
		}

	}

	@Override
	public void delete(Bestiaire entity) {
		em.getTransaction().begin();
		em.remove(em.merge(entity));
		em.getTransaction().commit();
	}

	@Override
	public void deleteById(Integer id) {
		Bestiaire monBestiaireASupprimer = this.findById(id);
		this.delete(monBestiaireASupprimer);
	}
}
