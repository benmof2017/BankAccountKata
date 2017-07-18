package com.baz.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Client implements Serializable{

	@Id @GeneratedValue
	private Long code;
	private String nom;
	private String email;
	private String password;
	
	
	@OneToOne(mappedBy = "client")
	private Compte compte;

	public Client(String nom, String email) {
		super();
		this.nom = nom;
		this.email = email;
	}
	
	public Client(String nom, String email, String password) {
		super();
		this.nom = nom;
		this.email = email;
		this.password = password;
	}

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
	
	
}