package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor 
@Entity
@Table(name="service")
public class Service implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length=30)
	private String nom;
	@ManyToOne
	@JoinColumn(name="id_chef")
	private ChefService chefService;
	@ManyToOne
	@JoinColumn(name="id_directeur")
	private Directeur directeur;
	@OneToMany(mappedBy="servicee",fetch=FetchType.LAZY)
	private Collection<ChefProjet> chefProjet;
	@OneToMany(mappedBy="service",fetch=FetchType.LAZY)
	private Collection<Demande> demandes;
	@OneToMany(mappedBy="service1",fetch=FetchType.LAZY)
	private Collection<Projet> projets;
	@OneToMany(mappedBy="serviice",fetch=FetchType.LAZY)
	private Collection<Membre> membre;
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
	public ChefService getChefService() {
		return chefService;
	}
	public void setChefService(ChefService chefService) {
		this.chefService = chefService;
	}
	public Directeur getDirecteur() {
		return directeur;
	}
	public void setDirecteur(Directeur directeur) {
		this.directeur = directeur;
	}
	public Collection<ChefProjet> getChefProjet() {
		return chefProjet;
	}
	public void setChefProjet(Collection<ChefProjet> chefProjet) {
		this.chefProjet = chefProjet;
	}
	public Collection<Demande> getDemandes() {
		return demandes;
	}
	public void setDemandes(Collection<Demande> demandes) {
		this.demandes = demandes;
	}
	public Collection<Projet> getProjets() {
		return projets;
	}
	public void setProjets(Collection<Projet> projets) {
		this.projets = projets;
	}
	public Collection<Membre> getMembre() {
		return membre;
	}
	public void setMembre(Collection<Membre> membre) {
		this.membre = membre;
	}
	public Service(String nom, ChefService chefService, Directeur directeur, Collection<ChefProjet> chefProjet,
			Collection<Demande> demandes, Collection<Projet> projets, Collection<Membre> membre) {
		super();
		this.nom = nom;
		this.chefService = chefService;
		this.directeur = directeur;
		this.chefProjet = chefProjet;
		this.demandes = demandes;
		this.projets = projets;
		this.membre = membre;
	}
	public Service() {
		super();
	}

}
