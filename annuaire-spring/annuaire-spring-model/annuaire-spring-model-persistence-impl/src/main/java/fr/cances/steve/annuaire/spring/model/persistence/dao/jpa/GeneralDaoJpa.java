package fr.cances.steve.annuaire.spring.model.persistence.dao.jpa;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

import fr.cances.steve.annuaire.spring.model.persistence.dao.GeneralDao;
import fr.cances.steve.annuaire.spring.model.persistence.entity.IEntity;

/**
 * DAO utilisant JPA et proposant des méthodes utilisables sur l'ensemble des
 * {@link IEntity}.
 * 
 * @author Steve Cancès
 * @version 1.0
 */
@Qualifier("GeneralDaoJpa")
@Repository
@Transactional(readOnly = true)
public class GeneralDaoJpa implements GeneralDao {

    /**
     * L'Entity Manager qui gère la base de données
     */
    @PersistenceContext(name = "entityManagerFactory")
    protected EntityManager entityManager;

    private final Splitter splitter = Splitter.on('.').trimResults().omitEmptyStrings();

    @Override
    public <T extends IEntity<?>> Collection<T> findAllByFields(
            final Class<T> entityClass,
            final Map<String, Object> columnNamesValues) {

        final CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        final CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(entityClass);
        final Root<T> root = criteriaQuery.from(entityClass);

        final List<Predicate> predicates = Lists.newArrayList();

        // pour tous les champs
        columnNamesValues.entrySet().stream().map((filedPathValue) -> {
            final Object fieldValue = filedPathValue.getValue();
            Path<T> fieldPath = null;
            // construction du chemin vers la proprieté
            for (final String propertyName : this.splitter.split(filedPathValue.getKey())) {
                if (fieldPath == null) {
                    fieldPath = root.get(propertyName);
                } else {
                    fieldPath = fieldPath.get(propertyName);
                }
            }
            final Predicate predicate = criteriaBuilder.equal(
                    fieldPath,
                    fieldValue
            );
            return predicate;
        }).forEach((predicate) -> {
            predicates.add(predicate);
        });

        criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));

        final TypedQuery<T> typedQuery = this.entityManager.createQuery(criteriaQuery);

        return typedQuery.getResultList();
    }
}
