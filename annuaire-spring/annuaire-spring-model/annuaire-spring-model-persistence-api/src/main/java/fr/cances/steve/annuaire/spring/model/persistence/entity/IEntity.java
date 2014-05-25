/**
 * 
 */
package fr.cances.steve.annuaire.spring.model.persistence.entity;

/**
 * @author Steve Cancès
 * @version 1.0.0
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

}
