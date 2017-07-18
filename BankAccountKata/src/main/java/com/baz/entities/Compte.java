package com.baz.entities;


import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Compte implements Serializable{

	@Id
	private String codeCompte;
	private Date dateCreation;
	private double solde;
	private double decouvert;
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CODE_CLI")
	private Client client;
	
	@JsonIgnore
	@OneToMany(mappedBy="compte")
	private List<Operation> operations;

	public Compte(String codeCompte, Date dateCreation, double solde, double decouvert, Client client) {
		super();
		this.codeCompte = codeCompte;
		this.dateCreation = dateCreation;
		this.solde = solde;
		this.decouvert = decouvert;
		this.client = client;
	}

	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCodeCompte() {
		return codeCompte;
	}

	public void setCodeCompte(String codeCompte) {
		this.codeCompte = codeCompte;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}
	
	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}



	
	
}
