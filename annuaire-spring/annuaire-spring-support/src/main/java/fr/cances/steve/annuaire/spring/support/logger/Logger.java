package fr.cances.steve.annuaire.spring.support.logger;

/**
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
public interface Logger {

    /**
     * Log de niveau trace.
     * 
     * @param format
     *            Le message de log.
     * @param args
     *            Les arguments du message de log.
     */
    void trace(String format, Object... args);

    /**
     * Log de niveau debug.
     * 
     * @param format
     *            Le message de log.
     * @param args
     *            Les arguments du message de log.
     */
    void debug(String format, Object... args);

    /**
     * Log de niveau info.
     * 
     * @param format
     *            Le message de log.
     * @param args
     *            Les arguments du message de log.
     */
    void info(String format, Object... args);

    /**
     * Log de niveau warn.
     * 
     * @param format
     *            Le message de log.
     * @param args
     *            Les arguments du message de log.
     */
    void warn(String format, Object... args);

    /**
     * Log de niveau error.
     * 
     * @param format
     *            Le message de log.
     * @param args
     *            Les arguments du message de log.
     */
    void error(String format, Object... args);

    /**
     * Log de niveau trace.
     * 
     * @param cause
     *            La cause du log.
     * @param format
     *            Le message de log.
     * @param args
     *            Les arguments du message de log.
     */
    void trace(Throwable cause, String format, Object... args);

    /**
     * Log de niveau debug.
     * 
     * @param cause
     *            La cause du log.
     * @param format
     *            Le message de log.
     * @param args
     *            Les arguments du message de log.
     */
    void debug(Throwable cause, String format, Object... args);

    /**
     * Log de niveau info.
     * 
     * @param cause
     *            La cause du log.
     * @param format
     *            Le message de log.
     * @param args
     *            Les arguments du message de log.
     */
    void info(Throwable cause, String format, Object... args);

    /**
     * Log de niveau warn.
     * 
     * @param cause
     *            La cause du log.
     * @param format
     *            Le message de log.
     * @param args
     *            Les arguments du message de log.
     */
    void warn(Throwable cause, String format, Object... args);

    /**
     * Log de niveau error.
     * 
     * @param cause
     *            La cause du log.
     * @param format
     *            Le message de log.
     * @param args
     *            Les arguments du message de log.
     */
    void error(Throwable cause, String format, Object... args);

}
