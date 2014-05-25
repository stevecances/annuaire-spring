package fr.cances.steve.annuaire.spring.model.service.impl.validation;

import fr.cances.steve.annuaire.spring.model.service.api.exception.BeanValidationException;
import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.AbstractVo;
import fr.cances.steve.annuaire.spring.model.service.impl.validation.vo.IVoValidation;

/**
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
public interface BeanValidator<V extends AbstractVo<P>, P> {

    /**
     * Validation d'un bean.
     * 
     * @param voValidation
     *            Le bean à valider.
     * @param groups
     *            Les groups sur lesquels porte la validation.
     * @throws BeanValidationException
     *             L'exception levée si la validation échoue.
     */
    public void validate(
            final IVoValidation<V, P> voValidation,
            final Class<?>... groups) throws BeanValidationException;
}
