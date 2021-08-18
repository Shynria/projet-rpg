package rpg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import rpg.model.Bestiaire;

public interface IBestiaireDaoJpaRepository extends JpaRepository<Bestiaire, Integer> {

}
