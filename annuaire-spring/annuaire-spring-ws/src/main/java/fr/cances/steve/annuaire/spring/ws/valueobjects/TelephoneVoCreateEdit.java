/**
 * 
 */
package fr.cances.steve.annuaire.spring.ws.valueobjects;

import org.hibernate.validator.constraints.NotBlank;

import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.TelephoneVo;

/**
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
public class TelephoneVoCreateEdit extends TelephoneVo {

    /**
     * Non utilisé pour la création/l'edition
     */
    @Override
    public Long getId() {
        return null;
    }

    /**
     * Non utilisé pour la création/l'edition
     */
    @Override
    public void setId(final Long id) {
        this.id = null;
    }

    /**
     * Le telephone ne peut pas être blank
     */
    @NotBlank
    @Override
    public String getTelephone() {
        return telephone;
    }

}
