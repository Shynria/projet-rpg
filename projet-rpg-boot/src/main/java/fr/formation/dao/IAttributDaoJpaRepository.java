package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Attribut;
import fr.formation.model.Hero;

public interface IAttributDaoJpaRepository extends JpaRepository<Attribut, Integer>{
    public Attribut findByHero(Hero hero);
}
