package fr.cances.steve.annuaire.spring.support.mapper;

/**
 * Mapper entre la classe input et la classe output.
 * 
 * @author Steve Cancès
 * @version 1.0
 * @param <I>
 *            La classe input à mapper
 * @param <O>
 *            La classe output à mapper
 */
public interface Mapper<I, O> {

    /**
     * Map l'input en output (L'input n'est pas modifié).
     * 
     * @param input
     *            L'input
     * @return L'output
     */
    O transform(final I input);

    /**
     * Map l'output en input (L'output n'est pas modifié).
     * 
     * @param output
     *            L'output
     * @return L'input
     */
    I reverse(final O output);
}
