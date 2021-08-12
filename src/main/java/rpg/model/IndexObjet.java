package rpg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "index_objet")
public class IndexObjet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "INDEX_OBJET_ID_POTION", nullable = false)
	private int idPotion;
	@Column(name = "INDEX_OBJET_NOM", length = 50)
	private String nom;
	@Column(name = "INDEX_OBJET_ID_EFFET_SOIN", nullable = false)
	private int effetSoin;

	public int getIdPotion() {
		return idPotion;
	}

	public void setIdPotion(int idPotion) {
		this.idPotion = idPotion;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getEffetSoin() {
		return effetSoin;
	}

	public void setEffetSoin(int effetSoin) {
		this.effetSoin = effetSoin;
	}

	public IndexObjet() {

	}

	public IndexObjet(String nom, int effetSoin) {
		this.nom = nom;
		this.effetSoin = effetSoin;
	}

}