package fr.cances.steve.annuaire.spring.model.service.impl.validation.vo;

import org.springframework.beans.BeanUtils;

import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.AbstractVo;
import fr.cances.steve.annuaire.spring.support.logger.Logger;
import fr.cances.steve.annuaire.spring.support.logger.LoggerFactory;

/**
 * Générateur de vo validation ({@link IVoValidation}) à partir de vos (
 * {@link AbstractVo}).
 * 
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
public class VoValidationGenerator<V extends AbstractVo<P>, A extends IVoValidation<V, P>, P> {

    /** Logger */
    private static final Logger LOGGER = LoggerFactory.getLogger(VoValidationGenerator.class);

    /** La classe du vo validation associée à la classe du vo */
    private final Class<A> voValidationClass;

    private VoValidationGenerator(final Class<A> voValidationClass) {

        this.voValidationClass = voValidationClass;
    }

    private A getVoValidationEmpty() {

        A voValidation = null;
        try {
            voValidation = this.voValidationClass.newInstance();
        } catch (InstantiationException | IllegalAccessException
                | IllegalArgumentException | SecurityException e) {
            LOGGER.error(e, "Erreur d'instantiation du vo validation : %s", this.voValidationClass);
        }
        return voValidation;
    }

    /**
     * Retourne Le vo validation correspondant au vo à valider.
     * 
     * @param vo
     *            Le vo à valider.
     * @return Le vo validation correspondant au vo à valider.
     */
    public A getVoValidation(final V vo) {

        LOGGER.info("Création d'un vo validation %s", this.voValidationClass);
        final A voValidation = this.getVoValidationEmpty();
        BeanUtils.copyProperties(vo, voValidation);
        return voValidation;
    }

    /**
     * Récupération d'un {@link VoValidationMapper}.
     * 
     * @param voClass
     *            La classe du vo à valider.
     * @param voValidationClass
     *            La classe du vo de validation correspondant au vo à valider.
     * @return Le {@link VoValidationMapper}.
     */
    public static <V extends AbstractVo<P>, A extends IVoValidation<V, P>, P> VoValidationGenerator<V, A, P> with(
            final Class<A> voValidationClass) {

        LOGGER.info("Création du VoValidationMapper : classe vo validation %s", voValidationClass);
        return new VoValidationGenerator<V, A, P>(voValidationClass);
    }
}
