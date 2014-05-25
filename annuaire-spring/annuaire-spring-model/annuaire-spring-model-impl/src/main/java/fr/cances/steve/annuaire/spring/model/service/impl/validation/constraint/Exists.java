package fr.cances.steve.annuaire.spring.model.service.impl.validation.constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import fr.cances.steve.annuaire.spring.model.persistence.entity.IEntity;
import fr.cances.steve.annuaire.spring.model.service.impl.validation.group.ConstraintGroup;

/**
 * Vérifie que l'enregistrement du type de l'entity existe bien pour la valeur
 * du champs. Validée par {@link ExistsValidator}.
 * 
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ExistsValidator.class)
@Documented
public @interface Exists {

    /**
     * La classe de l'entity {@link IEntity} concernée.
     * 
     * @return La classe de l'entity {@link IEntity} concernée.
     */
    public Class<? extends IEntity<?>> entityClass();

    /**
     * Le nom du champs sur lequel repose l'existance de l'enregistrement.
     * 
     * @return Le nom du champs sur lequel repose l'existance de
     *         l'enregistrement.
     */
    public String entityFieldName();

    /**
     * Le message associé à la contrainte.
     * 
     * @return Le message associé à la contrainte.
     */
    public String message() default "{com.atos.pilotage.process.validation.constraint.Exists.message}";

    /**
     * Les groupes {@link ConstraintGroup} associés à la contrainte.
     * 
     * @return Les groupes associés à la contrainte.
     */
    public Class<? extends ConstraintGroup>[] groups() default {};

    /**
     * Les {@link Payload} associés à la contrainte.
     * 
     * @return Les {@link Payload} associés à la contrainte.
     */
    public Class<? extends Payload>[] payload() default {};

}
