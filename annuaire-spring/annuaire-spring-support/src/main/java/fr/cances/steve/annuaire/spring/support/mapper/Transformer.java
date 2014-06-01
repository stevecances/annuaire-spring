package fr.cances.steve.annuaire.spring.support.mapper;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;
import fr.cances.steve.annuaire.spring.support.logger.Logger;
import fr.cances.steve.annuaire.spring.support.logger.LoggerFactory;
import java.util.Collection;

/**
 * S'appuie sur un {@link Mapper} pour transformer des {@link Collection}
 * (mapper tous les elements de la {@link Collection}).
 * 
 * @author Steve Cancès
 * @version 1.0
 * @param <I>
 *            Input class
 * @param <O>
 *            Output class
 */
public class Transformer<I, O> implements Mapper<I, O> {

    /**
     * Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(Transformer.class);

    /**
     * Le mapper
     */
    protected Mapper<I, O> mapper;

    /**
     * Constructeur protected de {@code Transformer}.
     * 
     * @param beanMapper
     *            Le {@link Mapper} utilisé par le {@code Transformer}.
     */
    protected Transformer(final Mapper<I, O> beanMapper) {

        this.mapper = beanMapper;
    }

    @Override
    public O transform(final I input) {

        return this.mapper.transform(input);
    }

    @Override
    public I reverse(final O output) {

        return this.mapper.reverse(output);
    }

    /**
     * Map l'ensemble des elements de la {@link Collection} inputs dans une
     * nouvelle {@link Collection} outputs.
     * <p>
     * Ne modifie ni la {@link Collection} inputs, ni les elements de cette
     * collection.
     * </p>
     * 
     * @param inputs
     *            La {@link Collection} d'elements à mapper.
     * @return outputs La {@link Collection} d'elements mappés.
     */
    public Collection<O> transform(final Collection<I> inputs) {

        return Lists.newArrayList(FluentIterable.from(inputs).transform(Transformer.this::transform));
    }

    /**
     * Map l'ensemble des elements de la {@link Collection} outputs dans une
     * nouvelle {@link Collection} inputs.
     * <p>
     * Ne modifie ni la {@link Collection} outputs, ni les elements de cette
     * collection.
     * </p>
     * 
     * @param outputs
     *            La {@link Collection} d'elements à mapper.
     * @return inputs La {@link Collection} d'elements mappés.
     */
    public Collection<I> reverse(final Collection<O> outputs) {

        return Lists.newArrayList(FluentIterable.from(outputs).transform(Transformer.this::reverse));
    }

    /**
     * Récupérer une instance d'un Transformer à partir d'un BeanMapper
     * 
     * @param beanMapper
     *            Le beanMapper
     * @return Le Transformer correspondant au beanMapper
     */
    public static <I, O> Transformer<I, O> with(final Mapper<I, O> beanMapper) {

        LOGGER.info("Création du Transformer à partir du beanMapper %s", beanMapper);
        return new Transformer<I, O>(beanMapper);
    }

}
