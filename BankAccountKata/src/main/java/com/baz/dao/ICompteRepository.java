package com.baz.dao;

import com.baz.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompteRepository extends JpaRepository<Compte, String>{

}
