/**
 * 
 */
package fr.cances.steve.annuaire.spring.support.mapper;

import java.util.Collection;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;

/**
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class AbstractMapper<I, O> {

    public abstract O transform(final I input);

    public abstract I reverse(final O output);

    public Collection<O> transform(final Collection<I> inputs) {

        return Collections2.transform(inputs, new Function<I, O>() {

            @Override
            public O apply(final I input) {
                return AbstractMapper.this.transform(input);
            }

        });

    }

    public Collection<I> reverse(final Collection<O> outputs) {

        return Collections2.transform(outputs, new Function<O, I>() {

            @Override
            public I apply(final O output) {
                return AbstractMapper.this.reverse(output);
            }

        });
    }
}
