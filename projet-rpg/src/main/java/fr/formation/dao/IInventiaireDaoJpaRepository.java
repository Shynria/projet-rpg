package fr.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Inventaire;
import fr.formation.model.Objet;

public interface IInventiaireDaoJpaRepository extends JpaRepository<Inventaire, Integer> {
}
