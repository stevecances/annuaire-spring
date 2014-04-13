package fr.cances.steve.annuaire.spring.model.persistence.repositories.jpa;

import java.util.Collection;

import javax.persistence.TypedQuery;

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

	public Collection<Personne> findPersonnesLikePrenomOrNom(String like) {
		TypedQuery<Personne> query = this.entityManager.createQuery("From Personne p where p.nom like:like OR p.prenom like:like", this.domainClass);
		query.setParameter("like", "%"+like+"%");
		return query.getResultList();
	}

}
