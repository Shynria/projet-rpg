package rpg.model;

import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import rpg.dao.IHeroDaoJpaRepository;
import rpg.dao.ILevelDaoJpaRepository;

@Entity
@Table(name = "level")
public class Level {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LVL_ID")
	private int id;
	
	@Column(name = "LVL_POINT_XP", precision = 5, nullable = false)
	private int pointXP;
	
	@Column(name = "LVL_BONUS", precision = 5, nullable = false)
	private int bonus;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getPointXP() {
		return pointXP;
	}
	public void setPointXP(int pointXP) {
		this.pointXP = pointXP;
	}
	
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
	public Level() {
		super();
	}
	public Level(int pointXP, int bonus) {
		super();
		this.pointXP = pointXP;
		this.bonus = bonus;
	}
	public Level(int id, int pointXP, int bonus) {
		super();
		this.id = id;
		this.pointXP = pointXP;
		this.bonus = bonus;
	}

	
	
}
