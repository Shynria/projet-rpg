package rpg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import rpg.model.Inventaire;

public interface IInventiaireDaoJpaRepository extends JpaRepository<Inventaire, Integer> {

}
