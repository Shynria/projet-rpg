package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Hero;

public interface IHeroDaoJpaRepository extends JpaRepository<Hero, Integer> {
	public Hero findFirstByOrderById();
	
	public Hero findByNom(String nom);
	
	public Hero findByNiveau(int niveau);
}
