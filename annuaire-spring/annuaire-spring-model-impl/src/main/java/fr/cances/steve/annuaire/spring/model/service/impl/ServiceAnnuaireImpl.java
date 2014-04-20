package fr.cances.steve.annuaire.spring.model.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.cances.steve.annuaire.spring.model.persistence.entities.Personne;
import fr.cances.steve.annuaire.spring.model.persistence.repositories.PersonneRepository;
import fr.cances.steve.annuaire.spring.model.service.api.ServiceAnnuaire;
import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.PersonneVo;
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
    public Collection<PersonneVo> getAllPersonnes() {
        return this.entityMapperPersonne.transform(this.personneRepository.findAll());
    }

    @Override
    public PersonneVo getPersonne(final Long idPersonne) {
        PersonneVo personneVo = null;
        Personne personne = this.personneRepository.find(idPersonne);
        if (personne != null) {
            personneVo = entityMapperPersonne.transform(personne);
        }
        return personneVo;
    }

    @Override
    public Collection<PersonneVo> findPersonnesLikePrenomOrNom(final String like) {
        return this.entityMapperPersonne.transform(this.personneRepository.findPersonnesLikePrenomOrNom(like));
    }

}
