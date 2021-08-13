package rpg.daoJpa;

import java.util.List;

import rpg.dao.IInventaireDao;
import rpg.model.Inventaire;
import rpg.model.Level;

public class InventaireDaoJpa extends AbstractDaoJpa<Inventaire> implements IInventaireDao {

	@Override
	public List<Inventaire> findAll() {

		return em.createQuery("select i from Inventaire i", Inventaire.class).getResultList();
	}

	@Override
	public Inventaire findById(Integer id) {
		//return em.find(Inventaire.class, id);
		return em.createQuery("select i from Inventaire i where i.id=?1", Inventaire.class)
				.setParameter(1, id)
				.getSingleResult();
	}
}
