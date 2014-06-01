/**
 *
 */
package fr.cances.steve.annuaire.spring.ws.config;

import fr.cances.steve.annuaire.spring.support.logger.Logger;
import fr.cances.steve.annuaire.spring.support.logger.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
@Order(2)
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(AppInitializer.class);

    @Override
    protected Class<?>[] getRootConfigClasses() {
        LOGGER.info("Récupération des classes de config racine");
        return new Class[] { RootConfig.class, WebMvcSecurityConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        LOGGER.info("Récupération des mappings de servlet");
        return new String[] { "/" };
    }

}
