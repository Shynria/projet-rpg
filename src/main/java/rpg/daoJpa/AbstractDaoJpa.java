package rpg.daoJpa;

import java.lang.reflect.Method;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class AbstractDaoJpa <T>{

	// creation entity manager factory
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("EShopUnit");

	// creation entity manager
	protected EntityManager em = emf.createEntityManager();
	//pour que les classes qui h�rite de AbstractDaoJpa aieny quand m�me acc�s � em
	
	// permet de fermer l'EMF et les EM associ�s � l'EMF
	public static void close(){
		emf.close();
	}
	
	public T insert(T entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();

		return entity;
	}
	
	public T update(T entity) {
		em.getTransaction().begin();
		entity = em.merge(entity);
		em.getTransaction().commit();

		return entity;
	}
	
	public void delete(T entity) {
		// d�marrage transaction
		em.getTransaction().begin();

		// on attache a entityManager avant de supprimer au cas ou l'entit�
		// n'est pas d�j� manag�e
		em.remove(em.merge(entity));

		// commit de la transaction
		em.getTransaction().commit();
	}

	public T save(T entity) { 
		int entityId = 0;
		
		try {
			//on a r�cup�rer la methode de la classe
			Method method = entity.getClass().getMethod("getId");
			
			//on invoque, on execute cette methode sur l'instance qui nous interesse
			Object result = method.invoke(entity);
			
			entityId = (Integer)result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(entityId > 0){ //update
			return this.update(entity);
		}
		else { //insert
			return this.insert(entity);
		}
		
	}
	public abstract T findById(Integer id);
	
	public void deleteById(Integer id) {
		T monEntiteAsupprimer = this.findById(id);
		this.delete(monEntiteAsupprimer);
	}
}
