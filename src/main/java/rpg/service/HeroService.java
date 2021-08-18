package rpg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rpg.dao.IBestiaireDao;
import rpg.dao.IBestiaireDaoJpaRepository;
import rpg.dao.IHeroDao;
import rpg.dao.IHeroDaoJpaRepository;
import rpg.daoJpa.BestiaireDaoJpa;
import rpg.daoJpa.HeroDaoJpa;
import rpg.model.Bestiaire;
import rpg.model.Hero;

@Service
public class HeroService {
	@Autowired
	private IHeroDaoJpaRepository heroDao;
	
	@Autowired
	private IBestiaireDaoJpaRepository bestiaireDao;
	
	//Ici vous pouvez récupérer tout ce qui est managée par SPRING : DAO, Services, etc.
	
	public void partirEnExpedition(){
		System.out.println("Veuillez saisir l'id de votre hero :");
		Scanner clavier1 = new Scanner(System.in);
		int saisieId = clavier1.nextInt();
		Hero monHero = heroDao.findById(saisieId).get();
		System.out.println("hero selectionne : " + monHero.getNom());
		
		System.out.println("choisir une difficulte : \n1. dangereuse\t2. moyenne\t3. facile");
		int saisie = clavier1.nextInt();
		
		List<Bestiaire> monstres = new ArrayList<>();
		int PourcentPvPerdu;
		double pvPerdu;
		Random R = new Random();
		
		switch (saisie) {
		case 1:
			int recherche = monHero.getNiveau()+1;
			for (Bestiaire b : bestiaireDao.findAll()){
				if(b.getLevel() == recherche){
					monstres.add(b);
				}
			}
			Bestiaire monstreRandom = monstres.get(ThreadLocalRandom.current().nextInt(0,monstres.size() - 1));
			System.out.println("monstre rencontré : " + monstreRandom.getNom());
			PourcentPvPerdu = R.nextInt(30) + 40;
			pvPerdu = monHero.getPvMax() * ((double)PourcentPvPerdu/100);
			int pvPerduRound = (int) Math.round(pvPerdu);
			monHero.setPvActuel(monHero.getPvActuel() - pvPerduRound);
			monHero.setXp(monHero.getXp() + monstreRandom.getXpDonnee());
			break;
		case 2:
			int recherche2 = monHero.getNiveau();
			for (Bestiaire b : bestiaireDao.findAll()){
				if(b.getLevel() == recherche2){
					monstres.add(b);
				}
			}
			Bestiaire monstreRandom2 = monstres.get(ThreadLocalRandom.current().nextInt(0,monstres.size() - 1));
			System.out.println("monstre rencontré : " + monstreRandom2.getNom());
			PourcentPvPerdu = R.nextInt(20) + 30;
			pvPerdu = monHero.getPvMax() * ((double)PourcentPvPerdu/100);
			pvPerduRound = (int) Math.round(pvPerdu);
			monHero.setPvActuel(monHero.getPvMax() - pvPerduRound);
			monHero.setXp(monHero.getXp() + monstreRandom2.getXpDonnee());
			break;
		case 3:
			if(monHero.getNiveau()>1){
			int recherche3 = monHero.getNiveau()-1;
			for (Bestiaire b : bestiaireDao.findAll()){
				if(b.getLevel() == recherche3){
					monstres.add(b);
				}
			}
			Bestiaire monstreRandom3 = monstres.get(ThreadLocalRandom.current().nextInt(0,monstres.size() - 1));
			System.out.println("monstre rencontré : " + monstreRandom3.getNom());
			PourcentPvPerdu = 5 + R.nextInt(15);
			pvPerdu = monHero.getPvMax() * ((double)PourcentPvPerdu/100);
			pvPerduRound = (int) Math.round(pvPerdu);
			monHero.setPvActuel(monHero.getPvActuel() - pvPerduRound);
			monHero.setXp(monHero.getXp() + monstreRandom3.getXpDonnee());
			}
			else {
				int recherche3 = monHero.getNiveau();
				for (Bestiaire b : bestiaireDao.findAll()){
					if(b.getLevel() == recherche3){
						monstres.add(b);
					}
				}
				Bestiaire monstreRandom3 = monstres.get(ThreadLocalRandom.current().nextInt(0,monstres.size() - 1));
				System.out.println("monstre rencontré : " + monstreRandom3.getNom());
				PourcentPvPerdu = 30 + R.nextInt(20);
				pvPerdu = monHero.getPvMax() * ((double)PourcentPvPerdu/100);
				pvPerduRound = (int) Math.round(pvPerdu);
				monHero.setPvActuel(monHero.getPvActuel() - pvPerduRound);
				monHero.setXp(monHero.getXp() + monstreRandom3.getXpDonnee());
			}
			
			break;
		}
		heroDao.save(monHero);
		System.out.println("il vous reste "+ monHero.getPvActuel()+ " HP");
		System.out.println("vous avez maintenant "+ monHero.getXp()+ " XP");
		//Attribut monAttribut = monHero.getAttribut();
		//monAttribut.attributLevelUp(em, monHero);
	}
}