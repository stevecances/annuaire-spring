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
 * Vérifie une ou plusieurs contraintes d'unicité sur un ou plusieurs champs.
 * 
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueFieldValidator.class)
@Documented
public @interface UniqueField {

    /**
     * La classe de l'entity {@link IEntity} concernée.
     * 
     * @return La classe de l'entity {@link IEntity} concernée.
     */
    public Class<? extends IEntity<?>> entityClass();

    /**
     * Les champs en erreurs levés si la validation de la contrainte échoue. (si
     * vide : l'ensemble des champs concernés par la contrainte sont utilisés).
     * 
     * @return Les champs en erreurs levés si la validation de la contrainte
     *         échoue.
     */
    public String[] errorFields() default {};

    /**
     * Les colonnes concernées par la contrainte d'unicité.
     * 
     * @return Les colonnes concernées par la contrainte d'unicité.
     */
    public Column[] columns();

    /**
     * Le message associé à la contrainte.
     * 
     * @return Le message associé à la contrainte.
     */
    public String message() default "com.atos.pilotage.process.validation.constraint.UniqueField.message";

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

    /**
     * Une liste de contrainte {@link UniqueField}.
     * 
     * @author Steve Cancès
     * @version 1.0
     */
    @Target({ ElementType.TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface List {

        /**
         * La liste des contraintes d'unicité.
         * 
         * @return La liste des contraintes d'unicité.
         */
        UniqueField[] value();
    }

    /**
     * Une colonne concerné par la contrainte {@link UniqueField}.
     * 
     * @author Steve Cancès
     * @version 1.0
     */
    @Target({ ElementType.TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface Column {

        /**
         * Le nom de la colonne.
         * 
         * @return Le nom de la colonne.
         */
        String name();

        /**
         * Le nom de l'attribut dans le vo correspondant à la colonne.
         * <p>
         * Si non renseigné, prend la valeur de la colonne.
         * </p>
         * 
         * @return Le nom de l'attribut dans le vo correspondant à la colonne.
         */
        String voAttributName() default "";

        /**
         * Le nom de l'attribut l'entity correspondant à la colonne.
         * <p>
         * Si non renseigné, prend la valeur de la colonne.
         * </p>
         * 
         * @return Le nom de l'attribut l'entity correspondant à la colonne.
         */
        String entityAttributName() default "";
    }

}