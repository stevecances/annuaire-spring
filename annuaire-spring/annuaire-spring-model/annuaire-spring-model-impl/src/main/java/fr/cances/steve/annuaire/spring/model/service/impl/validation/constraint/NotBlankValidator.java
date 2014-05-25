package fr.cances.steve.annuaire.spring.model.service.impl.validation.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

/**
 * Validateur pour la constrainte {@link NotBlank}
 * 
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
public class NotBlankValidator implements ConstraintValidator<NotBlank, String> {

    @Override
    public void initialize(final NotBlank constraintAnnotation) {

    }

    @Override
    public boolean isValid(final String value,
            final ConstraintValidatorContext context) {

        return StringUtils.isNotBlank(value);
    }

}
