package fr.cances.steve.annuaire.spring.model.service.api.exception.vo;

/**
 * Vo representant une erreur sur un champs.
 * 
 * @author Steve Cancès
 * @version 1.0
 */
public class FieldErrorVo extends ErrorVo {

    /* ---------------- */
    /* -- CONSTANTES -- */
    /* ---------------- */

    /* --------------- */
    /* -- ATTRIBUTS -- */
    /* --------------- */

    /**
     * Le champs concernée par l'erreur.
     */
    private final String field;

    /* ------------------- */
    /* -- CONSTRUCTEURS -- */
    /* ------------------- */

    /**
     * Constructeur d'un {@code FieldErrorVo}.
     * 
     * @param field
     *            Le champs concerné par l'erreur.
     * @param message
     *            Le message d'erreur.
     */
    public FieldErrorVo(final String field, final String message) {

        super(message);
        this.field = field;
    }

    /* --------------------- */
    /* -- GETTERS/SETTERS -- */
    /* --------------------- */

    /**
     * Permet de récupérer la valeur de l'attribut {@link #field}.
     * 
     * @return L'attribut field.
     */
    public String getField() {

        return field;
    }

    /* -------------- */
    /* -- METHODES -- */
    /* -------------- */

    @Override
    public String toString() {

        return new StringBuilder()
                                  .append("FieldErrorVo [field=")
                                  .append(field)
                                  .append(", message=")
                                  .append(message)
                                  .append("]")
                                  .toString();
    }

}
