package fr.cances.steve.annuaire.spring.model.service.api.valueobjects;

import java.util.Collection;

/**
 * Vo representant une personne.
 * 
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
public class PersonneVo extends AbstractVo<Long> {

    /** Le nom de la personne. */
    private String nom;

    /** le prenom de la personne. */
    private String prenom;

    /** Les numéros de téléphone de la personne. */
    private Collection<TelephoneVo> telephones;

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
    public Collection<TelephoneVo> getTelephones() {
        return telephones;
    }

    /**
     * @param telephones
     *            the telephones to set
     */
    public void setTelephones(final Collection<TelephoneVo> telephones) {
        this.telephones = telephones;
    }

    /**
     * Builder de {@link PersonneVo}.
     * 
     * @author Steve Cancès
     * @version 1.0.0
     * @since 1.0.0
     */
    public static class Builder {

        /** Le pojo géré par le {@code Builder} */
        private final PersonneVo pojo;

        private Builder() {
            this.pojo = new PersonneVo();
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
            this.pojo.setId(id);
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
        public Builder withTelephone(final TelephoneVo telephone) {
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
        public Builder withTelephones(final Collection<TelephoneVo> telephones) {
            this.pojo.telephones.addAll(telephones);
            return this;
        }

        /**
         * Retourne l'objet {@code PersonneVo} construit.
         * 
         * @author Steve Cancès
         * @since 1.0.0
         * @return Retourne l'objet {@code PersonneVo} construit.
         */
        public PersonneVo build() {
            return this.pojo;
        }
    }

}
