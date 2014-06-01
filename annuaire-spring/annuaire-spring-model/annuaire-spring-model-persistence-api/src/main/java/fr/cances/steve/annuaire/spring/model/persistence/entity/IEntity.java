/**
 *
 */
package fr.cances.steve.annuaire.spring.model.persistence.entity;

import java.util.Date;

/**
 * @author Steve Cancès
 * @version 1.0.0
 * @param <P>
 *            La classe de l'identifiant de l'entity.
 * @since 1.0.0
 */
public interface IEntity<P> {

    /**
     * Permet de récupérer la valeur de l'attribut id.
     * 
     * @return L'attribut id.
     */
    public P getId();

    /**
     * Permet de renseigner la valeur de l'attribut id.
     * 
     * @param id
     *            La valeur de l'attribut id à renseigner.
     */
    public void setId(final P id);

    /**
     * Retourne la date de création de l'enregistrement.
     * 
     * @return La date de création de l'enregistrement.
     */
    public Date getDateCreated();

    /**
     * Retourne la date de dernière edition de l'enregistrement.
     * 
     * @return La date de dernière edition de l'enregistrement.
     */
    public Date getLastModified();

    /**
     * Retourne la version de l'entity.
     * 
     * @return La version de l'entity.
     */
    public Long getVersion();

}
