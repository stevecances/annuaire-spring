package fr.cances.steve.annuaire.spring.model.persistence.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Entity representant une personne.
 * 
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
@Entity
public class Personne implements IEntity<Long> {

    /** L'identifiant technique. */
    @Id
    @GeneratedValue
    private Long id;

    /** Le nom de la personne. */
    @Column(nullable = false)
    private String nom;

    /** Le prénom de la personne. */
    @Column(nullable = false)
    private String prenom;

    /** Les numéros de téléphone de la personne. */
    @OneToMany(mappedBy = "personne", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Collection<Telephone> telephones = new ArrayList<>();

    /** L'utilisateur associé au contact */
    @ManyToOne
    private Utilisateur utilisateur;

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
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom
     *            the nom to set
     */
    public void setNom(final String nom) {
        this.nom = nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom
     *            the prenom to set
     */
    public void setPrenom(final String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the telephones
     */
    public Collection<Telephone> getTelephones() {
        return telephones;
    }

    /**
     * @param telephones
     *            the telephones to set
     */
    public void setTelephones(final Collection<Telephone> telephones) {
        this.telephones = telephones;
    }

    /**
     * Builder de {@link Personne}.
     * 
     * @author Steve Cancès
     * @version 1.0.0
     * @since 1.0.0
     */
    public static class Builder {

        /** Le pojo géré par le {@code Builder} */
        private final Personne pojo;

        private Builder() {
            this.pojo = new Personne();
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
         * @param nom
         *            Le nom.
         * @return Le {@code Builder} pour chainer les appels.
         */
        public Builder withNom(final String nom) {
            this.pojo.nom = nom;
            return this;
        }

        /**
         * @author Steve Cancès
         * @since 1.0.0
         * @param prenom
         *            Le prenom.
         * @return Le {@code Builder} pour chainer les appels.
         */
        public Builder withPrenom(final String prenom) {
            this.pojo.prenom = prenom;
            return this;
        }

        /**
         * @author Steve Cancès
         * @since 1.0.0
         * @param telephone
         *            Le telephone.
         * @return Le {@code Builder} pour chainer les appels.
         */
        public Builder withTelephone(final Telephone telephone) {
            this.pojo.telephones.add(telephone);
            return this;
        }

        /**
         * @author Steve Cancès
         * @since 1.0.0
         * @param telephones
         *            Les telephones.
         * @return Le {@code Builder} pour chainer les appels.
         */
        public Builder withTelephones(final Collection<Telephone> telephones) {
            this.pojo.telephones.addAll(telephones);
            return this;
        }

        /**
         * Retourne l'objet {@code Personne} construit.
         * 
         * @author Steve Cancès
         * @since 1.0.0
         * @return Retourne l'objet {@code Personne} construit.
         */
        public Personne build() {
            return this.pojo;
        }
    }

}
