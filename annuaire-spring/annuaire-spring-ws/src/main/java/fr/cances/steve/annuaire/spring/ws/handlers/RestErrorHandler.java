/**
 *
 */
package fr.cances.steve.annuaire.spring.ws.handlers;

import fr.cances.steve.annuaire.spring.model.service.api.exception.BeanValidationException;
import fr.cances.steve.annuaire.spring.model.service.api.exception.ResourceNotFoundException;
import fr.cances.steve.annuaire.spring.model.service.api.exception.vo.ErrorVo;
import fr.cances.steve.annuaire.spring.support.logger.Logger;
import fr.cances.steve.annuaire.spring.support.logger.LoggerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
@ControllerAdvice
public class RestErrorHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestErrorHandler.class);

    @Inject
    private MessageSource messageSource;

    /* ---------------- */
    /* -- OVERRIDED --- */
    /* ---------------- */
    /**
     * Gestion des MethodArgumentNotValidException (levée lors d'une validation)
     * 
     * @param ex
     *            la MethodArgumentNotValidException
     * @return le ValidationErrorVo
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            final MethodArgumentNotValidException ex,
            final HttpHeaders headers, final HttpStatus status,
            final WebRequest request) {

        LOGGER.info("Interception d'une erreur de validation : (%s)",
                MethodArgumentNotValidException.class.getName());

        final BindingResult result = ex.getBindingResult();
        final List<FieldError> fieldErrors = result.getFieldErrors();

        return new ResponseEntity<>(processFieldErrors(fieldErrors), HttpStatus.BAD_REQUEST);
    }

    /**
     * Gestion des BeanValidationException (levée lors de la validation de
     * bean).
     * 
     * @param exception
     *            la BeanValidationException
     * @return ValidationErrorVo qui représente les erreurs de validation
     */
    @ExceptionHandler(BeanValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorVo handleBeanValidationException(
            final BeanValidationException exception) {

        LOGGER.info("Interception d'une erreur de validation : (%s)",
                exception.getValidationErrorVo());
        return exception.getValidationErrorVo();
    }

    /**
     * Gestion des ResourceNotFoundException (Levée lorsqu'une ressource est
     * introuvable).
     * 
     * @param ex
     *            la ResourceNotFoundException
     * @return L'ErrorVo qui contient le message
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorVo handleResourceNotFoundException(
            final ResourceNotFoundException ex) {

        LOGGER.info("Interception d'une erreur de resource non trouvée (%s)",
                ResourceNotFoundException.class.getName());
        return new ErrorVo(ex.getMessage());
    }

    private ValidationErrorVo processFieldErrors(final List<FieldError> fieldErrors) {
        ValidationErrorVo validationErrorVo = new ValidationErrorVo();

        fieldErrors.stream().forEach((fieldError) -> {
            String localizedErrorMessage = resolveLocalizedErrorMessage(fieldError);
            LOGGER.debug("Adding error message: {} to field: {}", localizedErrorMessage, fieldError.getField());
            validationErrorVo.addFieldError(fieldError.getField(), localizedErrorMessage);
        });

        return validationErrorVo;
    }

    private String resolveLocalizedErrorMessage(final FieldError fieldError) {
        Locale currentLocale = LocaleContextHolder.getLocale();
        String localizedErrorMessage = messageSource.getMessage(fieldError, currentLocale);

        // If a message was not found, return the most accurate field error code
        // instead.
        // You can remove this check if you prefer to get the default error
        // message.
        if (localizedErrorMessage.equals(fieldError.getDefaultMessage())) {
            String[] fieldErrorCodes = fieldError.getCodes();
            localizedErrorMessage = fieldErrorCodes[0];
        }

        return localizedErrorMessage;
    }

    /**
     * Une erreur correspondant à un champs d'un vo
     * 
     * @author Steve Cancès
     * @version 1.0.0
     * @since 1.0.0
     */
    public class FieldErrorVo {

        private final String field;

        private final String message;

        public FieldErrorVo(final String field, final String message) {
            this.field = field;
            this.message = message;
        }

        public String getField() {
            return field;
        }

        public String getMessage() {
            return message;
        }
    }

    /**
     * Un ensemble de FieldErrorVo correspondant à la validation d'un vo
     * 
     * @author Steve Cancès
     * @version 1.0.0
     * @since 1.0.0
     */
    public class ValidationErrorVo {

        private final List<FieldErrorVo> fieldErrors = new ArrayList<>();

        public void addFieldError(final String path, final String message) {
            this.fieldErrors.add(new FieldErrorVo(path, message));
        }

        public List<FieldErrorVo> getFieldErrors() {
            return this.fieldErrors;
        }
    }

}
