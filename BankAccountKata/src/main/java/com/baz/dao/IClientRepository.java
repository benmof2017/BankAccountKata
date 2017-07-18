package com.baz.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.baz.entities.Client;



public interface IClientRepository extends JpaRepository<Client, Long>{
	
	@Query("select c from Client c where c.email =:x and c.password = :y")
	public List<Client> connectClientLogin(@Param("x") String email,@Param("y") String password);
	
	@Query("select c from Client c where c.email =:x")
	public List<Client> clientExiste(@Param("x") String email);

}
