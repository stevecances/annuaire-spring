/**
 * 
 */
package fr.cances.steve.annuaire.spring.model.persistence.repositories.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;


/**
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Transactional
public abstract class AbstractRepositoryJpaTest {
	
	@PersistenceContext
	protected EntityManager entityManager;

	protected void truncateSchemaPublic() {
		Query query = this.entityManager.createNativeQuery("TRUNCATE SCHEMA public AND COMMIT");
		query.executeUpdate();
	}
}
