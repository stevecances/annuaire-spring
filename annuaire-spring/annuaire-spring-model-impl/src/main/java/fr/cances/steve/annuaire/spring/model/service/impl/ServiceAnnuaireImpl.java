package fr.cances.steve.annuaire.spring.model.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.cances.steve.annuaire.spring.model.persistence.entities.Personne;
import fr.cances.steve.annuaire.spring.model.persistence.repositories.PersonneRepository;
import fr.cances.steve.annuaire.spring.model.service.api.ServiceAnnuaire;
import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.PersonneVo;

/**
 *  Services annuaire (consultation uniquement)
 *  
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 *
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
	 * Dozer bean mapper
	 */
	@Autowired
	DozerBeanMapper dozerMapper;

	@Override
	public Collection<PersonneVo> getAllPersonnes() {
		Collection<PersonneVo> personnesVo = new ArrayList<>();
		for(Personne personne : this.personneRepository.findAll()) {
			personnesVo.add(this.dozerMapper.map(personne, PersonneVo.class));
		}

		return personnesVo;
	}

	@Override
	public PersonneVo getPersonne(Long idPersonne) {
		PersonneVo personneVo = null;
		Personne personne = this.personneRepository.find(idPersonne);
		if(personne != null) {
			personneVo = this.dozerMapper.map(personne, PersonneVo.class);
		}
		return personneVo;
	}

	@Override
	public Collection<PersonneVo> findPersonnesLikePrenomOrNom(String like) {
		Collection<PersonneVo> personnesVo = new ArrayList<>();
		for(Personne personne : this.personneRepository.findPersonnesLikePrenomOrNom(like)) {
			personnesVo.add(this.dozerMapper.map(personne, PersonneVo.class));
		}
		return personnesVo;
	}

}
