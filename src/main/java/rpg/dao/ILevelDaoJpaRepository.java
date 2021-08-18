package rpg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import rpg.model.Level;

public interface ILevelDaoJpaRepository extends JpaRepository<Level, Integer>{

}
