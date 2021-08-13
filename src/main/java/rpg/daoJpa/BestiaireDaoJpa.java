package rpg.daoJpa;

import java.util.List;

import rpg.dao.IBestiaireDao;
import rpg.model.Bestiaire;

public class BestiaireDaoJpa extends AbstractDaoJpa<Bestiaire> implements IBestiaireDao {

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

}
