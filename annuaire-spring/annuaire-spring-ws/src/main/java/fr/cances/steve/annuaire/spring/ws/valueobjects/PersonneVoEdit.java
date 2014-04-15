/**
 * 
 */
package fr.cances.steve.annuaire.spring.ws.valueobjects;

import javax.validation.constraints.NotNull;

import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.PersonneVo;

/**
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class PersonneVoEdit extends PersonneVo {
	
	@NotNull
	public Long getId() {
		return id;
	}

}
