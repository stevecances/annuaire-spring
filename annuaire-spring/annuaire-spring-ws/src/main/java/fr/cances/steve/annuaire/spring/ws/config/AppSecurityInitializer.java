/**
 *
 */
package fr.cances.steve.annuaire.spring.ws.config;

import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

/**
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
@Order(1)
public class AppSecurityInitializer extends AbstractSecurityWebApplicationInitializer {

    @Override
    protected String getDispatcherWebApplicationContextSuffix() {

        return AbstractDispatcherServletInitializer.DEFAULT_SERVLET_NAME;
    }

}
