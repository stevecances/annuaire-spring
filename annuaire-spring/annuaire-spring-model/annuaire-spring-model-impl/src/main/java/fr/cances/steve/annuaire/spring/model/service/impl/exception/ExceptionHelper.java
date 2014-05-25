package fr.cances.steve.annuaire.spring.model.service.impl.exception;

import fr.cances.steve.annuaire.spring.model.service.api.exception.ResourceNotFoundException;

/**
 * Helper pour lever des exceptions.
 * 
 * @author Steve Cancès
 * @version 1.0
 */
public interface ExceptionHelper {

    /**
     * Leve une {@link ResourceNotFoundException}.
     * 
     * @throws ResourceNotFoundException
     *             L'exception levée.
     */
    public void throwResourceNotFoundException()
            throws ResourceNotFoundException;

    /**
     * Leve une {@link ResourceNotFoundException}.
     * 
     * @param clazz
     *            La classe de la ressource non trouvée.
     * @throws ResourceNotFoundException
     *             L'exception levée.
     */
    public void throwResourceNotFoundException(final Class<?> clazz)
            throws ResourceNotFoundException;

    /**
     * Leve une {@link ResourceNotFoundException}.
     * 
     * @param clazz
     *            La classe de la ressource non trouvée.
     * @param value
     *            La valeur pour laquelle la ressource est non trouvée.
     * @throws ResourceNotFoundException
     *             L'exception levée.
     */
    public void throwResourceNotFoundException(final Class<?> clazz,
            final String value) throws ResourceNotFoundException;

}
