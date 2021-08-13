package rpg.daoJpa;

import java.util.List;

import rpg.dao.IObjetDao;
import rpg.model.Objet;

public class ObjetDaoJpa  extends AbstractDaoJpa<Objet> implements IObjetDao{
	
	@Override
	public List<Objet> findAll() {
		return em.createQuery("select o from Objet o", Objet.class).getResultList();
	}

	@Override
	public Objet findById(Integer id) {
		return em.find(Objet.class, id);
	}
}
