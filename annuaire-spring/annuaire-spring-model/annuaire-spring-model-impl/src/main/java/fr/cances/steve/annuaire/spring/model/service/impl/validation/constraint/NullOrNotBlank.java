package fr.cances.steve.annuaire.spring.model.service.impl.validation.constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import fr.cances.steve.annuaire.spring.model.service.impl.validation.group.ConstraintGroup;

/**
 * Verifie que la String est {@code null} ou n'est pas vide.
 * 
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NullOrNotBlankValidator.class)
@Documented
public @interface NullOrNotBlank {

    /**
     * Le message associé à la contrainte.
     * 
     * @return Le message associé à la contrainte.
     */
    public String message() default "com.atos.pilotage.process.validation.constraint.NullOrNotBlank.message";

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