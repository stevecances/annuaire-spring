package fr.cances.steve.annuaire.spring.model.service.api;

import java.util.Collection;

import fr.cances.steve.annuaire.spring.model.service.api.exception.BeanValidationException;
import fr.cances.steve.annuaire.spring.model.service.api.exception.ResourceNotFoundException;
import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.AbstractVo;

/**
 * Definiftion d'un service avec les CRUD.
 * 
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 * @param <V>
 *            La classe du vo géré pas le service.
 */
public interface IService<V extends AbstractVo<P>, P> {

    /**
     * Retourne l'ensemble des elements.
     * 
     * @author Steve Cancès
     * @since 1.0.0
     * @return L'ensemble des elements.
     * @throws UnsupportedOperationException
     *             Si l'opération n'est pas supportée par l'implementation.
     */
    public Collection<V> findAll() throws UnsupportedOperationException;

    /**
     * Retourne l'element recherché et {@code null} si non trouvé.
     * 
     * @author Steve Cancès
     * @since 1.0.0
     * @param id
     *            L'identifiant de l'element à recherché.
     * @return L'element recherché et {@code null} si non trouvé.
     * @throws UnsupportedOperationException
     *             Si l'opération n'est pas supportée par l'implementation.
     * @throws ResourceNotFoundException
     *             Si l'element n'est pas trouvé.
     */
    public V find(P id) throws UnsupportedOperationException, ResourceNotFoundException;

    /**
     * Créer un element.
     * 
     * @author Steve Cancès
     * @since 1.0.0
     * @param vo
     *            L'element à créer.
     * @return L'élement créé.
     * @throws UnsupportedOperationException
     *             Si l'opération n'est pas supportée par l'implementation.
     * @throws BeanValidationException
     *             Si la validation de l'element a échouée.
     */
    public V create(V vo) throws UnsupportedOperationException, BeanValidationException;

    /**
     * Editer un element.
     * 
     * @author Steve Cancès
     * @since 1.0.0
     * @param vo
     *            L'element à editer.
     * @return L'element edité.
     * @throws UnsupportedOperationException
     *             Si l'opération n'est pas supportée par l'implementation.
     * @throws ResourceNotFoundException
     *             Si l'element n'est pas trouvé.
     * @throws BeanValidationException
     *             Si la validation de l'element a échouée.
     */
    public V edit(V vo) throws UnsupportedOperationException, ResourceNotFoundException, BeanValidationException;

    /**
     * @author Steve Cancès
     * @since 1.0.0
     * @param id
     *            L'identifiant de l'elment à supprimer.
     * @throws UnsupportedOperationException
     *             Si l'opération n'est pas supportée par l'implementation.
     */
    public void delete(P id) throws UnsupportedOperationException;
}
