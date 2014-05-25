package fr.cances.steve.annuaire.spring.model.persistence.dao.jpa;

import org.springframework.stereotype.Repository;

import fr.cances.steve.annuaire.spring.model.persistence.dao.DaoTelephone;
import fr.cances.steve.annuaire.spring.model.persistence.entity.Telephone;

/**
 * Repository JPA gérant l'entity {@link Telephone}.
 * 
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
@Repository
public class DaoTelephoneJpa extends AbstractDaoJpa<Telephone, Long> implements DaoTelephone {

    /**
     * Constructeur par defaut.
     * 
     * @author Steve Cancès
     * @since 1.0.0
     */
    public DaoTelephoneJpa() {
        super(Telephone.class);
    }

}
