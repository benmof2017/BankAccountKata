package com.baz.metier;

import java.util.Date;
import java.util.List;

import com.baz.dao.ICompteRepository;
import com.baz.dao.IOperationRepository;
import com.baz.entities.Compte;
import com.baz.entities.Operation;
import com.baz.entities.Retrait;
import com.baz.entities.Versement;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BanqueMetierImpl implements IBanqueMetier{
	@Autowired
	private ICompteRepository compteRepository;
	@Autowired
	private IOperationRepository operationRepository;

	private static Logger logger = Logger.getLogger(BanqueMetierImpl.class);
	
	@Override
	public Compte consulterCompte(String codeCpte) {
		Compte cp = compteRepository.findOne(codeCpte);
		if(cp == null) {
			logger.error("Compte introuvable : " + codeCpte); 
			throw new RuntimeException("Compte introuvable");
		}
		return cp;
	}

	@Override
	public void verser(String codeCpte, double montant) {
		Compte cp = consulterCompte(codeCpte);
		Versement v = new Versement(new Date(), montant, cp);
		operationRepository.save(v);
		cp.setSolde(cp.getSolde() + montant);
		compteRepository.save(cp);
		
	}

	@Override
	public void retirer(String codeCpte, double montant) {
		Compte cp = consulterCompte(codeCpte);
		double facilitesCaisse = cp.getDecouvert();
		if(cp.getSolde() + facilitesCaisse < montant) {
			logger.error("Solde insuffisant : " + montant);
			throw new RuntimeException("Solde insuffisant");
		}
		Retrait r = new Retrait(new Date(), montant, cp);
		operationRepository.save(r);
		cp.setSolde(cp.getSolde() - montant);
		compteRepository.save(cp);
		
	}

	@Override
	public void virement(String codeCpte1, String codeCpte2, double montant) {
		if(codeCpte1.equals(codeCpte2)){
			logger.error("Impossibile de faire un virement sur le même compte");
			throw new RuntimeException("Impossibile de faire un virement sur le même compte");
		}
		retirer(codeCpte1,montant);
		verser(codeCpte2, montant);
		
	}

	@Override
	public List<Operation> listOperation(String codeCpte) {
		
		return operationRepository.listOperation(codeCpte);
	}

	@Override
	public void deleteOperationByCompte(String codeCpte) {
	
		operationRepository.deleteOperationByCompte(codeCpte);
	}

}