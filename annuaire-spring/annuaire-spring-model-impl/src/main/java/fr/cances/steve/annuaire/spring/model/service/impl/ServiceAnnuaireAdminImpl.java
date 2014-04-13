/**
 * 
 */
package fr.cances.steve.annuaire.spring.model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.cances.steve.annuaire.spring.model.persistence.entities.Personne;
import fr.cances.steve.annuaire.spring.model.persistence.repositories.PersonneRepository;
import fr.cances.steve.annuaire.spring.model.service.api.ServiceAnnuaireAdmin;
import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.PersonneVo;
import fr.cances.steve.annuaire.spring.model.service.impl.mapping.BeanMapper;

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
	 * Bean mapper
	 */
	@Autowired
	@Qualifier("HandyBeanMapper")
	BeanMapper beanMapper;

	@Override
	public PersonneVo createPersonne(PersonneVo personneVo) {
		if(personneVo != null) {
			personneVo.setId(null);
			Personne personne = this.beanMapper.personneVoToPersonne(personneVo);
			personne = this.personneRepository.create(personne);
			personneVo = this.beanMapper.personneToPersonneVo(personne);
		}
		return personneVo;
	}

	@Override
	public PersonneVo editPersonne(Long idPersonne, PersonneVo personneVo) {
		if(idPersonne != null && personneVo != null) {
			personneVo.setId(idPersonne);
			Personne personne = this.beanMapper.personneVoToPersonne(personneVo);
			personne = this.personneRepository.edit(personne);
			personneVo = this.beanMapper.personneToPersonneVo(personne);
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
