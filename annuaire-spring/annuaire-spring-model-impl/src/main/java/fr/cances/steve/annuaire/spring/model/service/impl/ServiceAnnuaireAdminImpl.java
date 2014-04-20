/**
 * 
 */
package fr.cances.steve.annuaire.spring.model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.cances.steve.annuaire.spring.model.persistence.entities.Personne;
import fr.cances.steve.annuaire.spring.model.persistence.entities.Telephone;
import fr.cances.steve.annuaire.spring.model.persistence.repositories.PersonneRepository;
import fr.cances.steve.annuaire.spring.model.persistence.repositories.TelephoneRepository;
import fr.cances.steve.annuaire.spring.model.service.api.ServiceAnnuaireAdmin;
import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.PersonneVo;
import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.TelephoneVo;
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
     * Repository concernant l'entity Telephone
     */
    @Autowired
    TelephoneRepository telephoneRepository;

    /**
     * Entity mapper Personne
     */
    @Autowired
    EntityMapper<Personne, PersonneVo> entityMapperPersonne;

    /**
     * Entity mapper Telephone
     */
    @Autowired
    EntityMapper<Telephone, TelephoneVo> entityMapperTelephone;

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

    @Override
    public TelephoneVo createTelephone(final Long idPersonne, final TelephoneVo telephoneVo) {
        TelephoneVo telephoneVoReturn = null;
        if (idPersonne != null && telephoneVo != null) {
            Personne personne = this.personneRepository.find(idPersonne);
            if (personne != null) {
                Telephone telephone = this.entityMapperTelephone.reverse(telephoneVo);
                telephone.setPersonne(personne);
                this.telephoneRepository.create(telephone);
                telephoneVoReturn = this.entityMapperTelephone.transform(telephone);
            }
        }
        return telephoneVoReturn;
    }

    @Override
    public TelephoneVo editTelephone(final Long idTelephone, final TelephoneVo telephoneVo) {
        TelephoneVo telephoneVoReturn = null;
        if (idTelephone != null && telephoneVo != null) {
            Telephone telephone = this.telephoneRepository.find(idTelephone);
            if (telephone != null) {
                this.entityMapperTelephone.updateEntityFromVo(telephone, telephoneVo);
                this.telephoneRepository.edit(telephone);
                telephoneVoReturn = this.entityMapperTelephone.transform(telephone);
            }
        }
        return telephoneVoReturn;
    }

    @Override
    public void deleteTelephone(final Long idTelephone) {
        if (idTelephone != null) {
            Telephone telephone = this.telephoneRepository.find(idTelephone);
            if (telephone != null) {
                this.telephoneRepository.remove(telephone);
            }
        }
    }
}
