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
import fr.formation.dao.ILevelDaoJpaRepository;
import fr.formation.model.Bestiaire;
import fr.formation.model.Hero;
import fr.formation.model.Level;
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

    @Autowired
    private ILevelDaoJpaRepository daoLevel;

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

        Level niveau = daoLevel.findById(monHero.getNiveau()).get();

        if (monHero.getXp() >= niveau.getPointXP()) {
            monHero.setNiveau(monHero.getNiveau() + 1);
            monHero.setXp(monHero.getXp() - niveau.getPointXP());
            rencontre.setLevelUp(true);
        }

        if(monHero.getPvActuel()<=0) {
            rencontre.setMort(true);
        }

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

        int def = monHero.getAttribut().getDef()-10;
        if (def > 0) {
            do {
                pvPerduRound=pvPerduRound-(int)(0.1*monHero.getPvMax());
                def = def -5;
            }while(def > 5);
        }
        if(pvPerduRound < 0){
            pvPerduRound = 0;
        }

        monHero.setPvActuel(monHero.getPvActuel() - pvPerduRound);
        BigDecimal thuneconverti = new BigDecimal(monstreRandom.getThune());
        monHero.setArgent(monHero.getArgent().add(thuneconverti));
        monHero.setXp(monHero.getXp() + monstreRandom.getXpDonnee());
        daoHero.save(monHero);

        Level niveau = daoLevel.findById(monHero.getNiveau()).get();

        if (monHero.getXp() >= niveau.getPointXP()) {
            monHero.setNiveau(monHero.getNiveau() + 1);
            monHero.setXp(monHero.getXp() - niveau.getPointXP());
            rencontre.setLevelUp(true);
        }

        if(monHero.getPvActuel()<=0) {
            rencontre.setMort(true);
        }

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
            rencontre.setMonstreRencontre(monstreRandom);

            monHero.setPvActuel(monHero.getPvActuel() - pvPerduRound);
            BigDecimal thuneconverti = new BigDecimal(monstreRandom.getThune());
            monHero.setArgent(monHero.getArgent().add(thuneconverti));
            monHero.setXp(monHero.getXp() + monstreRandom.getXpDonnee());

            Level niveau = daoLevel.findById(monHero.getNiveau()).get();

            if (monHero.getXp() >= niveau.getPointXP()) {
                monHero.setNiveau(monHero.getNiveau() + 1);
                monHero.setXp(monHero.getXp() - niveau.getPointXP());
                rencontre.setLevelUp(true);
            }

            if(monHero.getPvActuel()<=0) {
                rencontre.setMort(true);
            }

            daoHero.save(monHero);

        } else {
            List<Bestiaire> monstres = daoBestiaire.findAllByLevel(monHero.getNiveau());
            Bestiaire monstreRandom = monstres.get(ThreadLocalRandom.current().nextInt(0, monstres.size() - 1));

            PourcentPvPerdu = 5 + R.nextInt(15);
            pvPerdu = monHero.getPvMax() * ((double) PourcentPvPerdu / 100);
            int pvPerduRound = (int) Math.round(pvPerdu);

            rencontre.setPvPerdu(pvPerduRound);
            rencontre.setMonstreRencontre(monstreRandom);

            monHero.setPvActuel(monHero.getPvActuel() - pvPerduRound);
            BigDecimal thuneconverti = new BigDecimal(monstreRandom.getThune());
            monHero.setArgent(monHero.getArgent().add(thuneconverti));
            monHero.setXp(monHero.getXp() + monstreRandom.getXpDonnee());

            Level niveau = daoLevel.findById(monHero.getNiveau()).get();

            if (monHero.getXp() >= niveau.getPointXP()) {
                monHero.setNiveau(monHero.getNiveau() + 1);
                monHero.setXp(monHero.getXp() - niveau.getPointXP());
                rencontre.setLevelUp(true);
            }

            if(monHero.getPvActuel()<=0) {
                rencontre.setMort(true);
            }

            daoHero.save(monHero);
        }
        return rencontre;
    }

    @GetMapping("/taverne")
    @JsonView(Views.Repos.class)
    public Repos taverne() {

        Hero monHero = sauvegarde.getMonHeroAJouer();
        Random R = new Random();
        int PourcentPvGagne = R.nextInt(20) + 80;
        double pvGagne = monHero.getPvMax() * ((double) PourcentPvGagne / 100);
        int pvGagneRound = (int) Math.round(pvGagne);
        BigDecimal argentPerduTaverne = new BigDecimal(5);

        Repos repos = new Repos(pvGagneRound, argentPerduTaverne);

        monHero.setPvActuel(monHero.getPvActuel() + pvGagneRound);
        monHero.setArgent(monHero.getArgent().subtract(argentPerduTaverne));

        if (monHero.getPvActuel() > monHero.getPvMax()) {
            monHero.setPvActuel(monHero.getPvMax());
        }

        daoHero.save(monHero);
        return repos;
    }

    @GetMapping("/tente")
    @JsonView(Views.Repos.class)
    public Repos tente() {

        Hero monHero = sauvegarde.getMonHeroAJouer();
        Random R = new Random();
        int PourcentPvGagne = R.nextInt(20) + 30;
        double pvGagne = monHero.getPvMax() * ((double) PourcentPvGagne / 100);
        int pvGagneRound = (int) Math.round(pvGagne);

        Repos repos = new Repos();
        repos.setPvRecupere(pvGagneRound);

        monHero.setPvActuel(monHero.getPvActuel() + pvGagneRound);
        if (monHero.getPvActuel() > monHero.getPvMax()) {
            monHero.setPvActuel(monHero.getPvMax());
        }

        daoHero.save(monHero);
        return repos;
    }
}
