package rpg.daoJpa;

import java.util.List;


import rpg.dao.IAttributDao;
import rpg.model.Attribut;

public class AttributDaoJpa extends AbstractDaoJpa<Attribut> implements IAttributDao {
	
	
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

}
