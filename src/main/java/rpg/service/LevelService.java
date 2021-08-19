package rpg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rpg.dao.ILevelDaoJpaRepository;
import rpg.model.Level;

@Service
public class LevelService {
	@Autowired
	private ILevelDaoJpaRepository levelDao;
	
	public void createLevel(Level level){
		levelDao.save(level);
	}
}
