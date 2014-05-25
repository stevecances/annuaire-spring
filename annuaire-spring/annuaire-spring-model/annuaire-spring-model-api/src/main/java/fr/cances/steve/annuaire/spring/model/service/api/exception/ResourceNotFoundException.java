package fr.cances.steve.annuaire.spring.model.service.api.exception;

/**
 * Exception levée lorsqu'une ressource necessaire n'est pas trouvée.
 * 
 * @author Steve Cancès
 * @version 1.0
 */
public class ResourceNotFoundException extends Exception {

    /** Serial Version UID */
    private static final long serialVersionUID = 4155355222640376072L;

    /**
     * Constructeur de {@code ResourceNotFoundException}.
     */
    public ResourceNotFoundException() {

        this("Resource not found");
    }

    /**
     * Constructeur de {@code ResourceNotFoundException} avec un message d'erreur.
     * 
     * @param message
     *            Le message d'erreur.
     */
    public ResourceNotFoundException(final String message) {

        this(message, null);
    }

    /**
     * Constructeur de {@code ResourceNotFoundException} avec un message d'erreur et une cause.
     * 
     * @param message
     *            Le message d'erreur.
     * @param cause
     *            La cause.
     */
    public ResourceNotFoundException(final String message, final Throwable cause) {

        super(message, cause);
    }

}
