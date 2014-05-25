package fr.cances.steve.annuaire.spring.model.service.impl.validation.vo;

import fr.cances.steve.annuaire.spring.model.persistence.entity.Personne;
import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.PersonneVo;
import fr.cances.steve.annuaire.spring.model.service.impl.validation.constraint.NotBlank;
import fr.cances.steve.annuaire.spring.model.service.impl.validation.constraint.NullOrNotBlank;
import fr.cances.steve.annuaire.spring.model.service.impl.validation.constraint.UniqueField;
import fr.cances.steve.annuaire.spring.model.service.impl.validation.constraint.UniqueField.Column;
import fr.cances.steve.annuaire.spring.model.service.impl.validation.group.CreateGroup;
import fr.cances.steve.annuaire.spring.model.service.impl.validation.group.EditGroup;

/**
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
@UniqueField(
        entityClass = Personne.class,
        columns = {
                @Column(name = "nom"),
                @Column(name = "prenom")
        })
public class PersonneVoValidation extends PersonneVo implements IVoValidation<PersonneVo, Long> {

    @NotBlank(groups = { CreateGroup.class })
    @NullOrNotBlank(groups = { EditGroup.class })
    @Override
    public String getNom() {
        return super.getNom();
    }

    @NotBlank(groups = { CreateGroup.class })
    @NullOrNotBlank(groups = { EditGroup.class })
    @Override
    public String getPrenom() {
        return super.getPrenom();
    }

}
