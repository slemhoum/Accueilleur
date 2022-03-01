package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor 
@Entity
@Table(name="demande")
public class Demande implements Serializable {

	public Demande() {
		super();
	}
	public Demande(String description, String delais, String status, Date date_creation, Service service, Client client,
			Accueilleur accueil) {
		super();
		this.description = description;
		this.delais = delais;
		this.status = status;
		this.date_creation = date_creation;
		this.service = service;
		this.client = client;
		this.accueil = accueil;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDate_creation() {
		return date_creation;
	}
	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Accueilleur getAccueil() {
		return accueil;
	}
	public void setAccueil(Accueilleur accueil) {
		this.accueil = accueil;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="description",length=70)
	private String description;
	@Column(length=30)
	private String delais;
	@Column(length=30)
	private String status;
	private Date date_creation;
	@ManyToOne
	@JoinColumn(name="id_service")
	private Service service;
	
	
	@ManyToOne
	@JoinColumn(name="id_client")
	private Client client;
	@ManyToOne
	@JoinColumn(name="id_accueil")
	private Accueilleur accueil;
}
