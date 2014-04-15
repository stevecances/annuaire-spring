/**
 * 
 */
package fr.cances.steve.annuaire.spring.ws.valueobjects;

import org.hibernate.validator.constraints.NotEmpty;

import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.PersonneVo;

/**
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class PersonneVoCreate extends PersonneVo {
	
	@NotEmpty
	public String getNom() {
		return nom;
	}
	
	@NotEmpty
	public String getPrenom() {
		return prenom;
	}

}
