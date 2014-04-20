package fr.cances.steve.annuaire.spring.ws.valueobjects;

import java.util.Collection;

import org.hibernate.validator.constraints.NotBlank;

import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.PersonneVo;
import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.TelephoneVo;

/**
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
public class PersonneVoCreate extends PersonneVo {

    /**
     * Non utilisé pour l'edition
     */
    @Override
    public Long getId() {
        return null;
    }

    /**
     * Non utilisé pour l'edition
     */
    @Override
    public void setId(final Long id) {
        this.id = null;
    }

    /**
     * Le nom ne peut pas être blank
     */
    @Override
    @NotBlank
    public String getNom() {
        return nom;
    }

    /**
     * Le prénom ne peut pas être blank
     */
    @Override
    @NotBlank
    public String getPrenom() {
        return prenom;
    }

    /**
     * Non utilisé pour la création d'une personne
     */
    @Override
    public Collection<TelephoneVo> getTelephones() {
        return null;
    }

    /**
     * Non utilisé pour la création d'une personne
     */
    @Override
    public void setTelephones(final Collection<TelephoneVo> telephones) {
        this.telephones = null;
    }

}
