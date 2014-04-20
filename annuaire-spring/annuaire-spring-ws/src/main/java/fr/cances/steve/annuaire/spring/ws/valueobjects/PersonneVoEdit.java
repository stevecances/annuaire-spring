package fr.cances.steve.annuaire.spring.ws.valueobjects;

import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.PersonneVo;
import fr.cances.steve.annuaire.spring.ws.validation.NullOrNotBlank;

/**
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
public class PersonneVoEdit extends PersonneVo {

    @Override
    @NullOrNotBlank
    public String getNom() {
        return nom;
    }

    @Override
    @NullOrNotBlank
    public String getPrenom() {
        return prenom;
    }

}
