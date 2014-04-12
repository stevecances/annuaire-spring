package fr.cances.steve.annuaire.spring.model.persistence.repositories;

import java.util.Collection;

import fr.cances.steve.annuaire.spring.model.persistence.entities.Personne;

public interface PersonneRepository extends AbstractRepository<Personne, Long> {
	
	/**
	 * Retourne l'ensemble des personnes de l'annuaire dont le nom match avec %like% ou le prénom match avec %like%
	 * 
	 * @author Steve Cancès
	 * @Since 1.0.0
	 * 
	 * @param like La chaine like
	 * @return l'ensemble des personnes de l'annuaire dont le nom match avec %like% ou le prénom match avec %like%
	 */
	public Collection<Personne> findPersonnesLikePrenomOrNom(String like);
}
