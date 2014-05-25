package fr.cances.steve.annuaire.spring.model.persistence.dao;

import java.util.Collection;
import java.util.List;

import fr.cances.steve.annuaire.spring.model.persistence.entity.IEntity;

/**
 * Definition d'un repository (dao).
 * <p>
 * Un repository proposant les opérations CRUD de base.
 * </p>
 * 
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 * @param <E>
 *            La classe de l'entity à persister.
 * @param <P>
 *            La classe de l'identifiant technique de l'entity à persister.
 */
public interface IDao<E extends IEntity<P>, P> {

    /**
     * Persister une entity en base.
     * 
     * @author Steve Cancès
     * @since 1.0.0
     * @param entity
     *            L'entity à persister.
     * @return L'entity persistée.
     */
    public abstract E create(E entity);

    /**
     * Editer une entity en base.
     * <p>
     * Retourne null si l'entity n'est pas trouvée.
     * </p>
     * 
     * @author Steve Cancès
     * @since 1.0.0
     * @param entity
     *            L'entity à éditer.
     * @return L'entity éditée.
     */
    public abstract E edit(E entity);

    /**
     * Supprimer une entity de la base.
     * 
     * @author Steve Cancès
     * @since 1.0.0
     * @param entity
     *            L'entity à supprimer.
     */
    public abstract void remove(E entity);

    /**
     * Supprime l'enregistrement correspondant à l'entity.
     * 
     * @author Steve Cancès
     * @since 1.0.0
     * @param id
     *            L'identifiant de l'entity à supprimer.
     */
    public abstract void removeById(P id);

    /**
     * Récupéré une entity de la base.
     * <p>
     * Retourne null si l'entity n'est pas trouvée.
     * </p>
     * 
     * @author Steve Cancès
     * @since 1.0.0
     * @param id
     *            L'identifiant de l'entity à récupérer.
     * @return L'entity récupérée.
     */
    public abstract E find(P id);

    /**
     * Retourne l'ensemble des entity de la table concernée.
     * 
     * @author Steve Cancès
     * @since 1.0.0
     * @return L'ensemble des enregistrements de la table concernée.
     */
    public abstract Collection<E> findAll();

    /**
     * Retourne l'ensemble des entity de la table concernée correspondant au
     * range choisi.
     * 
     * @author Steve Cancès
     * @since 1.0.0
     * @param range
     *            Le range.
     * @return L'ensemble des entity de la table concernée correspondant au
     *         range choisi.
     */
    public abstract List<E> findRange(int[] range);

    /**
     * Retourne le nombre d'enregistrement present dans la table concernée.
     * 
     * @author Steve Cancès
     * @since 1.0.0
     * @return Le nombre d'enregistrement present dans la table concernée.
     */
    public abstract int count();

}