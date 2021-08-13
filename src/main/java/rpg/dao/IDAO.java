package rpg.dao;

import java.util.List;

public interface IDAO<T, Id> {
	// Id est cl� primaire utilis�e

	// pour rester global
	// <T, Id> = template g�n�rique, on met T au lieu Object, on aura juste �
	// dire � quoi T correspond
	// dans les IDAO Produit et autre
	// Template permet d'eviter d'avoir type object comme on connait pas encore
	// le type concret (produit, fournisseur, ...)

	public List<T> findAll();

	public T findById(Id id);

	public T insert(T entity);

	public T update(T entity);

	public T save(T entity);

	public void delete(T entity);

	public void deleteById(Id id);

}
