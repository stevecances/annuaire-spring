package fr.cances.steve.annuaire.spring.model.service.api.valueobjects;

import java.util.Collection;

public class PersonneVo {

    protected Long id;

    protected String nom;

    protected String prenom;

    protected Collection<TelephoneVo> telephones;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(final String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(final String prenom) {
        this.prenom = prenom;
    }

    public Collection<TelephoneVo> getTelephones() {
        return telephones;
    }

    public void setTelephones(final Collection<TelephoneVo> telephones) {
        this.telephones = telephones;
    }
}
