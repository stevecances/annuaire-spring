package fr.cances.steve.annuaire.spring.model.service.impl;

import java.util.Collection;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.cances.steve.annuaire.spring.model.persistence.dao.DaoPersonne;
import fr.cances.steve.annuaire.spring.model.persistence.dao.DaoTelephone;
import fr.cances.steve.annuaire.spring.model.persistence.entity.Personne;
import fr.cances.steve.annuaire.spring.model.persistence.entity.Telephone;
import fr.cances.steve.annuaire.spring.model.service.api.ServiceAnnuaire;
import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.PersonneVo;
import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.TelephoneVo;
import fr.cances.steve.annuaire.spring.model.service.impl.mapping.EntityMapper;

/**
 * Services annuaire (consultation uniquement)
 * 
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
@Transactional(readOnly = true)
public class ServiceAnnuaireImpl implements ServiceAnnuaire {

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
    public Collection<PersonneVo> getAllPersonnes() {
        return this.entityMapperPersonne.transform(this.daoPersonne.findAll());
    }

    @Override
    public PersonneVo getPersonne(final Long idPersonne) {
        PersonneVo personneVo = null;
        Personne personne = this.daoPersonne.find(idPersonne);
        if (personne != null) {
            personneVo = entityMapperPersonne.transform(personne);
        }
        return personneVo;
    }

    @Override
    public Collection<PersonneVo> findPersonnesLikePrenomOrNom(final String like) {
        return this.entityMapperPersonne.transform(this.daoPersonne.findPersonnesLikePrenomOrNom(like));
    }

    @Override
    public TelephoneVo getTelephone(final Long idTelephone) {
        TelephoneVo telephoneVo = null;
        if (idTelephone != null) {
            telephoneVo = this.entityMapperTelephone.transform(this.daoTelephone.find(idTelephone));
        }
        return telephoneVo;
    }
}
