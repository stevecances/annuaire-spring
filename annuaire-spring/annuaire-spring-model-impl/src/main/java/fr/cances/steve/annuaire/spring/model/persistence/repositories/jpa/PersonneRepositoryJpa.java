package fr.cances.steve.annuaire.spring.model.persistence.repositories.jpa;

import org.springframework.stereotype.Repository;

import fr.cances.steve.annuaire.spring.model.persistence.entities.Personne;
import fr.cances.steve.annuaire.spring.model.persistence.repositories.PersonneRepository;

@Repository
public class PersonneRepositoryJpa extends AbstractRepositoryJpa<Personne, Long> implements PersonneRepository {

	public PersonneRepositoryJpa(Class<Personne> entityClass) {
		super(entityClass);
	}
	
	public PersonneRepositoryJpa() {
		this(Personne.class);
	}

}
