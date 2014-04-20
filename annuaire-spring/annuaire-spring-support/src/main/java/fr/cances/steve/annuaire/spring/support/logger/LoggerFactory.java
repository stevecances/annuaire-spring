/**
 * 
 */
package fr.cances.steve.annuaire.spring.support.logger;

/**
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
public class LoggerFactory {

    private LoggerFactory() {
    }

    public static Logger getLogger(final Class<?> clazz) {
        return new LoggerLog4j(clazz);
    }
}
