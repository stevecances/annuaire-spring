package fr.cances.steve.annuaire.spring.model.persistence.repositories.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.transaction.annotation.Transactional;

import fr.cances.steve.annuaire.spring.model.persistence.repositories.AbstractRepository;

/**
 *
 * @author Steve Cancès <steve.cances@gmail.com>
 * @param <E> L'entity géré par la dao
 */
@Transactional
public abstract class AbstractRepositoryJpa<E, I> implements AbstractRepository<E, I> {

	/**
	 * Entity Manager used to talk with the database
	 */
	@PersistenceContext
	protected EntityManager entityManager;

	private final Class<E> domainClass;

	public AbstractRepositoryJpa(Class<E> entityClass) {
		this.domainClass = entityClass;
	}

	@Override
	public E create(E entity) {
		this.entityManager.persist(entity);
		return entity;
	}

	@Override
	public E edit(E entity) {
		this.entityManager.merge(entity);
		return entity;
	}

	@Override
	public void remove(E entity) {
		this.entityManager.remove(entityManager.merge(entity));
	}

	@Override
	@Transactional(readOnly = true)
	public E find(I id) {
		return entityManager.find(domainClass, id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<E> findAll() {
		CriteriaQuery<E> criteria = entityManager.getCriteriaBuilder().createQuery(domainClass);
		criteria.select(criteria.from(domainClass));
		return entityManager.createQuery(criteria).getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public List<E> findRange(int[] range) {
		CriteriaQuery<E> cq = entityManager.getCriteriaBuilder().createQuery(domainClass);
		cq.select(cq.from(domainClass));
		javax.persistence.Query q = entityManager.createQuery(cq);
		q.setMaxResults(range[1] - range[0]);
		q.setFirstResult(range[0]);
		return q.getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public int count() {
		CriteriaBuilder b = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = b.createQuery(Long.class);
		criteria.select(b.count(criteria.from(domainClass)));

		return entityManager.createQuery(criteria).getSingleResult().intValue();
	}

}