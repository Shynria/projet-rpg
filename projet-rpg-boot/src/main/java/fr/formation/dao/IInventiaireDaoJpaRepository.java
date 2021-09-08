package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Inventaire;

public interface IInventiaireDaoJpaRepository extends JpaRepository<Inventaire, Integer> {
}
