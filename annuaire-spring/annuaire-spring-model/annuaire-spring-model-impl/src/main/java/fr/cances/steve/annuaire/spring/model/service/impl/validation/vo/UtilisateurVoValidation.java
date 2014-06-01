package fr.cances.steve.annuaire.spring.model.service.impl.validation.vo;

import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.UtilisateurVo;
import fr.cances.steve.annuaire.spring.model.service.impl.validation.constraint.NotBlank;
import fr.cances.steve.annuaire.spring.model.service.impl.validation.constraint.NullOrNotBlank;
import fr.cances.steve.annuaire.spring.model.service.impl.validation.group.CreateGroup;
import fr.cances.steve.annuaire.spring.model.service.impl.validation.group.EditGroup;

/**
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
public class UtilisateurVoValidation extends UtilisateurVo implements IVoValidation<UtilisateurVo, Long> {

    /**
     * @return the username
     */
    @NotBlank(groups = { CreateGroup.class })
    @NullOrNotBlank(groups = { EditGroup.class })
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * @return the password
     */
    @NotBlank(groups = { CreateGroup.class })
    @NullOrNotBlank(groups = { EditGroup.class })
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * @return the nom
     */
    @NotBlank(groups = { CreateGroup.class })
    @NullOrNotBlank(groups = { EditGroup.class })
    @Override
    public String getNom() {
        return nom;
    }

    /**
     * @return the prenom
     */
    @NotBlank(groups = { CreateGroup.class })
    @NullOrNotBlank(groups = { EditGroup.class })
    @Override
    public String getPrenom() {
        return prenom;
    }

}
