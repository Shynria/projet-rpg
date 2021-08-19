package rpg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rpg.dao.IObjetDaoJpaRepository;
import rpg.model.Objet;

@Service
public class ObjetService {
	@Autowired
	private IObjetDaoJpaRepository objetDao;
	
	public void createObjet(Objet objet) {
		objetDao.save(objet);
	}
}
