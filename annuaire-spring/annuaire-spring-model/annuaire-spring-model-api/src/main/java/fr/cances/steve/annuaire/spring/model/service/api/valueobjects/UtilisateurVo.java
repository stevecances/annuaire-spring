package fr.cances.steve.annuaire.spring.model.service.api.valueobjects;

/**
 * Vo representant un utilisateur.
 * 
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
public class UtilisateurVo extends AbstractVo<Long> {

    /**
     * Le nom d'utilisateur de l'utilisateur.
     */
    protected String username;

    /**
     * Le mot de passe de l'utilisateur.
     */
    protected String password;

    /**
     * Le nom de la personne.
     */
    protected String nom;

    /**
     * le prenom de la personne.
     */
    protected String prenom;

    /**
     * Si l'utilisateur est administrateur.
     */
    protected boolean admin;

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     *            the username to set
     */
    public void setUsername(final String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     *            the password to set
     */
    public void setPassword(final String password) {
        this.password = password;
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
    public void setNom(String nom) {
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
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the admin
     */
    public boolean isAdmin() {
        return admin;
    }

    /**
     * @param admin
     *            the admin to set
     */
    public void setAdmin(final boolean admin) {
        this.admin = admin;
    }

    /**
     * Builder de {@link UtilisateurVo}.
     * 
     * @author Steve Cancès
     * @version 1.0.0
     * @since 1.0.0
     */
    public static class Builder {

        /**
         * Le pojo géré par le {@code Builder}
         */
        private final UtilisateurVo pojo;

        private Builder() {
            this.pojo = new UtilisateurVo();
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
         * @param username
         *            Le username.
         * @return Le {@code Builder} pour chainer les appels.
         */
        public Builder withUsername(final String username) {
            this.pojo.username = username;
            return this;
        }

        /**
         * @author Steve Cancès
         * @since 1.0.0
         * @param password
         *            Le password.
         * @return Le {@code Builder} pour chainer les appels.
         */
        public Builder withPassword(final String password) {
            this.pojo.password = password;
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
         * @param admin
         *            Si l'utilisateur est administrateur.
         * @return Le {@code Builder} pour chainer les appels.
         */
        public Builder withAdmin(final boolean admin) {
            this.pojo.admin = admin;
            return this;
        }

        /**
         * Retourne l'objet {@code UtilisateurVo} construit.
         * 
         * @author Steve Cancès
         * @since 1.0.0
         * @return Retourne l'objet {@code UtilisateurVo} construit.
         */
        public UtilisateurVo build() {
            return this.pojo;
        }
    }

}
