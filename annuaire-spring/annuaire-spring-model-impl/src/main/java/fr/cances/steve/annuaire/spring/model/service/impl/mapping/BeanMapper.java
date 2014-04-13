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
	
	/**
	 * 
	 * @author Steve Cancès
	 * @Since 1.0.0
	 * 
	 * @param telephone
	 * @return
	 */
	public TelephoneVo telephoneToTelephoneVo(Telephone telephone);
	
	/**
	 * 
	 * @author Steve Cancès
	 * @Since 1.0.0
	 * 
	 * @param telephoneVo
	 * @return
	 */
	public Telephone telephoneVoToTelephone(TelephoneVo telephoneVo);
	
	/**
	 * 
	 * @author Steve Cancès
	 * @Since 1.0.0
	 * 
	 * @param telephoneVo
	 * @param telephone
	 */
	public void updateTelephoneFromTelephoneVo(TelephoneVo telephoneVo, Telephone telephone);
	
	/**
	 * 
	 * @author Steve Cancès
	 * @Since 1.0.0
	 * 
	 * @param personne
	 * @return
	 */
	public PersonneVo personneToPersonneVo(Personne personne);
	
	/**
	 * 
	 * @author Steve Cancès
	 * @Since 1.0.0
	 * 
	 * @param personneVo
	 * @return
	 */
	public Personne personneVoToPersonne(PersonneVo personneVo);
	
	/**
	 * 
	 * @author Steve Cancès
	 * @Since 1.0.0
	 * 
	 * @param personneVo
	 * @param personne
	 */
	public void updatePersonneFromPersonneVo(PersonneVo personneVo, Personne personne);
}
