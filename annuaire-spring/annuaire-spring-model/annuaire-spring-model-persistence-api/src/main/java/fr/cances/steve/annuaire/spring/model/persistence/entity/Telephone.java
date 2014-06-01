package fr.cances.steve.annuaire.spring.model.persistence.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Entity représentant un numéro de téléphone.
 * 
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
@Entity
public class Telephone extends AbstractEntity<Long> implements IEntity<Long>, Serializable {

    /**
     * L'identifiant technique.
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * Le numéro de téléphone.
     */
    @Column(nullable = false)
    private String telephone;

    /**
     * La personne propriétaire du numéro de téléphone.
     */
    @ManyToOne(optional = false)
    private Personne personne;

    /**
     * @return the id
     */
    @Override
    public Long getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    @Override
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * @return the telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone
     *            the telephone to set
     */
    public void setTelephone(final String telephone) {
        this.telephone = telephone;
    }

    /**
     * @return the personne
     */
    public Personne getPersonne() {
        return personne;
    }

    /**
     * @param personne
     *            the personne to set
     */
    public void setPersonne(final Personne personne) {
        this.personne = personne;
    }

    /**
     * Builder de {@link Telephone}.
     * 
     * @author Steve Cancès
     * @version 1.0.0
     * @since 1.0.0
     */
    public static class Builder {

        /**
         * Le pojo géré par le {@code Builder}
         */
        private final Telephone pojo;

        private Builder() {
            this.pojo = new Telephone();
        }

        /**
         * Retourne une instance du builder.
         * 
         * @author Steve Cancès
         * @since 1.0.0
         * @return Une instance du {@code Builder}.
         */
        public static Builder newInstance() {
            return new Builder();
        }

        /**
         * @author Steve Cancès
         * @since 1.0.0
         * @param id
         *            L'id.
         * @return Le {@code Builder} pour chainer les appels.
         */
        public Builder withId(final Long id) {
            this.pojo.id = id;
            return this;
        }

        /**
         * @author Steve Cancès
         * @since 1.0.0
         * @param telephone
         *            Le telephone.
         * @return Le {@code Builder} pour chainer les appels.
         */
        public Builder withTelephone(final String telephone) {
            this.pojo.telephone = telephone;
            return this;
        }

        /**
         * @author Steve Cancès
         * @since 1.0.0
         * @param personne
         *            La personne.
         * @return Le {@code Builder} pour chainer les appels.
         */
        public Builder withPersonne(final Personne personne) {
            this.pojo.personne = personne;
            return this;
        }

        /**
         * Retourne l'objet {@code Telephone} construit.
         * 
         * @author Steve Cancès
         * @since 1.0.0
         * @return Retourne l'objet {@code Telephone} construit.
         */
        public Telephone build() {
            return this.pojo;
        }
    }

}
