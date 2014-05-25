package fr.cances.steve.annuaire.spring.model.persistence.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.transaction.annotation.Transactional;

import fr.cances.steve.annuaire.spring.model.persistence.dao.IDao;
import fr.cances.steve.annuaire.spring.model.persistence.entity.IEntity;

/**
 * Repository JPA générique abstrait.
 * 
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 * @param <E>
 *            L'entity géré par le dao.
 * @param <P>
 *            L'identifiant de l'entity géré par le dao.
 */
@Transactional
public abstract class AbstractDaoJpa<E extends IEntity<P>, P> implements IDao<E, P> {

    /** L'Entity Manager qui gère la base de données. */
    @PersistenceContext
    protected EntityManager entityManager;

    /** La classe de l'entity gérée par le dao. */
    protected final Class<E> domainClass;

    /**
     * Constructeur par defaut.
     * 
     * @author Steve Cancès
     * @since 1.0.0
     * @param entityClass
     */
    public AbstractDaoJpa(final Class<E> entityClass) {
        this.domainClass = entityClass;
    }

    @Override
    public E create(final E entity) {
        this.entityManager.persist(entity);
        return entity;
    }

    @Override
    public E edit(final E entity) {
        this.entityManager.merge(entity);
        return entity;
    }

    @Override
    public void remove(final E entity) {
        this.entityManager.remove(this.entityManager.merge(entity));
    }

    @Override
    public void removeById(final P id) {

        this.remove(this.find(id));
    }

    @Override
    @Transactional(readOnly = true)
    public E find(final P id) {
        return this.entityManager.find(this.domainClass, id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<E> findAll() {
        CriteriaQuery<E> criteria = this.entityManager.getCriteriaBuilder().createQuery(this.domainClass);
        criteria.select(criteria.from(this.domainClass));
        return this.entityManager.createQuery(criteria).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<E> findRange(final int[] range) {
        CriteriaQuery<E> criteriaQuery = this.entityManager.getCriteriaBuilder().createQuery(this.domainClass);
        criteriaQuery.select(criteriaQuery.from(domainClass));
        TypedQuery<E> query = this.entityManager.createQuery(criteriaQuery);
        query.setMaxResults(range[1] - range[0]);
        query.setFirstResult(range[0]);
        return query.getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public int count() {
        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = criteriaBuilder.createQuery(Long.class);
        criteria.select(criteriaBuilder.count(criteria.from(this.domainClass)));
        return this.entityManager.createQuery(criteria).getSingleResult().intValue();
    }

}