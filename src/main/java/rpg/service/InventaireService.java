package rpg.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rpg.dao.IHeroDaoJpaRepository;
import rpg.dao.IInventiaireDaoJpaRepository;
import rpg.dao.IObjetDaoJpaRepository;
import rpg.model.Hero;
import rpg.model.Inventaire;
import rpg.model.Objet;

@Service
public class InventaireService {
	@Autowired
	private IInventiaireDaoJpaRepository inventaireDao;
	
	@Autowired
	private IObjetDaoJpaRepository objetDao;
	
	@Autowired
	private IHeroDaoJpaRepository heroDao;
	
	@Transactional
	public void voirMonInventaire(){
	System.out.println("Veuillez saisir le nom de votre hero :");
	Scanner clavier = new Scanner(System.in);
	String saisie = clavier.nextLine();
	Hero monHero = heroDao.findByNom(saisie);
	List<Objet> mesObjets = monHero.getInventaire().getObjets();
	
	System.out.println("votre inventaire contient :");
	inventaireDao.findById(monHero.getInventaire().getId());
	for(Objet o : mesObjets){
		System.out.println(o.getNom());
		}
	}
	
	@Transactional
	public void ajouterObjetDansInventaire(int idInventaire, int idObjet){
		Optional<Inventaire> monInventaire = inventaireDao.findById(idInventaire);
		Optional<Objet> objetAajouter = objetDao.findById(idObjet);
		
		List<Objet> mesObjets = monInventaire.get().getObjets();
		mesObjets.add(objetAajouter.get());
		inventaireDao.save(monInventaire.get());
		
		System.out.println("votre inventaire contient :");
		inventaireDao.findById(idInventaire);
		for(Objet o : mesObjets){
			System.out.println(o.getNom());
		}
	}
}
