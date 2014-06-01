package fr.cances.steve.annuaire.spring.model.persistence.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 * @author Steve Cances <steve.cances@gmail.com>
 * @param <P>
 *            La classe de l'identifiant de l'entity.
 */
@MappedSuperclass
public abstract class AbstractEntity<P> implements IEntity<P> {

    /**
     * La version de l'entity.
     */
    @Version
    @Column(nullable = false)
    private Long version;

    /**
     * La date de création de l'enregistrement.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date dateCreated;

    /**
     * La date de dernière édition de l'enregistrement.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date lastModified;

    /**
     * Permet de récupérer la valeur de l'attribut {@link #version}.
     * 
     * @return L'attribut version.
     */
    @Override
    public Long getVersion() {

        return version;
    }

    /**
     * Permet de récupérer la valeur de l'attribut {@link #dateCreated}.
     * 
     * @return L'attribut dateCreated.
     */
    @Override
    public Date getDateCreated() {

        if (this.dateCreated == null) {
            return null;
        }

        return new Date(dateCreated.getTime());
    }

    /**
     * Permet de récupérer la valeur de l'attribut {@link #lastModified}.
     * 
     * @return L'attribut lastModified.
     */
    @Override
    public Date getLastModified() {

        if (this.lastModified == null) {
            return null;
        }

        return new Date(this.lastModified.getTime());
    }

    /**
     * Met à jour les timeStamps de l'entity.
     */
    @PreUpdate
    @PrePersist
    public void updateTimeStamps() {

        this.lastModified = new Date();
        if (this.dateCreated == null) {
            this.dateCreated = new Date();
        }
    }
}
