package com.baz.dao;

import com.baz.entities.Operation;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IOperationRepository extends JpaRepository<Operation, Long>{
	
	@Query("select o from Operation o where o.compte.codeCompte =:x order by o.dateOperation desc")
	public List<Operation> listOperation(@Param("x")String codeCpte);
	
	@Modifying
	@Query("delete from Operation o where o.compte.codeCompte = :x ")
	public void deleteOperationByCompte(@Param("x")String codeCpte);
	
}