package rpg.service;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rpg.dao.IAttributDaoJpaRepository;
import rpg.dao.IBestiaireDaoJpaRepository;
import rpg.model.Attribut;
import rpg.model.Bestiaire;

@Service
public class BestiaireService {
	@Autowired
	private IBestiaireDaoJpaRepository bestiaireDao;
	
	@Autowired
	private IAttributDaoJpaRepository AttributDao;
	
	
	public void createMonstre(Attribut attribut, Bestiaire monstre){
		monstre.setAttribut(attribut);
		AttributDao.save(attribut);
		bestiaireDao.save(monstre);
	}
}
