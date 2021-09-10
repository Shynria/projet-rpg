package fr.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.dao.IAttributDaoJpaRepository;
import fr.formation.dao.IHeroDaoJpaRepository;
import fr.formation.model.Attribut;
import fr.formation.model.Hero;
import fr.formation.service.InstanceService;

@Controller
public class LevelUpController {
    @Autowired
    private IHeroDaoJpaRepository daoHero;

    @Autowired
    private IAttributDaoJpaRepository daoAttribut;

    @Autowired
    private InstanceService sauvegarde;

    @GetMapping("/levelup")
    public String add() {
        Hero monHero = sauvegarde.getMonHeroAJouer();
        return "level-up";
    }

    @PostMapping("/levelup")
    public String add(Model model, @RequestParam int atk, @RequestParam int def, @RequestParam int agi,
            @RequestParam int vit) {
        if (atk + def + agi + vit == 5) {
            Hero monHero = sauvegarde.getMonHeroAJouer();
            
            monHero.getAttribut().setAtk(monHero.getAttribut().getAtk() + atk);
            monHero.getAttribut().setDef(monHero.getAttribut().getDef() + def);
            monHero.getAttribut().setAgi(monHero.getAttribut().getAgi() + agi);
            monHero.getAttribut().setVit(monHero.getAttribut().getVit() + vit);

            monHero.setPvMax(monHero.getPvMax() + 5 * vit);
            monHero.setPvActuel(monHero.getPvMax());
            daoAttribut.save(monHero.getAttribut());
            daoHero.save(monHero);
            return "redirect:/accueil";
        } else {
            return "level-up";
        }

    }
}