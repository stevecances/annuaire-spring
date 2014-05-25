/**
 * 
 */
package fr.cances.steve.annuaire.spring.support.logger;


/**
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
public class LoggerLog4j implements Logger {

    /** Le logger log4j. */
    private final org.apache.log4j.Logger logger;

    /**
     * Constructeur protected de {@code DefaultLogger}.
     * 
     * @param clazz
     *            La classe à logger.
     */
    protected LoggerLog4j(final Class<?> clazz) {

        this.logger = org.apache.log4j.Logger.getLogger(clazz);
    }

    @Override
    public void trace(final String format, final Object... args) {

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(String.format(format, args));
        }
    }

    @Override
    public void debug(final String format, final Object... args) {

        if (this.logger.isDebugEnabled()) {
            this.logger.debug(String.format(format, args));
        }
    }

    @Override
    public void info(final String format, final Object... args) {

        if (this.logger.isInfoEnabled()) {
            this.logger.info(String.format(format, args));
        }
    }

    @Override
    public void warn(final String format, final Object... args) {

        this.logger.warn(String.format(format, args));
    }

    @Override
    public void error(final String format, final Object... args) {

        this.logger.error(String.format(format, args));
    }

    @Override
    public void trace(final Throwable cause, final String format,
            final Object... args) {

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(String.format(format, args), cause);
        }
    }

    @Override
    public void debug(final Throwable cause, final String format,
            final Object... args) {

        if (this.logger.isDebugEnabled()) {
            this.logger.debug(String.format(format, args), cause);
        }
    }

    @Override
    public void info(final Throwable cause, final String format,
            final Object... args) {

        if (this.logger.isInfoEnabled()) {
            this.logger.info(String.format(format, args), cause);
        }
    }

    @Override
    public void warn(final Throwable cause, final String format,
            final Object... args) {

        this.logger.warn(String.format(format, args), cause);
    }

    @Override
    public void error(final Throwable cause, final String format,
            final Object... args) {

        this.logger.error(String.format(format, args), cause);
    }

    /**
     * Logger shutdown
     */
    public static void shutdown() {

        // LogManager.shutdown();
    }

}
