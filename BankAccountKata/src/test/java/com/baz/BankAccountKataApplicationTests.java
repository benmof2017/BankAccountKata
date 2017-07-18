package com.baz;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baz.entities.Client;
import com.baz.entities.Compte;
import com.baz.metier.IBanqueMetier;
import com.baz.metier.IClientService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BankAccountKataApplicationTests {

	private static Logger logger = Logger.getLogger(BankAccountKataApplicationTests.class);
	
	@Autowired
	private IClientService clientService;
	@Autowired
	private IBanqueMetier metier;

	private String email = "cl1@email.com";
	private String password = "mdp";
	private static Client client;

	@Before
	public void initTests() {
		client = new Client("clientTest1", email, password);

	}

	@Test
	public void contextLoads() {

	}

	@Test
	public void testClient1() {

		// Creation du client
		client = clientService.create(client);
		assertNotNull("La création du client a échouée", client);
	}

	@Test
	public void testClient2() {

		// Connection au client avec son email et password
		Client client2 = clientService.connect(client);
		assertNotNull("La connection du client avec email et password a échouée", client2);
	}

	@Test
	public void testClient3() {
		// Selection du client par son id
		client = clientService.connect(client);
		Client client3 = clientService.selectById(client.getCode());
		assertNotNull("La selection du client par id a échouée", client3);
	}

	@Test
	public void testClient4() {
		// trouver un client par son email
		Client client4 = clientService.findByEmail(client);
		assertNotNull("La selection du client par son email a échouée", client4);
	}

	@Test
	public void testClient5() {
		// suppression client
		System.out.println("HELLO " + client.getEmail());
		Client client5 = clientService.findByEmail(client);
		System.out.println("HELLO 2 " + client5.getEmail());
		clientService.delete(client5.getCode());
		client5 = clientService.findByEmail(client5);
		assertNull("La suppression du client a échouée", client5);

	}

	
	@Test
	public void testCompte1() {
		// trouver un compte par son id
		
		//creation du client
		client = clientService.create(client);
		System.out.println(client + " " + client.getCompte());
		String codeCompte = client.getCompte().getCodeCompte();
		
		Compte compte = metier.consulterCompte(codeCompte);
		assertNotNull("La consultation du compte a échouée", compte);
		
		//versement
		double solde = compte.getSolde();
		metier.verser(compte.getCodeCompte(), 2000);
	 	Compte compte2 = metier.consulterCompte(codeCompte);
	 	logger.debug("nouveau solde : " + compte2.getSolde());
	 	assertEquals(solde + 2000, compte2.getSolde(),0);
	 	
	 	//retirer
	 	solde = compte2.getSolde();
	 	metier.retirer(compte2.getCodeCompte(), 500);
	 	Compte compte3 = metier.consulterCompte(codeCompte);
	 	assertEquals(solde - 500, compte3.getSolde(),0);
	 	
	 	
	 	//listing Operations
	 	
	 	
	 	//suppression du client
	 	clientService.delete(client.getCode());
		
	}
	//



}
