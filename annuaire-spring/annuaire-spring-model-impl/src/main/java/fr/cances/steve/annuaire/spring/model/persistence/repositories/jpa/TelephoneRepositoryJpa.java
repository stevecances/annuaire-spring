package fr.cances.steve.annuaire.spring.model.persistence.repositories.jpa;

import org.springframework.stereotype.Repository;

import fr.cances.steve.annuaire.spring.model.persistence.entities.Telephone;
import fr.cances.steve.annuaire.spring.model.persistence.repositories.TelephoneRepository;

/**
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
@Repository
public class TelephoneRepositoryJpa extends AbstractRepositoryJpa<Telephone, Long> implements TelephoneRepository {

    /**
     * @author Steve Cancès
     * @Since 1.0.0
     * @param entityClass
     */
    public TelephoneRepositoryJpa(final Class<Telephone> entityClass) {
        super(entityClass);
    }

    /**
     * @author Steve Cancès
     * @Since 1.0.0
     */
    public TelephoneRepositoryJpa() {
        this(Telephone.class);
    }

}
