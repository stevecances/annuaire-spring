/**
 * 
 */
package fr.cances.steve.annuaire.spring.model.service.api.valueobjects;

/**
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class AbstractVo<P> {

    /** Identifiant */
    private P id;

    /**
     * @return the id
     */
    public P getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(final P id) {
        this.id = id;
    }

}
