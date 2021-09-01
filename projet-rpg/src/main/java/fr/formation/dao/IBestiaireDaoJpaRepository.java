package fr.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Bestiaire;

public interface IBestiaireDaoJpaRepository extends JpaRepository<Bestiaire, Integer> {
	public List<Bestiaire> findByLevel (int id);
}
