/**
 * 
 */
package fr.cances.steve.annuaire.spring.model.service.impl.mapping;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.cances.steve.annuaire.spring.model.persistence.entities.Personne;
import fr.cances.steve.annuaire.spring.model.persistence.entities.Telephone;
import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.PersonneVo;
import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.TelephoneVo;

/**
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
@Component
public class EntityMapperPersonne extends EntityMapper<Personne, PersonneVo> {

    @Autowired
    private EntityMapper<Telephone, TelephoneVo> entityMapperTelephone;

    @Override
    public void updateEntityFromVo(final Personne entity, final PersonneVo vo) {
        if (entity != null && vo != null) {
            if (vo.getNom() != null) {
                entity.setNom(vo.getNom());
            }
            if (vo.getPrenom() != null) {
                entity.setPrenom(vo.getPrenom());
            }
            if (vo.getTelephones() != null) {
                Collection<Telephone> telephones = entity.getTelephones();
                telephones.clear();
                for (TelephoneVo telephoneVo : vo.getTelephones()) {
                    Telephone telephone = this.entityMapperTelephone.reverse(telephoneVo);
                    telephone.setPersonne(entity);
                    telephones.add(telephone);
                }
            }
        }
    }

    @Override
    public PersonneVo transform(final Personne input) {
        PersonneVo personneVo = null;
        if (input != null) {
            personneVo = new PersonneVo();
            personneVo.setId(input.getId());
            personneVo.setNom(input.getNom());
            personneVo.setPrenom(input.getPrenom());
            if (input.getTelephones() == null) {
                personneVo.setTelephones(null);
            } else {
                personneVo.setTelephones(this.entityMapperTelephone.transform(input.getTelephones()));
            }
        }
        return personneVo;
    }

    @Override
    public Personne reverse(final PersonneVo output) {
        Personne personne = null;
        if (output != null) {
            personne = new Personne();
            personne.setId(output.getId());
            personne.setNom(output.getNom());
            personne.setPrenom(output.getPrenom());
            if (output.getTelephones() == null) {
                personne.setTelephones(null);
            } else {
                Collection<Telephone> telephones = new ArrayList<>();
                personne.setTelephones(telephones);
                for (TelephoneVo telephoneVo : output.getTelephones()) {
                    Telephone telephone = this.entityMapperTelephone.reverse(telephoneVo);
                    telephone.setPersonne(personne);
                    telephones.add(telephone);
                }
            }
        }
        return personne;
    }
}
