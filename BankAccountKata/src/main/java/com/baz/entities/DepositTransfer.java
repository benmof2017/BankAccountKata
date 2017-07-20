package com.baz.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("D")
public class DepositTransfer extends Operation{

	public DepositTransfer() {
		super();
		
	}

	public DepositTransfer(Date dateOperation, double amount) {
		super(dateOperation, amount);
		
	}

	
	
}