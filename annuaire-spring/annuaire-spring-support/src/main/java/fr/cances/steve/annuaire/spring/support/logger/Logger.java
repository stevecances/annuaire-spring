/**
 * 
 */
package fr.cances.steve.annuaire.spring.support.logger;

/**
 * @author Steve Cancès
 * @version
 * @since
 */
public interface Logger {

    public void debug(String msg);

    public void debug(String msg, Throwable throwable);

    public void debug(String msg, Object... aguments);

    public void info(String msg);

    public void info(String msg, Throwable throwable);

    public void info(String msg, Object... aguments);

    public void warn(String msg);

    public void warn(String msg, Throwable throwable);

    public void warn(String msg, Object... aguments);

    public void error(String msg);

    public void error(String msg, Throwable throwable);

    public void error(String msg, Object... aguments);

}
