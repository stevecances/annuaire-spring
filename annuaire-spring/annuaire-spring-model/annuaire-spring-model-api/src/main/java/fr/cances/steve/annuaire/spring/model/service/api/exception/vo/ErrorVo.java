package fr.cances.steve.annuaire.spring.model.service.api.exception.vo;

/**
 * Vo representant une erreur avec son message.
 * 
 * @author Steve Cancès
 * @version 1.0
 */
public class ErrorVo {

    /* ---------------- */
    /* -- CONSTANTES -- */
    /* ---------------- */

    /* --------------- */
    /* -- ATTRIBUTS -- */
    /* --------------- */

    /**
     * Le message d'erreur.
     */
    protected final String message;

    /* ------------------- */
    /* -- CONSTRUCTEURS -- */
    /* ------------------- */

    /**
     * Constructeur d'un {@code ErrorVo} avec son message d'erreur.
     * 
     * @param message
     *            Le message d'erreur.
     */
    public ErrorVo(final String message) {

        this.message = message;
    }

    /* --------------------- */
    /* -- GETTERS/SETTERS -- */
    /* --------------------- */

    /**
     * Permet de récupérer la valeur de l'attribut {@link #message}.
     * 
     * @return L'attribut message.
     */
    public String getMessage() {

        return message;
    }

    /* -------------- */
    /* -- METHODES -- */
    /* -------------- */

    @Override
    public String toString() {

        return new StringBuilder().append("ErrorVo [message=").append(message).append("]").toString();
    }

}
