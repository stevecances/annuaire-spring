package fr.cances.steve.annuaire.spring.model.service.impl.validation;

import java.util.List;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import com.google.common.base.Function;
import com.google.common.base.Splitter;
import com.google.common.collect.FluentIterable;

import fr.cances.steve.annuaire.spring.model.service.api.exception.BeanValidationException;
import fr.cances.steve.annuaire.spring.model.service.api.exception.vo.FieldErrorVo;
import fr.cances.steve.annuaire.spring.model.service.api.exception.vo.ValidationErrorVo;
import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.AbstractVo;
import fr.cances.steve.annuaire.spring.model.service.impl.validation.vo.IVoValidation;
import fr.cances.steve.annuaire.spring.support.logger.Logger;
import fr.cances.steve.annuaire.spring.support.logger.LoggerFactory;

/**
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
@Component
public class BeanValidatorImpl<V extends AbstractVo<P>, P> implements BeanValidator<V, P> {

    /** Le nom de la property d'erreur de validation */
    private static final String VALIDATION_ERROR_MESSAGE_CODE = "validation.error";

    /** Le message par default de l'erreur de validation */
    private static final String VALIDATION_ERROR_DEFAULT_MESSAGE = "Some fields contain errors";

    /** Logger */
    private static final Logger LOGGER = LoggerFactory.getLogger(BeanValidatorImpl.class);

    /** Le message source pour acceder au properties */
    @Inject
    private MessageSource messageSource;

    /** Le validator de contraintes javax.validation */
    @Inject
    private Validator validator;

    /**
     * Constructeur de {@code BeanValidatorImpl}.
     */
    public BeanValidatorImpl() {

    }

    /**
     * Constructeur de {@code BeanValidatorImpl}.
     * 
     * @param messageSource
     *            Le message source pour acceder au properties.
     * @param validator
     *            Le validator de contraintes javax.validation.
     */
    public BeanValidatorImpl(final MessageSource messageSource,
            final Validator validator) {

        this.validator = validator;
        this.messageSource = messageSource;
    }

    @Override
    public void validate(
            final IVoValidation<V, P> voValidation,
            final Class<?>... groups) throws BeanValidationException {

        LOGGER.info("Debut du processus de validation du bean : %s",
                voValidation.getClass().getSimpleName());
        final String msgValidationErrorVo = this.messageSource.getMessage(VALIDATION_ERROR_MESSAGE_CODE,
                null,
                VALIDATION_ERROR_DEFAULT_MESSAGE,
                LocaleContextHolder.getLocale());

        final List<FieldErrorVo> fieldErrorsVo = FluentIterable
                .from(this.validator.validate(voValidation,
                        groups))
                .transform(new Function<ConstraintViolation<?>, FieldErrorVo>() {

                    @Override
                    public FieldErrorVo apply(
                            final ConstraintViolation<?> constraintViolation) {

                        return new FieldErrorVo(
                                getPropertyNameFromConstraintViolation(constraintViolation),
                                getLocalizedMessageFromConstraintViolation(constraintViolation)
                        );
                    }

                })
                .toList();

        final ValidationErrorVo validationErrorVo = new ValidationErrorVo(msgValidationErrorVo, fieldErrorsVo);
        if (!CollectionUtils.isEmpty(validationErrorVo.getFieldErrors())) {
            LOGGER.info("Des erreurs de validation sont présentes, levé d'une %s",
                    BeanValidationException.class);
            throw new BeanValidationException(validationErrorVo);
        }
    }

    /**
     * Retourne le message d'erreur (internationalisé) correspondant à la
     * violation de contrainte. Si le message n'est pas défini, alors le code du
     * message est retourné.
     * 
     * @param constraintViolation
     *            La violation de contrainte
     * @return le message d'erreur (internationalisé) correspondant à la
     *         violation de contrainte.
     */
    private String getLocalizedMessageFromConstraintViolation(
            final ConstraintViolation<?> constraintViolation) {

        final String messageTemplate = this.getMessageTemplateFromConstraintViolation(constraintViolation);
        return this.messageSource.getMessage(messageTemplate,
                null,
                messageTemplate,
                LocaleContextHolder.getLocale());
    }

    /**
     * Retourne le code du message correspondant à la violation de contrainte
     * 
     * @param constraintViolation
     *            La violation de contrainte
     * @return le code du message correspondant à la violation de contrainte
     */
    private String getMessageTemplateFromConstraintViolation(
            final ConstraintViolation<?> constraintViolation) {

        final List<String> splitToList = Splitter.on('.').splitToList(constraintViolation.getMessageTemplate());
        return new StringBuilder()
                .append(constraintViolation.getRootBean().getClass().getSimpleName())
                .append('.')
                .append(constraintViolation.getPropertyPath())
                .append('.')
                .append(splitToList.get(splitToList.size() - 2))
                .toString();
    }

    /**
     * Retourne le nom de l'attribut concerné par la violation de contrainte
     * 
     * @param constraintViolation
     *            La violation de contrainte
     * @return Le nom de l'attribut concerné par la violation de contrainte
     */
    private String getPropertyNameFromConstraintViolation(
            final ConstraintViolation<?> constraintViolation) {

        return constraintViolation.getPropertyPath().toString();
    }
}
