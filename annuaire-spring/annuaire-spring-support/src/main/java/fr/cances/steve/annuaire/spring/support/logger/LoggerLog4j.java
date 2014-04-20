/**
 * 
 */
package fr.cances.steve.annuaire.spring.support.logger;

import org.slf4j.LoggerFactory;

/**
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
public class LoggerLog4j implements Logger {

    private final org.slf4j.Logger logger;

    public LoggerLog4j(final Class<?> clazz) {
        this.logger = LoggerFactory.getLogger(clazz);
    }

    @Override
    public void debug(final String msg) {
        this.logger.debug(msg);
    }

    @Override
    public void debug(final String msg, final Throwable throwable) {
        this.logger.debug(msg, throwable);
    }

    @Override
    public void debug(final String msg, final Object... aguments) {
        this.logger.debug(msg, aguments);
    }

    @Override
    public void info(final String msg) {
        this.logger.info(msg);
    }

    @Override
    public void info(final String msg, final Throwable throwable) {
        this.logger.info(msg, throwable);
    }

    @Override
    public void info(final String msg, final Object... aguments) {
        this.logger.info(msg, aguments);
    }

    @Override
    public void warn(final String msg) {
        this.logger.warn(msg);
    }

    @Override
    public void warn(final String msg, final Throwable throwable) {
        this.logger.warn(msg, throwable);
    }

    @Override
    public void warn(final String msg, final Object... aguments) {
        this.logger.warn(msg, aguments);
    }

    @Override
    public void error(final String msg) {
        this.logger.error(msg);
    }

    @Override
    public void error(final String msg, final Throwable throwable) {
        this.logger.error(msg, throwable);
    }

    @Override
    public void error(final String msg, final Object... aguments) {
        this.logger.debug(msg, aguments);
    }

}
