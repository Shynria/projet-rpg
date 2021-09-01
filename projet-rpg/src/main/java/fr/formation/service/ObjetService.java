package fr.formation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.dao.IObjetDaoJpaRepository;
import fr.formation.model.Objet;

@Service
public class ObjetService {
	@Autowired
	private IObjetDaoJpaRepository objetDao;
	
	public void createObjet(Objet objet) {
		objetDao.save(objet);
	}
}
