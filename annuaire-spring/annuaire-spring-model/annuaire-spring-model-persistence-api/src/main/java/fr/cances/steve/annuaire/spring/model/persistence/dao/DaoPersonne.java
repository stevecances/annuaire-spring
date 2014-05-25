package fr.cances.steve.annuaire.spring.model.persistence.dao;

import java.util.Collection;

import fr.cances.steve.annuaire.spring.model.persistence.entity.Personne;

/**
 * Repository gérant l'entity {@link Personne}.
 * 
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
public interface DaoPersonne extends IDao<Personne, Long> {

    /**
     * Retourne l'ensemble des personnes de l'annuaire dont le nom match avec
     * %like% ou le prénom match avec %like%
     * 
     * @author Steve Cancès
     * @since 1.0.0
     * @param like
     *            La chaine like
     * @return l'ensemble des personnes de l'annuaire dont le nom match avec
     *         %like% ou le prénom match avec %like%
     */
    public Collection<Personne> findPersonnesLikePrenomOrNom(String like);
}
