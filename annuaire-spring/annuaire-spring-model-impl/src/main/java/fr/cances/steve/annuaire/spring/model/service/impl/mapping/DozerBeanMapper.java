/**
 * 
 */
package fr.cances.steve.annuaire.spring.model.service.impl.mapping;

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
 *
 */
@Component("DozerBeanMapper")
public class DozerBeanMapper implements BeanMapper {
	
	/**
	 * Dozer bean mapper
	 */
	@Autowired
	org.dozer.DozerBeanMapper dozerMapper;

	@Override
	public TelephoneVo telephoneToTelephoneVo(Telephone telephone) {
		return this.dozerMapper.map(telephone, TelephoneVo.class);
	}

	@Override
	public Telephone telephoneVoToTelephone(TelephoneVo telephoneVo) {
		return this.dozerMapper.map(telephoneVo, Telephone.class);
	}
	
	@Override
	public void updateTelephoneFromTelephoneVo(TelephoneVo telephoneVo,
			Telephone telephone) {
		// TODO Auto-generated method stub
	}

	@Override
	public PersonneVo personneToPersonneVo(Personne personne) {
		return this.dozerMapper.map(personne, PersonneVo.class);
	}

	@Override
	public Personne personneVoToPersonne(PersonneVo personneVo) {
		return this.dozerMapper.map(personneVo, Personne.class);
	}
	
	@Override
	public void updatePersonneFromPersonneVo(PersonneVo personneVo,
			Personne personne) {
		// TODO Auto-generated method stub
	}

}
