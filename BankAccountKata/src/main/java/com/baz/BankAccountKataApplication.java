package com.baz;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.baz.entities.Client;
import com.baz.entities.Compte;
import com.baz.metier.IBanqueMetier;
import com.baz.metier.IClientService;

@SpringBootApplication
public class BankAccountKataApplication implements CommandLineRunner{

	private static Logger logger = Logger.getLogger(BankAccountKataApplication.class);
	
	@Autowired
	private IClientService clientService;
	@Autowired
	private IBanqueMetier metier;
	
	public static void main(String[] args) {
		SpringApplication.run(BankAccountKataApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {

		Client client = new Client("Jean Moulin ", "jmoulin@email.com" , "mdp");
		Client existClient = clientService.findByEmail(client);
		//si le client test n'existe pas, on le crée
		if(existClient == null) {
			client = clientService.create(client);
			String codeCompte = client.getCompte().getCodeCompte();
			Compte compte = metier.consulterCompte(codeCompte);
			//versement de 2000 € dans le compte
			metier.verser(compte.getCodeCompte(), 2000);
			//retrait de 500€ dans le compte
			metier.retirer(compte.getCodeCompte(), 500);
		}
		
	}
}
