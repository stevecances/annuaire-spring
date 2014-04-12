package fr.cances.steve.annuaire.spring.model.persistence.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Personne {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String nom;
	
	@Column(nullable = false)
	private String prenom;
	
	@OneToMany(mappedBy = "personne", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private Collection<Telephone> telephones;
	
	public Personne() {
		this.telephones = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Collection<Telephone> getTelephones() {
		return telephones;
	}

	public void setTelephones(Collection<Telephone> telephones) {
		this.telephones = telephones;
	}
}
