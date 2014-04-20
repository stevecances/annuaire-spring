package fr.cances.steve.annuaire.spring.ws.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

import fr.cances.steve.annuaire.spring.support.logger.Logger;
import fr.cances.steve.annuaire.spring.support.logger.LoggerFactory;

/**
 * Permet de tester si une String est null OU n'est pas blank
 * 
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
public class NullOrNotBlankValidator implements ConstraintValidator<NullOrNotBlank, String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(NullOrNotBlankValidator.class);

    @Override
    public void initialize(final NullOrNotBlank constraintAnnotation) {
        LOGGER.debug("Initialisation NullOrNotBlankValidator");
    }

    @Override
    public boolean isValid(final String value, final ConstraintValidatorContext context) {
        return value == null || StringUtils.hasText(value);
    }

}
