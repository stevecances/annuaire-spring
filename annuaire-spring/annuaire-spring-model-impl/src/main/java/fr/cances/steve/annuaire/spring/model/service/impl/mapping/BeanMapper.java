/**
 * 
 */
package fr.cances.steve.annuaire.spring.model.service.impl.mapping;

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
public interface BeanMapper {
	
	public TelephoneVo telephoneToTelephoneVo(Telephone telephone);
	
	public Telephone telephoneVoToTelephone(TelephoneVo telephoneVo);
	
	public PersonneVo personneToPersonneVo(Personne personne);
	
	public Personne personneVoToPersonne(PersonneVo personneVo);
}
