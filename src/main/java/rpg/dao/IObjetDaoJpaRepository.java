package rpg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import rpg.model.Objet;

public interface IObjetDaoJpaRepository extends JpaRepository<Objet, Integer>{
	public Objet findByNom(String nom);

}
