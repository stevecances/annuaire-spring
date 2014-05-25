package fr.cances.steve.annuaire.spring.model.service.api.exception;

import fr.cances.steve.annuaire.spring.model.service.api.exception.vo.ValidationErrorVo;

/**
 * Exception levée lors de l'echec d'un validation.
 * 
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
public class BeanValidationException extends Exception {

    /** Serial Version UID */
    private static final long serialVersionUID = -3460299445014438129L;

    /** Le vo representant les erreurs de validation */
    private final ValidationErrorVo validationErrorVo;

    /**
     * Constructeur de {@code validationErrorVo};
     * 
     * @param validationErrorVo
     *            Les erreurs de validation.
     */
    public BeanValidationException(final ValidationErrorVo validationErrorVo) {

        this.validationErrorVo = validationErrorVo;
    }

    /**
     * Permet de récupérer la valeur de l'attribut {@link #validationErrorVo}.
     * 
     * @return L'attribut validationErrorVo.
     */
    public ValidationErrorVo getValidationErrorVo() {

        return validationErrorVo;
    }

}
