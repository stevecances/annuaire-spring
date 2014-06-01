/**
 *
 */
package fr.cances.steve.annuaire.spring.support.mapper;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;
import java.util.Collection;

/**
 * @author Steve Cancès
 * @version 1.0.0
 * @param <I>
 *            Input class.
 * @param <O>
 *            Output class.
 * @since 1.0.0
 */
public abstract class AbstractMapper<I, O> implements Mapper<I, O> {

    @Override
    public abstract O transform(final I input);

    @Override
    public abstract I reverse(final O output);

    public Collection<O> transform(final Collection<I> inputs) {

        return Lists.newArrayList(FluentIterable.from(inputs).transform(AbstractMapper.this::transform));

    }

    public Collection<I> reverse(final Collection<O> outputs) {

        return Lists.newArrayList(FluentIterable.from(outputs).transform(AbstractMapper.this::reverse));
    }
}
