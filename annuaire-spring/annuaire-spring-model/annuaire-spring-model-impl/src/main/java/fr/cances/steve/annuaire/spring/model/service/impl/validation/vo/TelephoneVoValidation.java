package fr.cances.steve.annuaire.spring.model.service.impl.validation.vo;

import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.TelephoneVo;
import fr.cances.steve.annuaire.spring.model.service.impl.validation.constraint.NotBlank;

/**
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
public class TelephoneVoValidation extends TelephoneVo implements IVoValidation<TelephoneVo, Long> {

    @NotBlank
    @Override
    public String getTelephone() {
        return super.getTelephone();
    }

}
