
package fr.cances.steve.annuaire.spring.ws.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

/**
 * Permet de tester si une String est null OU n'est pas blank
 * 
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class NullOrNotBlankValidator implements ConstraintValidator<NullOrNotBlank, String> {

	@Override
	public void initialize(NullOrNotBlank constraintAnnotation) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return (value == null || !StringUtils.isBlank(value));
	}

}
