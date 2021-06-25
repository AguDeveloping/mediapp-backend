package com.mitocode.repo;

//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import com.mitocode.model.Medico;

//@Repository	// ya lo tiene implementado JpaRepository
public interface IMedicoRepo extends IGenericRepo<Medico, Integer> {

	// al extender de JpaRepository, ya tiene los metodos de CRUD: create...
}
