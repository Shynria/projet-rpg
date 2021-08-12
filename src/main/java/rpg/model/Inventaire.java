package rpg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "inventaire")
public class Inventaire {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "INVENTAIRE_ID_OBJET", nullable = false)
	private int IdObjet;
	@Column(name = "INVENTAIRE_QUANTITE", nullable = false)
	private int quantite;
	@Column(name = "INVENTAIRE_NOM", length = 50)
	private String nom;

	public Inventaire() {

	}

	public Inventaire(int quantite, String nom) {
		this.quantite = quantite;
		this.nom = nom;
	}

	public int getIdObjet() {
		return IdObjet;
	}

	public void setIdObjet(int idObjet) {
		IdObjet = idObjet;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
