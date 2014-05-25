package fr.cances.steve.annuaire.spring.model.service.api.exception.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Vo representant un ensemble de champs en erreur.
 * 
 * @author Steve Cancès
 * @version 1.0
 */
public class ValidationErrorVo extends ErrorVo {

    /* ---------------- */
    /* -- CONSTANTES -- */
    /* ---------------- */

    /* --------------- */
    /* -- ATTRIBUTS -- */
    /* --------------- */

    /** La liste des champs en erreur ({@link FieldErrorVo}). */
    private final List<FieldErrorVo> fieldErrors;

    /* ------------------- */
    /* -- CONSTRUCTEURS -- */
    /* ------------------- */

    /**
     * Constructeur du {@code ValidationErrorVo} avec un message d'erreur concernant l'ensemble de
     * la validation.
     * 
     * @param message
     *            Le message d'erreur concernant l'ensemble de la validation.
     */
    public ValidationErrorVo(final String message) {

        super(message);
        this.fieldErrors = new ArrayList<>();
    }

    /**
     * Constructeur du {@code ValidationErrorVo} avec un message d'erreur concernant l'ensemble de
     * la validation et une collection d'erreurs sur des champs ({@link FieldErrorVo}).
     * 
     * @param message
     *            Le message d'erreur concernant l'ensemble de la validation.
     * @param fieldErrorsVo
     *            La liste des champs en erreur ({@link FieldErrorVo}).
     */
    public ValidationErrorVo(final String message,
            final Collection<FieldErrorVo> fieldErrorsVo) {

        this(message);
        this.fieldErrors.addAll(fieldErrorsVo);
    }

    /* --------------------- */
    /* -- GETTERS/SETTERS -- */
    /* --------------------- */

    /**
     * Ajouter un champs en erreur.
     * 
     * @param path
     *            Le nom du champs.
     * @param message
     *            Le message d'erreur associé au champs.
     */
    public void addFieldError(final String path, final String message) {

        this.fieldErrors.add(new FieldErrorVo(path, message));
    }

    /**
     * Récupérer la liste des champs en erreur (avec leurs messages).
     * 
     * @return la liste des champs en erreur (avec leurs messages).
     */
    public List<FieldErrorVo> getFieldErrors() {

        return this.fieldErrors;
    }

    /* -------------- */
    /* -- METHODES -- */
    /* -------------- */

    @Override
    public String toString() {

        return new StringBuilder()
                                  .append("ValidationErrorVo [fieldErrors=")
                                  .append(fieldErrors)
                                  .append("]")
                                  .toString();
    }

}
