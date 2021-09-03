package fr.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Objet;

public interface IObjetDaoJpaRepository extends JpaRepository<Objet, Integer>{
	public Objet findByNom(String nom);
	
	public List<Objet> findAllByLevel(int level);

}
