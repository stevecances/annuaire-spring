package fr.cances.steve.annuaire.spring.model.security.entity;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Security user.
 * 
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
public class SecurityUser {

    /** Le nom d'utilisateur de l'utilisateur. */
    private String username;

    /** Les roles de l'utilisateur. */
    private final Collection<String> roles = new ArrayList<>();

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
     * Builder de {@link SecurityUser}.
     * 
     * @author Steve Cancès
     * @version 1.0.0
     * @since 1.0.0
     */
    public static class Builder {

        /** Le pojo géré par le {@code Builder} */
        private final SecurityUser pojo;

        private Builder() {
            this.pojo = new SecurityUser();
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
         * Retourne l'objet {@code SecurityUser} construit.
         * 
         * @author Steve Cancès
         * @since 1.0.0
         * @return Retourne l'objet {@code SecurityUser} construit.
         */
        public SecurityUser build() {
            return this.pojo;
        }
    }

}
