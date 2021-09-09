package fr.formation.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.api.Views;
import fr.formation.dao.IBestiaireDaoJpaRepository;
import fr.formation.dao.IHeroDaoJpaRepository;
import fr.formation.model.Bestiaire;
import fr.formation.model.Hero;
import fr.formation.model.Rencontre;
import fr.formation.model.Repos;
import fr.formation.service.InstanceService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private InstanceService sauvegarde;

    @Autowired
    private IHeroDaoJpaRepository daoHero;

    @Autowired
    private IBestiaireDaoJpaRepository daoBestiaire;

    @GetMapping("/combat_difficile")
    @JsonView(Views.Rencontre.class)
    public Rencontre combat() {

        Hero monHero = sauvegarde.getMonHeroAJouer();
        int PourcentPvPerdu;
        double pvPerdu;
        Random R = new Random();

        List<Bestiaire> monstres = daoBestiaire.findAllByLevel(monHero.getNiveau() + 1);
        Bestiaire monstreRandom = monstres.get(ThreadLocalRandom.current().nextInt(0, monstres.size() - 1));

        PourcentPvPerdu = R.nextInt(30) + 40;
        pvPerdu = monHero.getPvMax() * ((double) PourcentPvPerdu / 100);
        int pvPerduRound = (int) Math.round(pvPerdu);

        Rencontre rencontre = new Rencontre(pvPerduRound, monstreRandom);

        monHero.setPvActuel(monHero.getPvActuel() - pvPerduRound);
        BigDecimal thuneconverti = new BigDecimal(monstreRandom.getThune());
        monHero.setArgent(monHero.getArgent().add(thuneconverti));
        monHero.setXp(monHero.getXp() + monstreRandom.getXpDonnee());
        daoHero.save(monHero);

        sauvegarde.setMonHeroAJouer(monHero);
        return rencontre;
    }

    @GetMapping("/combat_moyen")
    @JsonView(Views.Rencontre.class)
    public Rencontre combat_moyen() {

        Hero monHero = sauvegarde.getMonHeroAJouer();
        int PourcentPvPerdu;
        double pvPerdu;
        Random R = new Random();

        List<Bestiaire> monstres = daoBestiaire.findAllByLevel(monHero.getNiveau());
        Bestiaire monstreRandom = monstres.get(ThreadLocalRandom.current().nextInt(0, monstres.size() - 1));

        PourcentPvPerdu = R.nextInt(20) + 30;
        pvPerdu = monHero.getPvMax() * ((double) PourcentPvPerdu / 100);
        int pvPerduRound = (int) Math.round(pvPerdu);

        Rencontre rencontre = new Rencontre(pvPerduRound, monstreRandom);

        monHero.setPvActuel(monHero.getPvActuel() - pvPerduRound);
        BigDecimal thuneconverti = new BigDecimal(monstreRandom.getThune());
        monHero.setArgent(monHero.getArgent().add(thuneconverti));
        monHero.setXp(monHero.getXp() + monstreRandom.getXpDonnee());
        daoHero.save(monHero);

        sauvegarde.setMonHeroAJouer(monHero);
        return rencontre;
    }

    @GetMapping("/combat_facile")
    @JsonView(Views.Rencontre.class)
    public Rencontre combat_facile() {
        Hero monHero = sauvegarde.getMonHeroAJouer();
        int PourcentPvPerdu;
        double pvPerdu;
        Random R = new Random();
        Rencontre rencontre = new Rencontre();
        if (monHero.getNiveau() > 1) {
            List<Bestiaire> monstres = daoBestiaire.findAllByLevel(monHero.getNiveau() - 1);
            Bestiaire monstreRandom = monstres.get(ThreadLocalRandom.current().nextInt(0, monstres.size() - 1));

            PourcentPvPerdu = R.nextInt(20) + 30;
            pvPerdu = monHero.getPvMax() * ((double) PourcentPvPerdu / 100);
            int pvPerduRound = (int) Math.round(pvPerdu);

            rencontre.setPvPerdu(pvPerduRound);
            rencontre.setMonstreRencontré(monstreRandom);

            monHero.setPvActuel(monHero.getPvActuel() - pvPerduRound);
            BigDecimal thuneconverti = new BigDecimal(monstreRandom.getThune());
            monHero.setArgent(monHero.getArgent().add(thuneconverti));
            monHero.setXp(monHero.getXp() + monstreRandom.getXpDonnee());
            daoHero.save(monHero);

        } else {
            List<Bestiaire> monstres = daoBestiaire.findAllByLevel(monHero.getNiveau());
            Bestiaire monstreRandom = monstres.get(ThreadLocalRandom.current().nextInt(0, monstres.size() - 1));

            PourcentPvPerdu = 5 + R.nextInt(15);
            pvPerdu = monHero.getPvMax() * ((double) PourcentPvPerdu / 100);
            int pvPerduRound = (int) Math.round(pvPerdu);

            rencontre.setPvPerdu(pvPerduRound);
            rencontre.setMonstreRencontré(monstreRandom);

            monHero.setPvActuel(monHero.getPvActuel() - pvPerduRound);
            BigDecimal thuneconverti = new BigDecimal(monstreRandom.getThune());
            monHero.setArgent(monHero.getArgent().add(thuneconverti));
            monHero.setXp(monHero.getXp() + monstreRandom.getXpDonnee());
            daoHero.save(monHero);
        }
        return rencontre;
    }

    @GetMapping("/taverne")
    public Repos taverne() {

        Hero monHero = sauvegarde.getMonHeroAJouer();
        Random R = new Random();
        int PourcentPvGagne = R.nextInt(20) + 80;
        int pvGagne = monHero.getPvMax() * ((int) (double) PourcentPvGagne / 100);
        int pvGagneRound = (int) Math.round(pvGagne);
        BigDecimal argentPerduTaverne = new BigDecimal(5);

        Repos repos = new Repos(pvGagneRound, argentPerduTaverne);

        monHero.setPvActuel(monHero.getPvActuel() + pvGagneRound);
        monHero.setArgent(monHero.getArgent().subtract(argentPerduTaverne));

        daoHero.save(monHero);
        return repos;
    }

    @GetMapping("/tente")
    public Repos tente() {

        Hero monHero = sauvegarde.getMonHeroAJouer();
        Random R = new Random();
        int PourcentPvGagne = R.nextInt(20) + 30;
        int pvGagne = monHero.getPvMax() * ((int) (double) PourcentPvGagne / 100);
        int pvGagneRound = (int) Math.round(pvGagne);

        Repos repos = new Repos();
        repos.setPvRecupere(pvGagne);

        monHero.setPvActuel(monHero.getPvActuel() + pvGagneRound);

        daoHero.save(monHero);
        return repos;
    }
}
