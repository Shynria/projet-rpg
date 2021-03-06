package fr.formation.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.dao.IAttributDaoJpaRepository;
import fr.formation.dao.IBestiaireDao;
import fr.formation.dao.IBestiaireDaoJpaRepository;
import fr.formation.dao.IHeroDao;
import fr.formation.dao.IHeroDaoJpaRepository;
import fr.formation.dao.IInventiaireDaoJpaRepository;
import fr.formation.dao.ILevelDaoJpaRepository;
import fr.formation.dao.IObjetDaoJpaRepository;
import fr.formation.dao.jpa.BestiaireDaoJpa;
import fr.formation.dao.jpa.HeroDaoJpa;
import fr.formation.model.Attribut;
import fr.formation.model.Bestiaire;
import fr.formation.model.Hero;
import fr.formation.model.Inventaire;
import fr.formation.model.Level;
import fr.formation.model.Objet;

@Service
public class HeroService {
	@Autowired
	private IHeroDaoJpaRepository heroDao;
	
	@Autowired
	private IObjetDaoJpaRepository objetDao;
	
	@Autowired
	private IBestiaireDaoJpaRepository bestiaireDao;
	
	@Autowired
	private ILevelDaoJpaRepository levelDao;
	
	@Autowired
	private IAttributDaoJpaRepository AttributDao;
	
	@Autowired
	private IInventiaireDaoJpaRepository inventaireDao;
	
	//Ici vous pouvez r?cup?rer tout ce qui est manag?e par SPRING : DAO, Services, etc.
	
	public void voirMonEquipement(Hero hero){
		System.out.println("vous ?tes equipe de :");
		System.out.println("arme :");
		if (hero.getArme() == null) {
			System.out.println("vide");
		} else {
			System.out.println(hero.getArme());
		}
		System.out.println("armure :");
		if (hero.getArmure() == null) {
			System.out.println("vide");
		} else {
			System.out.println(hero.getArmure());
		}
		System.out.println("bijoux :");
		if (hero.getBijoux() == null) {
			System.out.println("vide");
		} else {
			System.out.println(hero.getBijoux());
		}
	}
	@Transactional
	public void equiperObjet() {
		System.out.println("-- Veuillez saisir le nom de votre hero : --");
		Scanner clavier = new Scanner(System.in);
		String saisie = clavier.nextLine();
		Hero monHero = heroDao.findByNom(saisie);
		List<Objet> mesObjets = monHero.getInventaire().getObjets();
		
		voirMonEquipement(monHero);

		System.out.println("votre inventaire contient :");
		inventaireDao.findById(monHero.getInventaire().getId());
		for (Objet o : mesObjets) {
			System.out.println(o.getId() + " - " + o.getNom());
		}
		System.out.println("saisir le nom de l'objet que vous voulez equiper :");
		String saisie2 = clavier.nextLine();
		Objet objetAequiper = objetDao.findByNom(saisie2);
		if(objetAequiper.getType()=="arme"){
			monHero.setArme(objetAequiper);
		}else if(objetAequiper.getType()=="armure"){
			monHero.setArmure(objetAequiper);
		}else if(objetAequiper.getType()=="bijoux"){
			monHero.setBijoux(objetAequiper);
		}else{
			System.out.println("objet inexixtant");
		}
	}
	
	public void createHero() {
		Attribut attribut = new Attribut("hero");
		Hero monHero = new Hero();
		Inventaire inventaire = new Inventaire();
		Scanner clavier = new Scanner(System.in);
		Scanner clavierInt = new Scanner(System.in);
		System.out.println("Creation de votre heros !!" + "\n" + "Choissisez votre nom : ");

		String nom = clavier.nextLine();
		monHero.setNom(nom);
		System.out.println("Veuillez repartir vos 10 points d'attributs: ");

		System.out.println("stats d'attaque :");
		System.out.println("vous avez 10 Atk\nvous ajoutez :");
		int ptAtk = clavierInt.nextInt();

		System.out.println("stats de defence :");
		System.out.println("vous avez 10 Def\nvous ajoutez :");
		int ptDef = clavierInt.nextInt();

		System.out.println("stats d'agilite :");
		System.out.println("vous avez 10 Agi\nvous ajoutez :");
		int ptAgi = clavierInt.nextInt();

		System.out.println("stats de vitalite :");
		System.out.println("vous avez 10 Vit\nvous ajoutez :");
		int ptVit = clavierInt.nextInt();

		if (ptAtk + ptDef + ptAgi + ptVit != 10) {
			System.out.println("veuillez recommencer");
		} else {
			attribut.setAtk(10 + ptAtk);
			attribut.setDef(10 + ptDef);
			attribut.setAgi(10 + ptAgi);
			attribut.setVit(10 + ptVit);
			monHero.setPvMax(20 + 5 * ptVit);
			int pvMax = 20 + 5 * ptVit;
			monHero.setPvActuel(pvMax);
			System.out.println("-- Hero cree ! --");
			monHero.setAttribut(attribut);

			monHero.setNiveau(1);
			monHero.setArgent(new BigDecimal(20));
			monHero.setXp(0);
			inventaire.setHero(monHero);

		}
		AttributDao.save(attribut);
		heroDao.save(monHero);
		inventaireDao.save(inventaire);
		
		System.out.println(monHero.getNom() + "\nAtk\tDef\tAgi\tVit\n" + 
				monHero.getAttribut().getAtk() + "\t" + monHero.getAttribut().getDef() + "\t" 
				+ monHero.getAttribut().getAgi() + "\t" + monHero.getAttribut().getVit());
	}
	
	public void repos(){
		System.out.println("Veuillez saisir l'id de votre hero :");
		Scanner clavier1 = new Scanner(System.in);
		int saisieId = clavier1.nextInt();
		Hero monHero = heroDao.findById(saisieId).get();
		
		System.out.println("pour vous reposer, vous evez deux choix :");
		System.out.println("1. camper (gratuit)\t2. l'auberge (5 or)");
		Scanner clavier = new Scanner(System.in);
		int saisie = clavier.nextInt();
		Random R = new Random();
		BigDecimal prix = new BigDecimal(5);
		int PourcentPvGagne;
		double pvGagne;
		
		switch (saisie) {
		case 1:
			PourcentPvGagne = R.nextInt(20) + 30;
			pvGagne = monHero.getPvMax() * ((double)PourcentPvGagne/100);
			int pvGagneRound = (int) Math.round(pvGagne);
			monHero.setPvActuel(monHero.getPvActuel() + pvGagneRound);	
			break;

		case 2:
			PourcentPvGagne = R.nextInt(20) + 80;
			pvGagne = monHero.getPvMax() * ((double)PourcentPvGagne/100);
			pvGagneRound = (int) Math.round(pvGagne);
			monHero.setPvActuel(monHero.getPvActuel() + pvGagneRound);
			monHero.setArgent(monHero.getArgent().subtract(prix));
			break;
		}
		if(monHero.getPvActuel()>monHero.getPvMax()){
			monHero.setPvActuel(monHero.getPvMax());
		}
		heroDao.save(monHero);
		System.out.println("il vous reste " + monHero.getArgent() + " or");
		System.out.println("vous ?tes ? " + monHero.getPvActuel() + " PV");
	}

	public void partirEnExpedition(){
		System.out.println("Veuillez saisir l'id de votre hero :");
		Scanner clavier1 = new Scanner(System.in);
		int saisieId = clavier1.nextInt();
		Hero monHero = heroDao.findById(saisieId).get();
		System.out.println("hero selectionne : " + monHero.getNom());
		
		System.out.println("choisir une difficulte : \n1. dangereuse\t2. moyenne\t3. facile");
		int saisie = clavier1.nextInt();
	
		int PourcentPvPerdu;
		double pvPerdu;
		Random R = new Random();
		
		switch (saisie) {
		case 1:
			int recherche = monHero.getNiveau()+1;
			List<Bestiaire> monstres = bestiaireDao.findByLevel(recherche);
			Bestiaire monstreRandom = monstres.get(ThreadLocalRandom.current().nextInt(0,monstres.size() - 1));
			System.out.println("monstre rencontr? : " + monstreRandom.getNom());
			PourcentPvPerdu = R.nextInt(30) + 40;
			pvPerdu = monHero.getPvMax() * ((double)PourcentPvPerdu/100);
			int pvPerduRound = (int) Math.round(pvPerdu);
			monHero.setPvActuel(monHero.getPvActuel() - pvPerduRound);
			monHero.setXp(monHero.getXp() + monstreRandom.getXpDonnee());
			break;
		case 2:
			recherche = monHero.getNiveau();
			monstres = bestiaireDao.findByLevel(recherche);
			Bestiaire monstreRandom2 = monstres.get(ThreadLocalRandom.current().nextInt(0,monstres.size() - 1));
			System.out.println("monstre rencontr? : " + monstreRandom2.getNom());
			PourcentPvPerdu = R.nextInt(20) + 30;
			pvPerdu = monHero.getPvMax() * ((double)PourcentPvPerdu/100);
			pvPerduRound = (int) Math.round(pvPerdu);
			monHero.setPvActuel(monHero.getPvMax() - pvPerduRound);
			monHero.setXp(monHero.getXp() + monstreRandom2.getXpDonnee());
			break;
		case 3:
			if(monHero.getNiveau()>1){
			recherche = monHero.getNiveau()-1;
			monstres = bestiaireDao.findByLevel(recherche);
			Bestiaire monstreRandom3 = monstres.get(ThreadLocalRandom.current().nextInt(0,monstres.size() - 1));
			System.out.println("monstre rencontr? : " + monstreRandom3.getNom());
			PourcentPvPerdu = 5 + R.nextInt(15);
			pvPerdu = monHero.getPvMax() * ((double)PourcentPvPerdu/100);
			pvPerduRound = (int) Math.round(pvPerdu);
			monHero.setPvActuel(monHero.getPvActuel() - pvPerduRound);
			monHero.setXp(monHero.getXp() + monstreRandom3.getXpDonnee());
			}
			else {
				recherche = monHero.getNiveau();
				monstres = bestiaireDao.findByLevel(recherche);
				Bestiaire monstreRandom3 = monstres.get(ThreadLocalRandom.current().nextInt(0,monstres.size() - 1));
				System.out.println("monstre rencontr? : " + monstreRandom3.getNom());
				PourcentPvPerdu = 30 + R.nextInt(20);
				pvPerdu = monHero.getPvMax() * ((double)PourcentPvPerdu/100);
				pvPerduRound = (int) Math.round(pvPerdu);
				monHero.setPvActuel(monHero.getPvActuel() - pvPerduRound);
				monHero.setXp(monHero.getXp() + monstreRandom3.getXpDonnee());
			}
			break;
		}
		System.out.println("il vous reste "+ monHero.getPvActuel()+ " HP");
		System.out.println("vous avez maintenant "+ monHero.getXp()+ " XP");
		levelUp(monHero);
		heroDao.save(monHero);
	}
	
	
	public void levelUp(Hero monHero){
		Optional<Level> optLevel = levelDao.findById(monHero.getNiveau());
		
		if (monHero.getXp()>= optLevel.get().getPointXP()){
			monHero.setNiveau(monHero.getNiveau() + 1);
			monHero.setXp(monHero.getXp() - (optLevel.get().getPointXP()));
			while (attributLevelUp(monHero) == false){
				System.out.println("mauvaise r?partition, try again !");
			}
		} 
	}
	

	public boolean attributLevelUp(Hero monHero){
		System.out.println("-- vous avez level up ! --\nvous avez 5 point d'attribut ? r?partir :");
		Scanner clavier1 = new Scanner(System.in);
		
		System.out.println("stats d'attaque :");
		System.out.println("vous avez " + monHero.getAttribut().getAtk() + " Atk\nvous ajoutez :");
		int ptAtk = clavier1.nextInt();
		
		System.out.println("stats de defence :");
		System.out.println("vous avez " + monHero.getAttribut().getDef() + " Def\nvous ajoutez :");
		int ptDef = clavier1.nextInt();
		
		
		System.out.println("stats d'agilite :");
		System.out.println("vous avez " + monHero.getAttribut().getAgi() + " Agi\nvous ajoutez :");
		int ptAgi = clavier1.nextInt();
		
		
		System.out.println("stats de vitalite :");
		System.out.println("vous avez " + monHero.getAttribut().getVit() + " vit\nvous ajoutez :");
		int ptVit = clavier1.nextInt();
		
		if(ptAtk+ptDef+ptAgi+ptVit != 5){
			System.out.println("veuillez recommencer");
			return false;
		}else{
		monHero.getAttribut().setAtk(monHero.getAttribut().getAtk() + ptAtk);
		monHero.getAttribut().setDef(monHero.getAttribut().getDef() + ptDef);
		monHero.getAttribut().setAgi(monHero.getAttribut().getAgi() + ptAgi);
		monHero.getAttribut().setVit(monHero.getAttribut().getVit() + ptVit);
		monHero.setPvMax(monHero.getPvMax() + 5*ptVit);
		
		System.out.println("-- Attributs modifi?s ! --");
		}return true;
	}
}