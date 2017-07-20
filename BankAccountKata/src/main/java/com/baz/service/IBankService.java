package com.baz.service;

import com.baz.entities.Operation;

import java.util.List;

public interface IBankService {

	public void deposit(double amount);
	public void withdrawal(double amount);
	public List<Operation> listOperation();
	public void deleteOperations();
}