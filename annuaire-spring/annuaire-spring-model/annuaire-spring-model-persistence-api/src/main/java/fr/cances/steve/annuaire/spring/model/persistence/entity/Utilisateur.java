package fr.cances.steve.annuaire.spring.model.persistence.entity;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * Entity représentant un utilisateur de l'application.
 * 
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
@Entity
public class Utilisateur implements IEntity<Long> {

    /**
     * L'identifiant technique.
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * Le nom d'utilisateur de l'utilisateur.
     */
    @Column(nullable = false, unique = true)
    private String username;

    /**
     * Le mot de passe de l'utilisateur.
     */
    @Column(nullable = false)
    private String password;

    /**
     * La personne correspondante à l'utilisateur.
     */
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    private Personne personne;

    /**
     * Si l'utilisateur est administrateur.
     */
    @Column(nullable = false)
    private boolean admin;

    /**
     * La liste de contacts de l'utilisateur.
     */
    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL, orphanRemoval = true)
    private final Collection<Personne> contacts = new ArrayList<>();

    /**
     * Constructeur par defaut.
     * <p>
     * Par defaut L'{@code Utilisateur} n'est pas administrateur.
     * </p>
     * 
     * @author Steve Cancès
     * @since 1.0.0
     */
    public Utilisateur() {
        this.admin = false;
    }

    /**
     * @return the id
     */
    @Override
    public Long getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    @Override
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     *            the username to set
     */
    public void setUsername(final String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     *            the password to set
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * @return the personne
     */
    public Personne getPersonne() {
        return personne;
    }

    /**
     * @param personne
     *            the personne to set
     */
    public void setPersonne(final Personne personne) {
        this.personne = personne;
    }

    /**
     * @return the admin
     */
    public boolean isAdmin() {
        return admin;
    }

    /**
     * @param admin
     *            the admin to set
     */
    public void setAdmin(final boolean admin) {
        this.admin = admin;
    }

    /**
     * @return the contacts
     */
    public Collection<Personne> getContacts() {
        return contacts;
    }

    /**
     * Builder de {@link Utilisateur}.
     * 
     * @author Steve Cancès
     * @version 1.0.0
     * @since 1.0.0
     */
    public static class Builder {

        /**
         * Le pojo géré par le {@code Builder}
         */
        private final Utilisateur pojo;

        private Builder() {
            this.pojo = new Utilisateur();
        }

        /**
         * Retourne une instance du builder.
         * 
         * @author Steve Cancès
         * @since 1.0.0
         * @return Une instance du builder.
         */
        public static Builder newInstance() {
            return new Builder();
        }

        /**
         * @author Steve Cancès
         * @since 1.0.0
         * @param id
         *            L'id.
         * @return Le {@code Builder} pour chainer les appels.
         */
        public Builder withId(final Long id) {
            this.pojo.id = id;
            return this;
        }

        /**
         * @author Steve Cancès
         * @since 1.0.0
         * @param username
         *            Le username.
         * @return Le {@code Builder} pour chainer les appels.
         */
        public Builder withUsername(final String username) {
            this.pojo.username = username;
            return this;
        }

        /**
         * @author Steve Cancès
         * @since 1.0.0
         * @param password
         *            Le password.
         * @return Le {@code Builder} pour chainer les appels.
         */
        public Builder withPassword(final String password) {
            this.pojo.password = password;
            return this;
        }

        /**
         * @author Steve Cancès
         * @since 1.0.0
         * @param personne
         *            La personne.
         * @return Le {@code Builder} pour chainer les appels.
         */
        public Builder withPersonne(final Personne personne) {
            this.pojo.personne = personne;
            return this;
        }

        /**
         * @author Steve Cancès
         * @since 1.0.0
         * @param admin
         *            Le boolean admin.
         * @return Le {@code Builder} pour chainer les appels.
         */
        public Builder withAdmin(final boolean admin) {
            this.pojo.admin = admin;
            return this;
        }

        /**
         * @author Steve Cancès
         * @param contact
         * @since 1.0.0
         * @return Le {@code Builder} pour chainer les appels.
         */
        public Builder withContact(final Personne contact) {
            this.pojo.contacts.add(contact);
            return this;
        }

        /**
         * Retourne l'objet {@code Utilisateur} construit.
         * 
         * @author Steve Cancès
         * @since 1.0.0
         * @return Retourne l'objet {@code Utilisateur} construit.
         */
        public Utilisateur build() {
            return this.pojo;
        }
    }

}
