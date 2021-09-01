package fr.formation.service;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.dao.IAttributDaoJpaRepository;
import fr.formation.dao.IBestiaireDaoJpaRepository;
import fr.formation.model.Attribut;
import fr.formation.model.Bestiaire;

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
