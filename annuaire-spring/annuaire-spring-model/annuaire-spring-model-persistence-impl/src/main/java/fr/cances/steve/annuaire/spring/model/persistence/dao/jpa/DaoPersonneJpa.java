package fr.cances.steve.annuaire.spring.model.persistence.dao.jpa;

import java.util.Collection;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import fr.cances.steve.annuaire.spring.model.persistence.dao.DaoPersonne;
import fr.cances.steve.annuaire.spring.model.persistence.entity.Personne;

/**
 * Repository JPA gérant l'entity {@link Personne}.
 * 
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
@Repository
public class DaoPersonneJpa extends AbstractDaoJpa<Personne, Long> implements DaoPersonne {

    /**
     * Constructeur par defaut.
     * 
     * @author Steve Cancès
     * @since 1.0.0
     */
    public DaoPersonneJpa() {
        super(Personne.class);
    }

    @Override
    public Collection<Personne> findPersonnesLikePrenomOrNom(final String like) {
        TypedQuery<Personne> query = this.entityManager.createQuery("From Personne p where p.nom like:like OR p.prenom like:like", this.domainClass);
        query.setParameter("like", "%" + like + "%");
        return query.getResultList();
    }

}
