package fr.cances.steve.annuaire.spring.model.service.api;

import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.SecurityUserVo;

/**
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ServiceSecurityUser {

    public SecurityUserVo authenticate(String username, String password);

}
