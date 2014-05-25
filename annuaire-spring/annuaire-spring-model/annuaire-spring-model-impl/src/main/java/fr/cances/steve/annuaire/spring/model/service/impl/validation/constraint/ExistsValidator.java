package fr.cances.steve.annuaire.spring.model.service.impl.validation.constraint;

import java.util.Map;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Qualifier;

import com.google.common.collect.Maps;

import fr.cances.steve.annuaire.spring.model.persistence.dao.GeneralDao;
import fr.cances.steve.annuaire.spring.model.persistence.entity.IEntity;
import fr.cances.steve.annuaire.spring.support.logger.Logger;
import fr.cances.steve.annuaire.spring.support.logger.LoggerFactory;

/**
 * Validateur pour la constrainte {@link Exists}
 * 
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
public class ExistsValidator implements ConstraintValidator<Exists, Object> {

    /** Logger */
    private static final Logger LOGGER = LoggerFactory.getLogger(ExistsValidator.class);

    @Qualifier("GeneralDaoJpaHibernate")
    @Inject
    private GeneralDao generalDao;

    private Class<? extends IEntity<?>> entityClass;

    private String fieldName;

    @Override
    public void initialize(final Exists constraintAnnotation) {

        this.entityClass = constraintAnnotation.entityClass();
        this.fieldName = constraintAnnotation.entityFieldName();
    }

    @Override
    public boolean isValid(final Object value,
            final ConstraintValidatorContext context) {

        LOGGER.debug("Validation d'un contrainte Exists pour le champs %s dans l'entity %s avec la valeur %s",
                this.fieldName, this.entityClass.getSimpleName(), value);

        Boolean isValid = false;
        final Map<String, Object> columnNamesValues = Maps.newHashMap();
        columnNamesValues.put(this.fieldName, value);
        isValid = CollectionUtils.isNotEmpty(this.generalDao.findAllByFields(entityClass,
                columnNamesValues));
        return isValid;
    }

}
