package rpg.daoJpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import rpg.dao.IInventaireDao;
import rpg.model.Inventaire;

public class InventaireDaoJpa implements IInventaireDao {

	protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("EShopUnit");
	protected EntityManager em = emf.createEntityManager();
	
	public static void close(){
		emf.close();
	}

	@Override
	public List<Inventaire> findAll() {

		return em.createQuery("select i from Inventaire i", Inventaire.class).getResultList();
	}

	@Override
	public Inventaire findById(Integer id) {
		return em.createQuery("select i from inventaire i where i.idInventaire=?1", Inventaire.class).setParameter(1, id)
				.getSingleResult();
	}

	@Override
	public Inventaire insert(Inventaire entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		return entity;
	}

	@Override
	public Inventaire update(Inventaire entity) {
		em.getTransaction().begin();
		entity = em.merge(entity);
		em.getTransaction().commit();
		return entity;
	}

	@Override
	public Inventaire save(Inventaire entity) {
		if (entity.getIdInventaire() > 0) {
			return this.update(entity);
		} else {
			return this.insert(entity);
		}

	}

	@Override
	public void delete(Inventaire entity) {
		em.getTransaction().begin();
		em.remove(em.merge(entity));
		em.getTransaction().commit();
	}

	@Override
	public void deleteById(Integer id) {
		Inventaire monInventaireASupprimer = this.findById(id);
		this.delete(monInventaireASupprimer);
	}

}
