/**
 * 
 */
package fr.cances.steve.annuaire.spring.model.service.impl.mapping;

import fr.cances.steve.annuaire.spring.support.mapper.AbstractMapper;

/**
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class EntityMapper<E, V> extends AbstractMapper<E, V> {

    public abstract void updateEntityFromVo(E entity, final V vo);
}
