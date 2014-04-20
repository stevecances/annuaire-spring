/**
 * 
 */
package fr.cances.steve.annuaire.spring.model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.cances.steve.annuaire.spring.model.persistence.entities.Personne;
import fr.cances.steve.annuaire.spring.model.persistence.repositories.PersonneRepository;
import fr.cances.steve.annuaire.spring.model.service.api.ServiceAnnuaireAdmin;
import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.PersonneVo;
import fr.cances.steve.annuaire.spring.model.service.impl.mapping.EntityMapper;

/**
 * Services annuaire d'administration
 * 
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
@Transactional
public class ServiceAnnuaireAdminImpl implements ServiceAnnuaireAdmin {

    /**
     * Repository concernant l'entity Personne
     */
    @Autowired
    PersonneRepository personneRepository;

    /**
     * Bean mapper
     */
    @Autowired
    EntityMapper<Personne, PersonneVo> entityMapperPersonne;

    @Override
    public PersonneVo createPersonne(final PersonneVo personneVo) {
        PersonneVo personneVoReturn = null;
        if (personneVo != null) {
            personneVo.setId(null);
            Personne personne = this.entityMapperPersonne.reverse(personneVo);
            personne = this.personneRepository.create(personne);
            personneVoReturn = this.entityMapperPersonne.transform(personne);
        }
        return personneVoReturn;
    }

    @Override
    public PersonneVo editPersonne(final Long idPersonne, final PersonneVo personneVo) {
        PersonneVo personneVoReturn = null;
        if (idPersonne != null && personneVo != null) {
            Personne personne = this.personneRepository.find(idPersonne);
            if (personne != null) {
                personneVo.setId(idPersonne);
                this.entityMapperPersonne.updateEntityFromVo(personne, personneVo);
                personne = this.personneRepository.edit(personne);
                personneVoReturn = this.entityMapperPersonne.transform(personne);
            }
        }
        return personneVoReturn;
    }

    @Override
    public void deletePersonne(final Long idPersonne) {
        if (idPersonne != null) {
            Personne personne = this.personneRepository.find(idPersonne);
            if (personne != null) {
                this.personneRepository.remove(personne);
            }
        }
    }

}
