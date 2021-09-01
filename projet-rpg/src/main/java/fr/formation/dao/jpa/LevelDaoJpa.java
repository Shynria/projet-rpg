package fr.formation.dao.jpa;

import java.util.List;

import fr.formation.dao.ILevelDao;
import fr.formation.model.Level;

public class LevelDaoJpa extends AbstractDaoJpa<Level> implements ILevelDao{
	
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

}
