package fr.cances.steve.annuaire.spring.model.security.dao.db;

import fr.cances.steve.annuaire.spring.model.persistence.dao.DaoUtilisateur;
import fr.cances.steve.annuaire.spring.model.persistence.entity.Utilisateur;
import fr.cances.steve.annuaire.spring.model.security.dao.DaoSecurityUser;
import fr.cances.steve.annuaire.spring.model.security.entity.SecurityUser;
import javax.inject.Inject;
import org.springframework.stereotype.Repository;

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

    private static final String ROLE_USER = "USER";

    @Inject
    private DaoUtilisateur daoUtilisateur;

    @Override
    public SecurityUser authenticate(final String username, final String password) {
        Utilisateur utilisateur = this.daoUtilisateur.findByUsername(username);
        if (utilisateur != null && utilisateur.getPassword().equals(password)) {
            SecurityUser.Builder securityUserBuilder = SecurityUser.Builder.newInstance().withUsername(username).withRole(ROLE_USER);
            if (utilisateur.isAdmin()) {
                securityUserBuilder.withRole(ROLE_ADMIN);
            }
            return securityUserBuilder.build();
        }
        return null;
    }

}
