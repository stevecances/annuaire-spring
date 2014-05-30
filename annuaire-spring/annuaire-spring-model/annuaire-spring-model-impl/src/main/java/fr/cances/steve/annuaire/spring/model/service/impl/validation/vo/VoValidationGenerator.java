package fr.cances.steve.annuaire.spring.model.service.impl.validation.vo;

import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.AbstractVo;
import fr.cances.steve.annuaire.spring.support.logger.Logger;
import fr.cances.steve.annuaire.spring.support.logger.LoggerFactory;
import org.springframework.beans.BeanUtils;

/**
 * Générateur de vo validation ({@link IVoValidation}) à partir de vos (
 * {@link AbstractVo}).
 * 
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 * @param <V>
 *            Classe du vo à valider.
 * @param <A>
 *            Classe du voValidation.
 * @param <P>
 *            Classe de l'identifiant du vo.
 */
public class VoValidationGenerator<V extends AbstractVo<P>, A extends IVoValidation<V, P>, P> {

    /**
     * Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(VoValidationGenerator.class);

    /**
     * La classe du vo validation associée à la classe du vo
     */
    private final Class<A> voValidationClass;

    private VoValidationGenerator(final Class<A> voValidationClass) {

        this.voValidationClass = voValidationClass;
    }

    private A getVoValidationEmpty() {

        A voValidation = null;
        try {
            voValidation = this.voValidationClass.newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | SecurityException e) {
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
     * Récupération d'un {@code VoValidationGenerator}.
     * 
     * @param <V>
     *            Classe du vo à valider.
     * @param <A>
     *            Classe du voValidation.
     * @param <P>
     *            Classe de l'identifiant du vo.
     * @param voValidationClass
     *            La classe du vo de validation correspondant au vo à valider.
     * @return Le {@code VoValidationGenerator}.
     */
    public static <V extends AbstractVo<P>, A extends IVoValidation<V, P>, P> VoValidationGenerator<V, A, P> with(
            final Class<A> voValidationClass) {

        LOGGER.info("Création du VoValidationMapper : classe vo validation %s", voValidationClass);
        return new VoValidationGenerator<>(voValidationClass);
    }
}
