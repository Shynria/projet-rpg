package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Attribut;

public interface IAttributDaoJpaRepository extends JpaRepository<Attribut, Integer>{

}
