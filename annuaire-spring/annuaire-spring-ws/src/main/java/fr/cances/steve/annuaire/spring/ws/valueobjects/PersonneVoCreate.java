/**
 * 
 */
package fr.cances.steve.annuaire.spring.ws.valueobjects;

import org.hibernate.validator.constraints.NotBlank;

import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.PersonneVo;

/**
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class PersonneVoCreate extends PersonneVo {
	
	@NotBlank
	public String getNom() {
		return nom;
	}
	
	@NotBlank
	public String getPrenom() {
		return prenom;
	}

}
