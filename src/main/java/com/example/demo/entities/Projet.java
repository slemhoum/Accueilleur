package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data @NoArgsConstructor @AllArgsConstructor 
@Entity
@Table(name="projet")
public class Projet implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_project;
	@Column(length=70)
	private String description;
	@Column(length=30)
	private String delais;
	private double budgetTotal;
	private double budgetSpecific;
	private Date date_creation;
	private int etat;
	@ManyToOne
	@JoinColumn(name="id_client")
	private Client clientt;
	@ManyToOne
	@JoinColumn(name="id_chefProjet")
	private ChefProjet chefprojet;
	@ManyToOne
	@JoinColumn(name="id_service")
	private Service service1;
	@OneToMany(mappedBy="projet",fetch=FetchType.LAZY)
	private Collection<Phase> phases;
	
	  public Long getId_project() {
		return id_project;
	}

	public void setId_project(Long id_project) {
		this.id_project = id_project;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDelais() {
		return delais;
	}

	public void setDelais(String delais) {
		this.delais = delais;
	}

	public double getBudgetTotal() {
		return budgetTotal;
	}

	public void setBudgetTotal(double budgetTotal) {
		this.budgetTotal = budgetTotal;
	}

	public double getBudgetSpecific() {
		return budgetSpecific;
	}

	public void setBudgetSpecific(double budgetSpecific) {
		this.budgetSpecific = budgetSpecific;
	}

	public Date getDate_creation() {
		return date_creation;
	}

	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

	public Client getClientt() {
		return clientt;
	}

	public void setClientt(Client clientt) {
		this.clientt = clientt;
	}

	public ChefProjet getChefprojet() {
		return chefprojet;
	}

	public void setChefprojet(ChefProjet chefprojet) {
		this.chefprojet = chefprojet;
	}

	public Service getService1() {
		return service1;
	}

	public void setService1(Service service1) {
		this.service1 = service1;
	}

	public Collection<Phase> getPhases() {
		return phases;
	}

	public void setPhases(Collection<Phase> phases) {
		this.phases = phases;
	}

	public Set<Membre> getMembres() {
		return membres;
	}

	public void setMembres(Set<Membre> membres) {
		this.membres = membres;
	}

	@ManyToMany(cascade = { CascadeType.ALL })
	    @JoinTable(
	        name = "membre_projet", 
	        joinColumns = { @JoinColumn(name = "id_project") }, 
	        inverseJoinColumns = { @JoinColumn(name = "membre_id") }
	    )
	    Set<Membre> membres = new HashSet<>();

}
