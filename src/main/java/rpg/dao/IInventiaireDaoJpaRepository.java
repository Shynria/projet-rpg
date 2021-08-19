package rpg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rpg.model.Inventaire;
import rpg.model.Objet;

public interface IInventiaireDaoJpaRepository extends JpaRepository<Inventaire, Integer> {
}
