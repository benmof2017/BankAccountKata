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

//	private static Logger logger = Logger.getLogger(BankAccountKataApplicationTests.class);
//	
//	@Autowired
//	private IClientService clientService;
//	@Autowired
//	private IBankService bankService;
//
//	private String email = "test@email.com";
//	private String password = "mdp";
//	private static Client client;
//
//	@Before
//	public void initTests() {
//		client = new Client("clientTest", email, password);
//
//	}
//
//	@Test
//	public void testCreateClient() {
//
//		// Creation client
//		client = clientService.create(client);
//		assertNotNull("test creation client doesn't work", client);
//		boolean status = clientService.delete(client.getCode());
//		assertTrue("test delete client doesn't work !!!", status);
//	}
//
//	@Test
//	public void testConnectClientByEmailPassword() {
//
//		client = clientService.create(client);
//		// Connection to the client with his email and his password
//		Client client2 = clientService.connectLogin(client);
//		assertNotNull("Connection client with email and password doesn't work !!!", client2);
//		boolean status = clientService.delete(client2.getCode());
//		assertTrue("test delete client doesn't work !!!", status);
//	}
//
//	@Test
//	public void testConnectClientById() {
//		client = clientService.create(client);
//		// connect client by his id
//		Client client3 = clientService.selectById(client.getCode());
//		assertNotNull("Selection client By id doesn't work !!!", client3);
//		boolean status = clientService.delete(client3.getCode());
//		assertTrue("test delete client doesn't work !!!", status);
//	}
//
//	@Test
//	public void testFindClientByEmail() {
//		client = clientService.create(client);
//		// find a client by his email
//		Client client4 = clientService.findByEmail(client);
//		assertNotNull("Selection client his email doesn't work !!!", client4);
//		boolean status = clientService.delete(client4.getCode());
//		assertTrue("test delete client doesn't work !!!", status);
//	}
//
//	
//	@Test
//	public void testConsultAccount() {
//		// find an account par son id
//		
//		//creation of the client
//		client = clientService.create(client);
//		String codeAccount = client.getAccount().getCodeAccount();
//		
//		Account account = bankService.consultAccount(codeAccount);
//		assertNotNull("Find account doesn't work !!!", account);
//		boolean status = clientService.delete(client.getCode());
//		assertTrue("test delete client doesn't work !!!", status);
//	}
//		
//	@Test
//	public void testDeposit() {
//		//creation of the client
//		client = clientService.create(client);
//		Account account = bankService.consultAccount(client.getAccount().getCodeAccount());
//		//deposit
//		double amount = account.getAmount();
//		bankService.deposit(account.getCodeAccount(), 2000);
//	 	Account account2 = bankService.consultAccount(client.getAccount().getCodeAccount());
//	 	logger.debug("nouveau solde : " + account2.getAmount());
//	 	assertEquals(amount + 2000, account2.getAmount(),0);
//	 	boolean status = clientService.delete(client.getCode());
//		assertTrue("test delete client doesn't work !!!", status);
//	}
//	 	
//	@Test
//	public void testWithdrawal() {
//		//creation of the client
//		client = clientService.create(client);
//		Account account2 = bankService.consultAccount(client.getAccount().getCodeAccount());
//	 	//withdrawal
//		double amount = account2.getAmount();
//		bankService.withdrawal(account2.getCodeAccount(), 500);
//	 	Account account3 = bankService.consultAccount(client.getAccount().getCodeAccount());
//	 	assertEquals(amount - 500, account3.getAmount(),0);
//	 	boolean status = clientService.delete(client.getCode());
//	 	assertTrue("test delete client doesn't work !!!", status);
//	}
//	 	
//	 	
//	 	
//	 	@Test
//		public void testListOperation() {
//			//creation of the client
//			client = clientService.create(client);
//			Account account = bankService.consultAccount(client.getAccount().getCodeAccount());
//			double amount = account.getAmount();
//			bankService.deposit(account.getCodeAccount(), 5000);
//			bankService.withdrawal(account.getCodeAccount(), 500);
//			bankService.withdrawal(account.getCodeAccount(), 500);
//			Account account2 = bankService.consultAccount(client.getAccount().getCodeAccount());
//			assertEquals(amount + 5000 - 500 - 500,account2.getAmount(),0);
//			List<Operation> list = bankService.listOperation(account.getCodeAccount());
//			assertEquals(3, list.size());
//			//delete client
//		 	clientService.delete(client.getCode());
//	 	
//		
//	}
	



}
