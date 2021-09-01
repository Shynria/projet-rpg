package fr.formation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.dao.ILevelDaoJpaRepository;
import fr.formation.model.Level;

@Service
public class LevelService {
	@Autowired
	private ILevelDaoJpaRepository levelDao;
	
	public void createLevel(Level level){
		levelDao.save(level);
	}
}
