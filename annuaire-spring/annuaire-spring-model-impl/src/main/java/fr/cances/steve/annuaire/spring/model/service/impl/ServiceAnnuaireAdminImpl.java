/**
 * 
 */
package fr.cances.steve.annuaire.spring.model.service.impl;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.cances.steve.annuaire.spring.model.persistence.entities.Personne;
import fr.cances.steve.annuaire.spring.model.persistence.repositories.PersonneRepository;
import fr.cances.steve.annuaire.spring.model.service.api.ServiceAnnuaireAdmin;
import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.PersonneVo;

/**
 * Services annuaire d'administration
 * 
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 *
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
	 * Dozer bean mapper
	 */
	@Autowired
	DozerBeanMapper dozerMapper;

	@Override
	public PersonneVo createPersonne(PersonneVo personneVo) {
		if(personneVo != null) {
			personneVo.setId(null);
			Personne personne = this.dozerMapper.map(personneVo, Personne.class);
			this.personneRepository.create(personne);
			personneVo = this.dozerMapper.map(personne, PersonneVo.class);
		}
		return personneVo;
	}

	@Override
	public PersonneVo editPersonne(Long idPersonne, PersonneVo personneVo) {
		if(idPersonne != null && personneVo != null) {
			personneVo.setId(idPersonne);
			Personne personne = this.dozerMapper.map(personneVo, Personne.class);
			this.personneRepository.edit(personne);
			personneVo = this.dozerMapper.map(personne, PersonneVo.class);
		}
		return personneVo;
	}

	@Override
	public void deletePersonne(Long idPersonne) {
		if(idPersonne != null) {
			Personne personne = this.personneRepository.find(idPersonne);
			if(personne != null) {
				this.personneRepository.remove(personne);
			}
		}
	}

}
