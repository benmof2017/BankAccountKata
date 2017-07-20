package com.baz.rest;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baz.entities.Operation;
import com.baz.entities.Withdrawal;
import com.baz.service.IBankService;
import com.baz.entities.DepositTransfer;

@CrossOrigin(origins = "*") 
@RestController
@RequestMapping(value = "/services")
public class ServiceBankRest {

	@Autowired
	private IBankService bankService;
	private static Logger logger = Logger.getLogger(ServiceBankRest.class);
	
	
	
	
	// http://localhost:8080/services/deposit
	@RequestMapping(value = "/deposit", method = RequestMethod.PUT)
	public ResponseEntity<Boolean> deposit(@RequestBody DepositTransfer operation) {
		try {
			double amount = operation.getAmount();
			bankService.deposit(amount);
		} catch (Exception e) {
			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	
	
	// http://localhost:8080/services/withdrawal
	@RequestMapping(value = "/withdrawal", method = RequestMethod.PUT)
	public ResponseEntity<Boolean> withdrawal(@RequestBody Withdrawal operation) {
		try {
			double amount = operation.getAmount();
			bankService.withdrawal(amount);
		} catch (Exception e) {
			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/operations", method = RequestMethod.GET)
	public ResponseEntity<List<Operation>> listOperation(){
		
		List<Operation> operations=null;
		try {
			operations = bankService.listOperation();
		} catch (Exception e) {
			return new ResponseEntity<List<Operation>>(operations, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Operation>>(operations, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/operations", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteAllOperation(){
		
		try {
			bankService.deleteOperations();
		} catch (Exception e) {
			return new ResponseEntity<Boolean>(true, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Boolean>(false, HttpStatus.OK);
		
	}
	
	
	
}
