package fr.cances.steve.annuaire.spring.model.service.impl.exception;

import java.util.Collection;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

import fr.cances.steve.annuaire.spring.model.service.api.exception.ResourceNotFoundException;
import fr.cances.steve.annuaire.spring.support.logger.Logger;
import fr.cances.steve.annuaire.spring.support.logger.LoggerFactory;

/**
 * Helper pour lever des exceptions.
 * 
 * @author Steve Cancès
 * @version 1.0
 */
@Component
public class ExceptionHelperImpl implements ExceptionHelper {

    private static final String TEMPLATE_EXCEPTION = "Exception";

    private static final String TEMPLATE_RESOURCE_NOT_FOUND_EXCEPTION = TEMPLATE_EXCEPTION
            + ".ResourceNotFound";

    private static final String STRING_WITH_TYPE = "withType";

    private static final String STRING_WITH_VALUE = "withValue";

    /** Logger */
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHelperImpl.class);

    /** Le message source pour acceder au properties */
    @Inject
    private MessageSource messageSource;

    /**
     * Permet de renseigner la valeur de l'attribut {@link #messageSource}.
     * 
     * @param messageSource
     *            La valeur de l'attribut messageSource à renseigner.
     */
    public void setMessageSource(final MessageSource messageSource) {

        this.messageSource = messageSource;
    }

    @Override
    public void throwResourceNotFoundException()
            throws ResourceNotFoundException {

        this.throwResourceNotFoundException(null);
    }

    @Override
    public void throwResourceNotFoundException(final Class<?> clazz)
            throws ResourceNotFoundException {

        this.throwResourceNotFoundException(clazz, null);
    }

    @Override
    public void throwResourceNotFoundException(final Class<?> clazz,
            final String value) throws ResourceNotFoundException {

        LOGGER.info("Demande de levée d'une ResourceNotFoundException pour une ressource de type %s avec la valeur %s",
                clazz, value);

        final StringBuilder template = new StringBuilder(TEMPLATE_RESOURCE_NOT_FOUND_EXCEPTION);
        final Collection<Object> args = Lists.newArrayList();

        if (clazz != null) {
            template.append('.').append(STRING_WITH_TYPE);
            args.add(clazz.getSimpleName());
            if (!StringUtils.isBlank(value)) {
                template.append('.').append(STRING_WITH_VALUE);
                args.add(value);
            }
        }

        LOGGER.info("Levée d'une ResourceNotFoundException pour une ressource de type %s avec la valeur %s",
                clazz, value);
        throw new ResourceNotFoundException(this.getLocalizedMessageFromTemplate(template.toString(),
                args.toArray()));
    }

    /**
     * Retourne un message internationnalisé à partir d'un template et
     * d'arguments.
     * 
     * @param template
     *            Le template correspondant au message.
     * @param args
     *            Les arguments du message.
     * @return Un message internationnalisé à partir d'un template et
     *         d'arguments.
     */
    private String getLocalizedMessageFromTemplate(final String template,
            final Object... args) {

        return this.messageSource.getMessage(template,
                args,
                template,
                LocaleContextHolder.getLocale());

    }
}
