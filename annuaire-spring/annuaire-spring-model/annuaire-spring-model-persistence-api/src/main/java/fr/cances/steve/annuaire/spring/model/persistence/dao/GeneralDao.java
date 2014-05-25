package fr.cances.steve.annuaire.spring.model.persistence.dao;

import java.util.Collection;
import java.util.Map;

import fr.cances.steve.annuaire.spring.model.persistence.entity.IEntity;

/**
 * DAO proposant des méthodes utilisables sur l'ensemble des {@link IEntity}.
 * 
 * @author Steve Cancès
 * @version 1.0
 */
public interface GeneralDao {

    /**
     * Retourne l'ensemble des enregistrements qui contiennent les valeurs
     * recherchées
     * 
     * @param entityClass
     *            La classe de l'enity concernée
     * @param columnNamesValues
     *            La map de valeurs associées aux champs. Les clés sont les noms
     *            des champs, les valeurs sont les valeurs recherchées pour
     *            chaque champs
     * @return l'ensemble des enregistrements qui contiennent les valeurs
     *         recherchées
     */
    public <T extends IEntity<?>> Collection<T> findAllByFields(
            Class<T> entityClass,
            Map<String, Object> columnNamesValues
            );
}
