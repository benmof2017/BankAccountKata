package com.baz.service;

import java.util.Date;
import java.util.List;

import com.baz.dao.IOperationRepository;
import com.baz.entities.Operation;
import com.baz.entities.Withdrawal;
import com.baz.entities.DepositTransfer;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BankServiceImpl implements IBankService{

	@Autowired
	private IOperationRepository operationRepository;

	private static Logger logger = Logger.getLogger(BankServiceImpl.class);
	

	@Override
	public void deposit(double amount) {
		DepositTransfer v = new DepositTransfer(new Date(), amount);
		operationRepository.save(v);
	}

	@Override
	public void withdrawal(double amount) {
		Withdrawal r = new Withdrawal(new Date(), amount);
		operationRepository.save(r);
		
	}

	@Override
	public List<Operation> listOperation() {
		
		return operationRepository.listOperation();
	}

	@Override
	public void deleteOperations() {
	
		operationRepository.deleteOperation();
	}

}