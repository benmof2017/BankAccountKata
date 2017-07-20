package com.baz.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("W")
public class Withdrawal extends Operation{

	public Withdrawal(Date dateOperation, double amount) {
		super(dateOperation, amount);
		
	}

	public Withdrawal() {
		super();
		
	}

	
	
}