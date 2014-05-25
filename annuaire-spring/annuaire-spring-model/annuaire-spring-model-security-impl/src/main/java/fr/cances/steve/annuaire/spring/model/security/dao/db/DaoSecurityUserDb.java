package fr.cances.steve.annuaire.spring.model.security.dao.db;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import fr.cances.steve.annuaire.spring.model.persistence.dao.DaoUtilisateur;
import fr.cances.steve.annuaire.spring.model.persistence.entity.Utilisateur;
import fr.cances.steve.annuaire.spring.model.security.dao.DaoSecurityUser;
import fr.cances.steve.annuaire.spring.model.security.entity.SecurityUser;

/**
 * {@link DaoSecurityUser} se basant sur la base de données.
 * 
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
@Repository
public class DaoSecurityUserDb implements DaoSecurityUser {

    private static final String ROLE_ADMIN = "ADMIN";

    @Inject
    private DaoUtilisateur utilisateurRepository;

    @Override
    public SecurityUser authenticate(final String username, final String password) {
        Utilisateur utilisateur = this.utilisateurRepository.findByUsername(username);
        if (utilisateur.getPassword().equals(password)) {
            SecurityUser.Builder securityUserBuilder = SecurityUser.Builder.newInstance().withUsername(username);
            if (utilisateur.isAdmin()) {
                securityUserBuilder.withRole(ROLE_ADMIN);
            }
            return securityUserBuilder.build();
        }
        return null;
    }
}
