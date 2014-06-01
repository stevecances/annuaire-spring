package fr.cances.steve.annuaire.spring.model.service.impl;

import fr.cances.steve.annuaire.spring.model.persistence.dao.DaoUtilisateur;
import fr.cances.steve.annuaire.spring.model.persistence.entity.Utilisateur;
import fr.cances.steve.annuaire.spring.model.security.dao.DaoSecurityUser;
import fr.cances.steve.annuaire.spring.model.security.entity.SecurityUser;
import fr.cances.steve.annuaire.spring.model.service.api.ServiceSecurityUser;
import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.SecurityUserVo;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
public class ServiceSecurityUserImpl implements ServiceSecurityUser {

    @Inject
    private DaoSecurityUser daoSecurityUser;

    @Inject
    private DaoUtilisateur daoUtilisateur;

    @Transactional(readOnly = true)
    @Override
    public SecurityUserVo authenticate(String username, String password) {
        SecurityUser securityUser = this.daoSecurityUser.authenticate(username, password);
        Utilisateur utilisateur = this.daoUtilisateur.findByUsername(username);
        if (securityUser != null && utilisateur != null) {
            return SecurityUserVo.Builder
                    .newInstance()
                    .withUsername(username)
                    .withRoles(securityUser.getRoles())
                    .withPrenom(utilisateur.getPersonne().getPrenom())
                    .withNom(utilisateur.getPersonne().getNom())
                    .build();
        }
        return null;
    }
}
