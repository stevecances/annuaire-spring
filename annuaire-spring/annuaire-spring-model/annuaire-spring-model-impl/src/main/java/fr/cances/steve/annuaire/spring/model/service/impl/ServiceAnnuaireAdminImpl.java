package fr.cances.steve.annuaire.spring.model.service.impl;

import javax.inject.Inject;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.cances.steve.annuaire.spring.model.persistence.dao.DaoPersonne;
import fr.cances.steve.annuaire.spring.model.persistence.dao.DaoTelephone;
import fr.cances.steve.annuaire.spring.model.persistence.entity.Personne;
import fr.cances.steve.annuaire.spring.model.persistence.entity.Telephone;
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
@Secured("ROLE_ADMIN")
@Service
@Transactional
public class ServiceAnnuaireAdminImpl implements ServiceAnnuaireAdmin {

    /** Dao concernant l'entity {@link Personne} */
    @Inject
    DaoPersonne daoPersonne;

    /** Dao concernant l'entity {@link Telephone} */
    @Inject
    DaoTelephone daoTelephone;

    /** Entity mapper {@link Personne} <-> {@link PersonneVo} */
    @Inject
    EntityMapper<Personne, PersonneVo, Long> entityMapperPersonne;

    /** Entity mapper {@link Telephone} <-> {@link TelephoneVo} */
    @Inject
    EntityMapper<Telephone, TelephoneVo, Long> entityMapperTelephone;

    @Override
    public PersonneVo createPersonne(final PersonneVo personneVo) {
        PersonneVo personneVoReturn = null;
        if (personneVo != null) {
            personneVo.setId(null);
            Personne personne = this.entityMapperPersonne.reverse(personneVo);
            personne = this.daoPersonne.create(personne);
            personneVoReturn = this.entityMapperPersonne.transform(personne);
        }
        return personneVoReturn;
    }

    @Override
    public PersonneVo editPersonne(final Long idPersonne, final PersonneVo personneVo) {
        PersonneVo personneVoReturn = null;
        if (idPersonne != null && personneVo != null) {
            Personne personne = this.daoPersonne.find(idPersonne);
            if (personne != null) {
                personneVo.setId(idPersonne);
                this.entityMapperPersonne.updateEntityFromVo(personne, personneVo);
                personne = this.daoPersonne.edit(personne);
                personneVoReturn = this.entityMapperPersonne.transform(personne);
            }
        }
        return personneVoReturn;
    }

    @Override
    public void deletePersonne(final Long idPersonne) {
        if (idPersonne != null) {
            Personne personne = this.daoPersonne.find(idPersonne);
            if (personne != null) {
                this.daoPersonne.remove(personne);
            }
        }
    }

    @Override
    public TelephoneVo createTelephone(final Long idPersonne, final TelephoneVo telephoneVo) {
        TelephoneVo telephoneVoReturn = null;
        if (idPersonne != null && telephoneVo != null) {
            Personne personne = this.daoPersonne.find(idPersonne);
            if (personne != null) {
                Telephone telephone = this.entityMapperTelephone.reverse(telephoneVo);
                telephone.setPersonne(personne);
                this.daoTelephone.create(telephone);
                telephoneVoReturn = this.entityMapperTelephone.transform(telephone);
            }
        }
        return telephoneVoReturn;
    }

    @Override
    public TelephoneVo editTelephone(final Long idTelephone, final TelephoneVo telephoneVo) {
        TelephoneVo telephoneVoReturn = null;
        if (idTelephone != null && telephoneVo != null) {
            Telephone telephone = this.daoTelephone.find(idTelephone);
            if (telephone != null) {
                this.entityMapperTelephone.updateEntityFromVo(telephone, telephoneVo);
                this.daoTelephone.edit(telephone);
                telephoneVoReturn = this.entityMapperTelephone.transform(telephone);
            }
        }
        return telephoneVoReturn;
    }

    @Override
    public void deleteTelephone(final Long idTelephone) {
        if (idTelephone != null) {
            Telephone telephone = this.daoTelephone.find(idTelephone);
            if (telephone != null) {
                this.daoTelephone.remove(telephone);
            }
        }
    }
}
