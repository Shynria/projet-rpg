package fr.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import fr.formation.dao.IAttributDaoJpaRepository;
import fr.formation.dao.IHeroDaoJpaRepository;
import fr.formation.dao.IInventiaireDaoJpaRepository;
import fr.formation.model.Hero;
import fr.formation.service.InstanceService;

@Controller
public class GameoverController {
    @Autowired
    private IHeroDaoJpaRepository daoHero;

    @Autowired
    private IAttributDaoJpaRepository daoAttribut;

    @Autowired
    private IInventiaireDaoJpaRepository daoInventaire;

    @Autowired
    private InstanceService sauvegarde;

    @GetMapping("/gameover")
    public String supp() {
        Hero monHero = sauvegarde.getMonHeroAJouer();

        daoInventaire.delete(monHero.getInventaire());
        daoHero.delete(monHero);
        daoAttribut.delete(monHero.getAttribut());
       

        sauvegarde.arreterJeux(monHero);
        return "gameover";
    }
}