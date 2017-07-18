package com.baz.metier;

import com.baz.entities.Compte;
import com.baz.entities.Operation;

import java.util.List;

import org.springframework.data.domain.Page;

public interface IBanqueMetier {

	public Compte consulterCompte(String codeCpte);
	public void verser(String codeCpte, double montant);
	public void retirer(String codeCpte, double montant);
	public void virement(String codeCpte1, String codeCpte2, double montant);
	public List<Operation> listOperation(String codeCpte);
	public void deleteOperationByCompte(String codeCpte);
}