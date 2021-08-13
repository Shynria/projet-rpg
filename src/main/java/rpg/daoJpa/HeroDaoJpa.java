package rpg.daoJpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import rpg.dao.IHeroDao;
import rpg.model.Hero;

public class HeroDaoJpa implements IHeroDao{

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("EShopUnit");
	protected EntityManager em = emf.createEntityManager();
	
	public static void close(){
		emf.close();
	}
	
	@Override
	public List<Hero> findAll() {	
		return em.createQuery("select h from Hero h", Hero.class).getResultList();
	}

	@Override
	public Hero findById(Integer id) {
		return em.find(Hero.class, id);
	}

	@Override
	public Hero insert(Hero entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		return entity;
	}

	@Override
	public Hero update(Hero entity) {
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
		return entity;
	}

	@Override
	public Hero save(Hero entity) {
		if (entity.getIdHero() > 0) {
			return this.update(entity);
		}
		else {
			return this.insert(entity);
		}
	}

	@Override
	public void delete(Hero entity) {
		em.getTransaction().begin();
		em.remove(em.merge(entity));
		em.getTransaction().commit();
		
	}

	@Override
	public void deleteById(Integer id) {
		Hero monHero = this.findById(id);
		this.delete(monHero);
		
		
	}
}
