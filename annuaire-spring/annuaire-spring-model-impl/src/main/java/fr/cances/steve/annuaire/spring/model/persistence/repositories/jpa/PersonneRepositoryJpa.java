package fr.cances.steve.annuaire.spring.model.persistence.repositories.jpa;

import java.util.Collection;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import fr.cances.steve.annuaire.spring.model.persistence.entities.Personne;
import fr.cances.steve.annuaire.spring.model.persistence.repositories.PersonneRepository;

/**
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
@Repository
public class PersonneRepositoryJpa extends AbstractRepositoryJpa<Personne, Long> implements PersonneRepository {

    /**
     * @author Steve Cancès
     * @Since 1.0.0
     * @param entityClass
     */
    public PersonneRepositoryJpa(final Class<Personne> entityClass) {
        super(entityClass);
    }

    /**
     * @author Steve Cancès
     * @Since 1.0.0
     */
    public PersonneRepositoryJpa() {
        this(Personne.class);
    }

    @Override
    public Collection<Personne> findPersonnesLikePrenomOrNom(final String like) {
        TypedQuery<Personne> query = this.entityManager.createQuery("From Personne p where p.nom like:like OR p.prenom like:like", this.domainClass);
        query.setParameter("like", "%" + like + "%");
        return query.getResultList();
    }

}
