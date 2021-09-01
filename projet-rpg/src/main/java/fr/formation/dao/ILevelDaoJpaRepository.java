package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Level;

public interface ILevelDaoJpaRepository extends JpaRepository<Level, Integer>{

}
