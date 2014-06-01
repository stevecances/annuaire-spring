package fr.cances.steve.annuaire.spring.model.service.impl;

import fr.cances.steve.annuaire.spring.model.persistence.entity.Utilisateur;
import fr.cances.steve.annuaire.spring.model.service.api.ServiceUtilisateur;
import fr.cances.steve.annuaire.spring.model.service.api.exception.BeanValidationException;
import fr.cances.steve.annuaire.spring.model.service.api.exception.ResourceNotFoundException;
import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.UtilisateurVo;
import fr.cances.steve.annuaire.spring.model.service.impl.utils.ServicesUtils;
import fr.cances.steve.annuaire.spring.model.service.impl.validation.vo.UtilisateurVoValidation;
import java.util.Collection;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
@Secured(ServicesUtils.STRING_ROLE_ADMIN)
@Service
public class ServiceUtilisateurImpl extends AbstractBasicService<Utilisateur, UtilisateurVo, UtilisateurVoValidation, Long> implements ServiceUtilisateur {

    /**
     * Constructeur par defaut.
     * 
     * @author Steve Cancès
     * @since 1.0.0
     */
    public ServiceUtilisateurImpl() {
        super(Utilisateur.class, UtilisateurVo.class, UtilisateurVoValidation.class);
    }

    @Transactional(readOnly = true)
    @Override
    public Collection<UtilisateurVo> findAll() {
        return super.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public UtilisateurVo find(final Long id) throws ResourceNotFoundException {
        return super.find(id);
    }

    @Transactional
    @Override
    public UtilisateurVo create(final UtilisateurVo vo) throws BeanValidationException {
        return super.create(vo);
    }

    @Transactional
    @Override
    public UtilisateurVo edit(final UtilisateurVo vo) throws BeanValidationException, ResourceNotFoundException {
        return super.edit(vo);
    }

    @Transactional
    @Override
    public void delete(final Long id) {
        super.delete(id);
    }

    @Transactional
    @Override
    public void setAdmin(final Long id, final boolean admin) throws ResourceNotFoundException {
        Utilisateur utilisateur = this.dao.find(id);
        if (utilisateur != null) {
            utilisateur.setAdmin(admin);
            this.dao.edit(utilisateur);
        } else {
            this.exceptionHelper.throwResourceNotFoundException(this.voClass, id.toString());
        }
    }

}
