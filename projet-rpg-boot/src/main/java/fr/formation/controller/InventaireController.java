package fr.formation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.dao.IAttributDaoJpaRepository;
import fr.formation.dao.IHeroDaoJpaRepository;
import fr.formation.dao.IInventiaireDaoJpaRepository;
import fr.formation.dao.ILevelDaoJpaRepository;
import fr.formation.dao.IObjetDaoJpaRepository;
import fr.formation.model.Hero;
import fr.formation.model.Inventaire;
import fr.formation.model.Objet;
import fr.formation.service.InstanceService;

@Controller
public class InventaireController {
    @Autowired
    private InstanceService sauvegarde;

    @Autowired
    private ILevelDaoJpaRepository daoLevel;

    @Autowired
    private IHeroDaoJpaRepository daoHero;

    @Autowired
    private IObjetDaoJpaRepository daoObjet;

    @Autowired
    private IInventiaireDaoJpaRepository daoInventaire;

    @Autowired
    private IAttributDaoJpaRepository daoAttribut;



    @GetMapping("/inventaire")
    public String accueil(Model model) {
        Hero hero = sauvegarde.getMonHeroAJouer();
        model.addAttribute("hero", daoHero.findById(hero.getId()).get());

        model.addAttribute("levels", daoLevel.findAll());

        List<Objet> objets = hero.getInventaire().getObjets();
        model.addAttribute("objets", objets);

        return "inventaire";
    }

    @GetMapping("/equiper-objet")
    public String add(Model model, @RequestParam int id) {
        Hero hero = sauvegarde.getMonHeroAJouer();
        daoHero.save(hero);
        List<Objet> objets = hero.getInventaire().getObjets();

        Objet objetAequiper = null;

        for (Objet o : objets) {
            if (o.getId() == id) {
                objetAequiper = o;
                break;
            }
        }
        if (objetAequiper != null) {
            if (objetAequiper.getType().equals("arme")) {
                hero.setArme(objetAequiper);
                objets.remove(objetAequiper);

                if (objetAequiper.getAttribut().equals("atk")) {
                    hero.getAttribut().setAtk(hero.getAttribut().getAtk() + objetAequiper.getChangement());

                    daoInventaire.save(hero.getInventaire());
                    daoAttribut.save(hero.getAttribut());
                    daoHero.save(hero);
                }

                if (objetAequiper.getAttribut().equals("def")) {
                    hero.getAttribut().setDef(hero.getAttribut().getDef() + objetAequiper.getChangement());

                    daoInventaire.save(hero.getInventaire());
                    daoAttribut.save(hero.getAttribut());
                    daoHero.save(hero);
                }

                if (objetAequiper.getAttribut().equals("agi")) {
                    hero.getAttribut().setAgi(hero.getAttribut().getAgi() + objetAequiper.getChangement());

                    daoInventaire.save(hero.getInventaire());
                    daoAttribut.save(hero.getAttribut());
                    daoHero.save(hero);
                }

            }
            if (objetAequiper.getType().equals("armure")) {
                hero.setArmure(objetAequiper);
                objets.remove(objetAequiper);

                if (objetAequiper.getAttribut().equals("atk")) {
                    hero.getAttribut().setAtk(hero.getAttribut().getAtk() + objetAequiper.getChangement());

                    daoInventaire.save(hero.getInventaire());
                    daoAttribut.save(hero.getAttribut());
                    daoHero.save(hero);
                }

                if (objetAequiper.getAttribut().equals("def")) {
                    hero.getAttribut().setDef(hero.getAttribut().getDef() + objetAequiper.getChangement());

                    daoInventaire.save(hero.getInventaire());
                    daoAttribut.save(hero.getAttribut());
                    daoHero.save(hero);
                }

                if (objetAequiper.getAttribut().equals("agi")) {
                    hero.getAttribut().setAgi(hero.getAttribut().getAgi() + objetAequiper.getChangement());

                    daoInventaire.save(hero.getInventaire());
                    daoAttribut.save(hero.getAttribut());
                    daoHero.save(hero);
                }
            }
            if (objetAequiper.getType().equals("bijoux")) {
                hero.setBijoux(objetAequiper);
                objets.remove(objetAequiper);

                if (objetAequiper.getAttribut().equals("atk")) {
                    hero.getAttribut().setAtk(hero.getAttribut().getAtk() + objetAequiper.getChangement());

                    daoInventaire.save(hero.getInventaire());
                    daoAttribut.save(hero.getAttribut());
                    daoHero.save(hero);
                }

                if (objetAequiper.getAttribut().equals("def")) {
                    hero.getAttribut().setDef(hero.getAttribut().getDef() + objetAequiper.getChangement());

                    daoInventaire.save(hero.getInventaire());
                    daoAttribut.save(hero.getAttribut());
                    daoHero.save(hero);
                }

                if (objetAequiper.getAttribut().equals("agi")) {
                    hero.getAttribut().setAgi(hero.getAttribut().getAgi() + objetAequiper.getChangement());

                    daoInventaire.save(hero.getInventaire());
                    daoAttribut.save(hero.getAttribut());
                    daoHero.save(hero);
                }
            }
        }

        return "redirect:/inventaire";
    }

    @GetMapping("/retirer-objet")
    public String remove(Model model, @RequestParam int id) {
        Hero hero = sauvegarde.getMonHeroAJouer();
        daoHero.save(hero);
        List<Objet> objets = hero.getInventaire().getObjets();

        Inventaire inventaire = hero.getInventaire();

        Objet objetAretirer = daoObjet.findById(id).get();
        model.addAttribute("hero", daoHero.findById(hero.getId()).get());
        if (objetAretirer.getType().equals("arme")) {
            if (hero.getArme() != null) {

                if (objetAretirer.getAttribut().equals("atk")) {
                    hero.getAttribut().setAtk(hero.getAttribut().getAtk() - objetAretirer.getChangement());

                    hero.setArme(null);
                    objets.add(objetAretirer);
                    // inventaire.getObjets().add(objetAretirer);
                    hero.getInventaire().setObjets(objets);
                    daoInventaire.save(inventaire);
                    daoAttribut.save(hero.getAttribut());
                    daoHero.save(hero);
                }

                if (objetAretirer.getAttribut().equals("def")) {
                    hero.getAttribut().setDef(hero.getAttribut().getDef() - objetAretirer.getChangement());

                    hero.setArme(null);
                    objets.add(objetAretirer);
                    // inventaire.getObjets().add(objetAretirer);
                    hero.getInventaire().setObjets(objets);
                    daoInventaire.save(inventaire);
                    daoAttribut.save(hero.getAttribut());
                    daoHero.save(hero);
                }

                if (objetAretirer.getAttribut().equals("agi")) {
                    hero.getAttribut().setAgi(hero.getAttribut().getAgi() - objetAretirer.getChangement());

                    hero.setArme(null);
                    objets.add(objetAretirer);
                    // inventaire.getObjets().add(objetAretirer);
                    hero.getInventaire().setObjets(objets);
                    daoInventaire.save(inventaire);
                    daoAttribut.save(hero.getAttribut());
                    daoHero.save(hero);
                }

            }
        }
        if (objetAretirer.getType().equals("armure")) {
            if (hero.getArmure() != null) {

                if (objetAretirer.getAttribut().equals("atk")) {
                    hero.getAttribut().setAtk(hero.getAttribut().getAtk() - objetAretirer.getChangement());

                    hero.setArmure(null);
                    objets.add(objetAretirer);
                    // inventaire.getObjets().add(objetAretirer);
                    hero.getInventaire().setObjets(objets);
                    daoInventaire.save(inventaire);
                    daoAttribut.save(hero.getAttribut());
                    daoHero.save(hero);
                }

                if (objetAretirer.getAttribut().equals("def")) {
                    hero.getAttribut().setDef(hero.getAttribut().getDef() - objetAretirer.getChangement());

                    hero.setArmure(null);
                    objets.add(objetAretirer);
                    // inventaire.getObjets().add(objetAretirer);
                    hero.getInventaire().setObjets(objets);
                    daoInventaire.save(inventaire);
                    daoAttribut.save(hero.getAttribut());
                    daoHero.save(hero);
                }

                if (objetAretirer.getAttribut().equals("agi")) {
                    hero.getAttribut().setAgi(hero.getAttribut().getAgi() - objetAretirer.getChangement());

                    hero.setArmure(null);
                    objets.add(objetAretirer);
                    // inventaire.getObjets().add(objetAretirer);
                    hero.getInventaire().setObjets(objets);
                    daoInventaire.save(inventaire);
                    daoAttribut.save(hero.getAttribut());
                    daoHero.save(hero);
                }

            }
        }
        if (objetAretirer.getType().equals("bijoux")) {
            if (hero.getBijoux() != null) {

                if (objetAretirer.getAttribut().equals("atk")) {
                    hero.getAttribut().setAtk(hero.getAttribut().getAtk() - objetAretirer.getChangement());

                    hero.setBijoux(null);
                    objets.add(objetAretirer);
                    // inventaire.getObjets().add(objetAretirer);
                    hero.getInventaire().setObjets(objets);
                    daoInventaire.save(inventaire);
                    daoAttribut.save(hero.getAttribut());
                    daoHero.save(hero);
                }

                if (objetAretirer.getAttribut().equals("def")) {
                    hero.getAttribut().setDef(hero.getAttribut().getDef() - objetAretirer.getChangement());

                    hero.setBijoux(null);
                    objets.add(objetAretirer);
                    // inventaire.getObjets().add(objetAretirer);
                    hero.getInventaire().setObjets(objets);
                    daoInventaire.save(inventaire);
                    daoAttribut.save(hero.getAttribut());
                    daoHero.save(hero);
                }

                if (objetAretirer.getAttribut().equals("agi")) {
                    hero.getAttribut().setAgi(hero.getAttribut().getAgi() - objetAretirer.getChangement());

                    hero.setBijoux(null);
                    objets.add(objetAretirer);
                    // inventaire.getObjets().add(objetAretirer);
                    hero.getInventaire().setObjets(objets);
                    daoInventaire.save(inventaire);
                    daoAttribut.save(hero.getAttribut());
                    daoHero.save(hero);
                }

            }
        }

        return "redirect:/inventaire";
    }

    @GetMapping("utiliser-potion")
    public String potion(Model model, @RequestParam int id){
        Hero hero = sauvegarde.getMonHeroAJouer();
        daoHero.save(hero);
        List<Objet> objets = hero.getInventaire().getObjets();

        Inventaire inventaire = hero.getInventaire();

        model.addAttribute("hero", daoHero.findById(hero.getId()).get());

        Objet potion = null;
        int pvRendu = 0;

        for (Objet o : objets) {
            if (o.getId() == id) {
                potion = o;
                break;
            }
        }
        if (potion != null) {
            pvRendu = hero.getPvActuel() + potion.getPvRendu();
            hero.setPvActuel(pvRendu);
            if(pvRendu > hero.getPvMax()){
                hero.setPvActuel(hero.getPvMax());
            }
        objets.remove(potion);

        daoInventaire.save(hero.getInventaire());
        daoAttribut.save(hero.getAttribut());
        daoHero.save(hero);
        }

        return "redirect:/inventaire";
    }

}
