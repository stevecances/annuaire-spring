/**
 * 
 */
package fr.cances.steve.annuaire.spring.ws.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@ControllerAdvice
public class RestErrorHandler {

	//private static final Logger LOGGER = LoggerFactory.getLogger(RestErrorHandler.class);

	@Autowired
	private MessageSource messageSource;

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ValidationErrorVo processValidationError(MethodArgumentNotValidException ex) {
		//LOGGER.debug("Handling form validation error");

		BindingResult result = ex.getBindingResult();
		List<FieldError> fieldErrors = result.getFieldErrors();

		return processFieldErrors(fieldErrors);
	}

	private ValidationErrorVo processFieldErrors(List<FieldError> fieldErrors) {
		ValidationErrorVo validationErrorVo = new ValidationErrorVo();

		for (FieldError fieldError: fieldErrors) {
			String localizedErrorMessage = resolveLocalizedErrorMessage(fieldError);
			//LOGGER.debug("Adding error message: {} to field: {}", localizedErrorMessage, fieldError.getField());
			validationErrorVo.addFieldError(fieldError.getField(), localizedErrorMessage);
		}

		return validationErrorVo;
	}

	private String resolveLocalizedErrorMessage(FieldError fieldError) {
		Locale currentLocale = LocaleContextHolder.getLocale();
		String localizedErrorMessage = messageSource.getMessage(fieldError, currentLocale);

		//If a message was not found, return the most accurate field error code instead.
		//You can remove this check if you prefer to get the default error message.
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
	 *
	 */
	public class FieldErrorVo {

		private String field;

		private String message;

		public FieldErrorVo(String field, String message) {
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
	 *
	 */
	public class ValidationErrorVo {
		
		private final List<FieldErrorVo> fieldErrors = new ArrayList<>();

		public void addFieldError(String path, String message) {
			this.fieldErrors.add(new FieldErrorVo(path, message));
		}

		public List<FieldErrorVo> getFieldErrors() {
			return this.fieldErrors;
		}
	}


}
