package rpg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rpg.dao.IAttributDaoJpaRepository;
import rpg.dao.IBestiaireDao;
import rpg.dao.IBestiaireDaoJpaRepository;
import rpg.dao.IHeroDao;
import rpg.dao.IHeroDaoJpaRepository;
import rpg.dao.ILevelDaoJpaRepository;
import rpg.daoJpa.BestiaireDaoJpa;
import rpg.daoJpa.HeroDaoJpa;
import rpg.model.Attribut;
import rpg.model.Bestiaire;
import rpg.model.Hero;
import rpg.model.Level;

@Service
public class HeroService {
	@Autowired
	private IHeroDaoJpaRepository heroDao;
	
	@Autowired
	private IBestiaireDaoJpaRepository bestiaireDao;
	
	@Autowired
	private ILevelDaoJpaRepository levelDao;
	
	@Autowired
	private IAttributDaoJpaRepository AttributDao;
	
	//Ici vous pouvez r�cup�rer tout ce qui est manag�e par SPRING : DAO, Services, etc.
	

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
			
//			for (Bestiaire b : bestiaireDao.findAll()){
//				if(b.getLevel() == recherche){
//					monstres.add(b);
//				}
//			}
			Bestiaire monstreRandom = monstres.get(ThreadLocalRandom.current().nextInt(0,monstres.size() - 1));
			System.out.println("monstre rencontr� : " + monstreRandom.getNom());
			PourcentPvPerdu = R.nextInt(30) + 40;
			pvPerdu = monHero.getPvMax() * ((double)PourcentPvPerdu/100);
			int pvPerduRound = (int) Math.round(pvPerdu);
			monHero.setPvActuel(monHero.getPvActuel() - pvPerduRound);
			monHero.setXp(monHero.getXp() + monstreRandom.getXpDonnee());
			break;
		case 2:
			recherche = monHero.getNiveau();
			monstres = bestiaireDao.findByLevel(recherche);
//			for (Bestiaire b : bestiaireDao.findAll()){
//				if(b.getLevel() == recherche2){
//					monstres.add(b);
//				}
//			}
			Bestiaire monstreRandom2 = monstres.get(ThreadLocalRandom.current().nextInt(0,monstres.size() - 1));
			System.out.println("monstre rencontr� : " + monstreRandom2.getNom());
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
//			for (Bestiaire b : bestiaireDao.findAll()){
//				if(b.getLevel() == recherche3){
//					monstres.add(b);
//				}
//			}
			Bestiaire monstreRandom3 = monstres.get(ThreadLocalRandom.current().nextInt(0,monstres.size() - 1));
			System.out.println("monstre rencontr� : " + monstreRandom3.getNom());
			PourcentPvPerdu = 5 + R.nextInt(15);
			pvPerdu = monHero.getPvMax() * ((double)PourcentPvPerdu/100);
			pvPerduRound = (int) Math.round(pvPerdu);
			monHero.setPvActuel(monHero.getPvActuel() - pvPerduRound);
			monHero.setXp(monHero.getXp() + monstreRandom3.getXpDonnee());
			}
			else {
				recherche = monHero.getNiveau();
				monstres = bestiaireDao.findByLevel(recherche);
//				for (Bestiaire b : bestiaireDao.findAll()){
//					if(b.getLevel() == recherche){
//						monstres.add(b);
//					}
//				}
				Bestiaire monstreRandom3 = monstres.get(ThreadLocalRandom.current().nextInt(0,monstres.size() - 1));
				System.out.println("monstre rencontr� : " + monstreRandom3.getNom());
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
			//Attribut monAttribut = monHero.getAttribut();
			attributLevelUp(monHero);
			if (attributLevelUp(monHero) == false){
				System.out.println("mauvaise r�partition, try again !");
				attributLevelUp(monHero);
			}else{
				System.out.println("if level up true");
			}
		} 
	}
	

	public boolean attributLevelUp(Hero monHero){
		System.out.println("-- vous avez level up ! --\nvous avez 5 point d'attribut � r�partir :");
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
		
		System.out.println("-- Attributs modifi�s ! --");
		
		//heroDao.save(monHero);
		
		}return true;
	}
}