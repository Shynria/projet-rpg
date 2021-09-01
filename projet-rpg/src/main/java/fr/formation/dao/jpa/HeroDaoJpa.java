package fr.formation.dao.jpa;

import java.util.List;

import fr.formation.dao.IHeroDao;
import fr.formation.model.Hero;

public class HeroDaoJpa extends AbstractDaoJpa<Hero> implements IHeroDao{

	
	@Override
	public List<Hero> findAll() {	
		return em.createQuery("select h from Hero h", Hero.class).getResultList();
	}

	@Override
	public Hero findById(Integer id) {
		return em.find(Hero.class, id);
	}
}
