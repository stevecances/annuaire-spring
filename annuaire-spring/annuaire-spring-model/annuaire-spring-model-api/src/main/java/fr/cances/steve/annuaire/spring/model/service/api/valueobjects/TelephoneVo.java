package fr.cances.steve.annuaire.spring.model.service.api.valueobjects;

/**
 * Vo representant un numero de telephone.
 * 
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
public class TelephoneVo extends AbstractVo<Long> {

    /** Le numéro de téléphone. */
    private String telephone;

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
     * Builder de {@link TelephoneVo}.
     * 
     * @author Steve Cancès
     * @version 1.0.0
     * @since 1.0.0
     */
    public static class Builder {

        /** Le pojo géré par le {@code Builder} */
        private final TelephoneVo pojo;

        private Builder() {
            this.pojo = new TelephoneVo();
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
         * @param telephone
         *            Le telephone.
         * @return Le {@code Builder} pour chainer les appels.
         */
        public Builder withTelephone(final String telephone) {
            this.pojo.telephone = telephone;
            return this;
        }

        /**
         * Retourne l'objet {@code TelephoneVo} construit.
         * 
         * @author Steve Cancès
         * @since 1.0.0
         * @return Retourne l'objet {@code TelephoneVo} construit.
         */
        public TelephoneVo build() {
            return this.pojo;
        }
    }

}
