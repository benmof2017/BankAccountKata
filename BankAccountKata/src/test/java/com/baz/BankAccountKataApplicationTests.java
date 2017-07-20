package com.baz;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baz.entities.Operation;
import com.baz.service.IBankService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BankAccountKataApplicationTests {

	private static Logger logger = Logger.getLogger(BankAccountKataApplicationTests.class);

	@Autowired
	private IBankService bankService;

	private String email = "test@email.com";
	private String password = "mdp";

	@Before
	public void initTests() {
		//clean Operations
		bankService.deleteOperations();

	}

	@Test
	public void testDeposit() {

		// deposit
		double amount = 200;
		bankService.deposit(amount);
		//select operations
		List<Operation> list = bankService.listOperation();
		assertTrue(list.size() == 1);
		Operation op = list.get(0);
		assertTrue(op.getAmount() == amount);
		assertTrue(op.getType_op().equals("D"));
		

	}

	@Test
	public void testWithdrawal() {
		// withdrawal
		double amount = 100;
		bankService.withdrawal(amount);
		//select operations
		List<Operation> list = bankService.listOperation();
		assertTrue(list.size() == 1);
		Operation op = list.get(0);
		assertTrue(op.getAmount() == amount);
		assertTrue(op.getType_op().equals("W"));

	}

	@Test
	public void testListOperation() {
		
		//add operation
		bankService.deposit(5000);
		bankService.withdrawal(500);
		bankService.withdrawal(500);
		//list all operations
		List<Operation> list = bankService.listOperation();
		assertEquals(3, list.size());

	}

}
