package com.baz.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_OP",discriminatorType=DiscriminatorType.STRING,length=1)
public abstract class Operation implements Serializable{
@Id @GeneratedValue
private Long numero;
private Date dateOperation;
private double amount;
@Column(name = "type_op", insertable = false, updatable=false )
private String type_op;


public Operation() {
	super();
	
}


public Operation(Date dateOperation, double amount) {
	super();
	
	this.dateOperation = dateOperation;
	this.amount = amount;
}


public Long getNumero() {
	return numero;
}


public void setNumero(Long numero) {
	this.numero = numero;
}


public Date getDateOperation() {
	return dateOperation;
}


public void setDateOperation(Date dateOperation) {
	this.dateOperation = dateOperation;
}


public double getAmount() {
	return amount;
}


public void setAmount(double amount) {
	this.amount = amount;
}


public String getType_op() {
	return type_op;
}


public void setType_op(String type_op) {
	this.type_op = type_op;
}


	
	
	
	
}