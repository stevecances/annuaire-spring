package fr.cances.steve.annuaire.spring.model.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import fr.cances.steve.annuaire.spring.model.persistence.dao.DaoUtilisateur;
import fr.cances.steve.annuaire.spring.model.security.dao.DaoSecurityUser;
import fr.cances.steve.annuaire.spring.model.service.api.ServiceSecurity;

/**
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
public class ServiceSecurityImpl implements ServiceSecurity {

    @Inject
    private DaoSecurityUser securityUserRepository;

    @Inject
    private DaoUtilisateur daoUtilisateur;

    // @Override
    // public UtilisateurVo authenticate(final String username, final String
    // password) {
    // SecurityUser securityUser =
    // this.securityUserRepository.authenticate(username, password);
    // Utilisateur utilisateur = this.daoUtilisateur.findByUsername(username);
    // if (securityUser == null || utilisateur == null) {
    // return null;
    // }
    //
    // return null;
    // }

}
