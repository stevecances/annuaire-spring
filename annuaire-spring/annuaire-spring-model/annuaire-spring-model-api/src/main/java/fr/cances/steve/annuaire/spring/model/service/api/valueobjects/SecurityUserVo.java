package fr.cances.steve.annuaire.spring.model.service.api.valueobjects;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Vo representant un utilisateur authentifie.
 * 
 * @author Steve Cances <steve.cances@gmail.com>
 */
public class SecurityUserVo {

    /**
     * Le nom de la personne.
     */
    private String nom;

    /**
     * le prenom de la personne.
     */
    private String prenom;

    /**
     * Le nom d'utilisateur de l'utilisateur.
     */
    private String username;

    /**
     * Les roles de l'utilisateur.
     */
    private final Collection<String> roles = new ArrayList<>();

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
     * @return the roles
     */
    public Collection<String> getRoles() {
        return roles;
    }

    /**
     * Builder de {@link SecurityUserVo}.
     * 
     * @author Steve Cancès
     * @version 1.0.0
     * @since 1.0.0
     */
    public static class Builder {

        /**
         * Le pojo géré par le {@code Builder}
         */
        private final SecurityUserVo pojo;

        private Builder() {
            this.pojo = new SecurityUserVo();
        }

        /**
         * Retourne une instance du builder.
         * 
         * @author Steve Cancès
         * @Since 1.0.0
         * @return Une instance du {@code Builder}.
         */
        public static Builder newInstance() {
            return new Builder();
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
         * @Since 1.0.0
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
         * @param role
         *            Le role.
         * @return Le {@code Builder} pour chainer les appels.
         */
        public Builder withRole(final String role) {
            this.pojo.roles.add(role);
            return this;
        }

        /**
         * @author Steve Cancès
         * @since 1.0.0
         * @param roles
         *            Les roles.
         * @return Le {@code Builder} pour chainer les appels.
         */
        public Builder withRoles(final Collection<String> roles) {
            this.pojo.roles.addAll(roles);
            return this;
        }

        /**
         * Retourne l'objet {@code SecurityUserVo} construit.
         * 
         * @author Steve Cancès
         * @Since 1.0.0
         * @return Retourne l'objet {@code SecurityUserVo} construit.
         */
        public SecurityUserVo build() {
            return this.pojo;
        }
    }

}
