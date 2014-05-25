package fr.cances.steve.annuaire.spring.model.security.dao;

import fr.cances.steve.annuaire.spring.model.security.entity.SecurityUser;

/**
 * Gère l'authentification.
 * 
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
public interface DaoSecurityUser {

    /**
     * Gere l'authentification.
     * <p>
     * Retourne le {@link SecurityUser} si l'authentification réussie et
     * {@code null} sinon.
     * </p>
     * 
     * @author Steve Cancès
     * @since 1.0.0
     * @param username
     *            Le username de l'utilisateur à authentifier.
     * @param password
     *            Le password de l'utilisateur à authentifier.
     * @return Le {@link SecurityUser}.
     */
    public SecurityUser authenticate(String username, String password);

}
