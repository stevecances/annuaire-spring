package fr.cances.steve.annuaire.spring.model.service.impl.validation.constraint;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintValidatorContext.ConstraintViolationBuilder;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import fr.cances.steve.annuaire.spring.model.persistence.dao.GeneralDao;
import fr.cances.steve.annuaire.spring.model.persistence.entity.IEntity;
import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.AbstractVo;
import fr.cances.steve.annuaire.spring.model.service.impl.validation.constraint.UniqueField.Column;
import fr.cances.steve.annuaire.spring.support.logger.Logger;
import fr.cances.steve.annuaire.spring.support.logger.LoggerFactory;

/**
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
public class UniqueFieldValidator implements ConstraintValidator<UniqueField, AbstractVo<?>> {

    /** Logger */
    private static final Logger LOGGER = LoggerFactory.getLogger(UniqueFieldValidator.class);

    @Qualifier("GeneralDaoJpaHibernate")
    @Inject
    private GeneralDao generalDao;

    private Class<? extends IEntity<?>> entityClass;

    private Collection<String> errorFields;

    private List<String> columns;

    private Map<String, String> columnsEntityAttribut;

    private Map<String, String> columnsVoAttribut;

    @Override
    public void initialize(final UniqueField constraintAnnotation) {

        this.entityClass = constraintAnnotation.entityClass();
        this.errorFields = Lists.newArrayList(constraintAnnotation.errorFields());
        this.columns = Lists.newArrayList();
        this.columnsVoAttribut = Maps.newHashMap();
        this.columnsEntityAttribut = Maps.newHashMap();
        for (final Column column : constraintAnnotation.columns()) {
            final String name = column.name();
            String voAttributName = column.voAttributName();
            String entityAttributName = column.entityAttributName();
            if (StringUtils.isBlank(voAttributName)) {
                voAttributName = name;
            }
            if (StringUtils.isBlank(entityAttributName)) {
                entityAttributName = name;
            }
            columns.add(name);
            columnsEntityAttribut.put(name, entityAttributName);
            columnsVoAttribut.put(name, voAttributName);
        }
    }

    @Override
    public boolean isValid(final AbstractVo<?> target,
            final ConstraintValidatorContext constraintValidatorContext) {

        Boolean isValid = false;

        try {

            final Class<?> voValidationClass = target.getClass();

            final Map<String, Object> columnNamesValues = Maps.newHashMap();

            for (final String column : columns) {
                final PropertyDescriptor desc = new PropertyDescriptor(this.columnsVoAttribut.get(column), voValidationClass);
                final Method readMethod = desc.getReadMethod();
                final Object propertyValue = readMethod.invoke(target);
                columnNamesValues.put(this.columnsEntityAttribut.get(column),
                        propertyValue);
            }

            isValid = CollectionUtils.isEmpty(this.generalDao.findAllByFields(entityClass,
                    columnNamesValues));
            if (!isValid) {
                constraintValidatorContext.disableDefaultConstraintViolation();
                if (CollectionUtils.isEmpty(this.errorFields)) {
                    this.errorFields.addAll(this.columns);
                }
                for (final String errorField : errorFields) {
                    final ConstraintViolationBuilder constraintViolationBuilder = constraintValidatorContext
                            .buildConstraintViolationWithTemplate(constraintValidatorContext.getDefaultConstraintMessageTemplate());
                    constraintViolationBuilder.addPropertyNode(errorField).addConstraintViolation();
                }
            }
            return isValid;

        } catch (IllegalAccessException | IllegalArgumentException
                | InvocationTargetException | IntrospectionException e) {

            LOGGER.error(e, "Erreur instrospection UniqueFieldValidator");

            return isValid;
        }

    }
}
