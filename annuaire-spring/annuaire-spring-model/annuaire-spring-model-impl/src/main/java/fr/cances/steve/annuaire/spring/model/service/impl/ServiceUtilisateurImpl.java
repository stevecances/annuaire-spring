package fr.cances.steve.annuaire.spring.model.service.impl;

import org.springframework.transaction.annotation.Transactional;

import fr.cances.steve.annuaire.spring.model.persistence.entity.Utilisateur;
import fr.cances.steve.annuaire.spring.model.service.api.ServiceUtilisateur;
import fr.cances.steve.annuaire.spring.model.service.api.exception.ResourceNotFoundException;
import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.UtilisateurVo;
import fr.cances.steve.annuaire.spring.model.service.impl.validation.vo.UtilisateurVoValidation;

/**
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
public class ServiceUtilisateurImpl extends GenericService<Utilisateur, UtilisateurVo, UtilisateurVoValidation, Long> implements ServiceUtilisateur {

    /**
     * Constructeur par defaut.
     * 
     * @author Steve Cancès
     * @since 1.0.0
     */
    public ServiceUtilisateurImpl() {
        super(Utilisateur.class, UtilisateurVo.class, UtilisateurVoValidation.class);
    }

    @Transactional
    @Override
    public void setAdmin(final Long id, final boolean admin) throws ResourceNotFoundException {
        Utilisateur utilisateur = this.getDao().find(id);
        if (utilisateur != null) {
            utilisateur.setAdmin(admin);
            this.getDao().edit(utilisateur);
        } else {
            this.getExceptionHelper().throwResourceNotFoundException(this.getVoClass(), id.toString());
        }
    }

}
