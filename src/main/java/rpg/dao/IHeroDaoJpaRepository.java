package rpg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import rpg.model.Hero;

public interface IHeroDaoJpaRepository extends JpaRepository<Hero, Integer> {
	public Hero findFirstByOrderById();
	
	public Hero findByNom(String nom);
}
