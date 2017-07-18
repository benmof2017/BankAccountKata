package com.baz.rest;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baz.entities.Compte;
import com.baz.entities.Operation;
import com.baz.entities.Retrait;
import com.baz.entities.Versement;
import com.baz.metier.IBanqueMetier;

@CrossOrigin(origins = "*") // ou bien autorisations plus fines
@RestController
@RequestMapping(value = "/services")
public class ServiceBanqueRest {

	@Autowired
	private IBanqueMetier metier;
	private static Logger logger = Logger.getLogger(ServiceBanqueRest.class);
	
	/**
	 * Permet de retourner un omptent precis par son id
	 * 
	 * @param codeCpte, l'id du compte
	 * @return ResponseEntity<Compte>
	 */
	@RequestMapping(value = "/compte/{codeCpte}", method = RequestMethod.GET)
	public ResponseEntity<Compte> consulterCompte(@PathVariable("codeCpte")String codeCpte) {
		Compte compte=null;
		try {
			compte = metier.consulterCompte(codeCpte);
		} catch (Exception e) {
			return new ResponseEntity<Compte>(compte, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Compte>(compte, HttpStatus.OK);
	}
	
	
	
	// http://localhost:8080/services/deposit
	@RequestMapping(value = "/deposit", method = RequestMethod.PUT)
	public ResponseEntity<Boolean> verser(@RequestBody Versement operation) {
		try {
			String codeCpte = operation.getCompte().getCodeCompte();
			double montant = operation.getMontant();
			metier.verser(codeCpte, montant);
		} catch (Exception e) {
			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	
	
	// http://localhost:8080/services/withdrawal
	@RequestMapping(value = "/withdrawal", method = RequestMethod.PUT)
	public ResponseEntity<Boolean> retirer(@RequestBody Retrait operation) {
		try {
			String codeCpte = operation.getCompte().getCodeCompte();
			double montant = operation.getMontant();
			metier.retirer(codeCpte, montant);
		} catch (Exception e) {
			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	
	
	/**
	 * implementer pour une futur version
	 * @param codeCpte1, l'id du compte qui envoie l'argent
	 * @param codeCpte2, l'id du compte qui recois l'argent
	 * @param montant
	 * @return true si tout est OK, false sinon
	 */
	// http://localhost:8080/services/transfer?codeCpte1=012345&codeCpte2=987654&montant=500
	@RequestMapping(value = "/transfer", method = RequestMethod.PUT)
	public ResponseEntity<Boolean> virement(@RequestParam String codeCpte1, String codeCpte2, double montant) {
		
		try {
			metier.virement(codeCpte1, codeCpte2, montant);
		} catch (Exception e) {
			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	
	//à faire
	public Page<Operation> listOperation(String codeCpte, int page, int size){
		return null;
	}
	
	@RequestMapping(value = "/operations/{codeCpte}", method = RequestMethod.GET)
	public ResponseEntity<List<Operation>> listOperation(@PathVariable String codeCpte){
		
		List<Operation> operations=null;
		try {
			operations = metier.listOperation(codeCpte);
		} catch (Exception e) {
			return new ResponseEntity<List<Operation>>(operations, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Operation>>(operations, HttpStatus.OK);
		
	}
	
	
	
}
