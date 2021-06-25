package com.mitocode.repo;

//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import com.mitocode.model.Paciente;

//@Repository	// ya lo tiene implementado JpaRepository
public interface IPacienteRepo extends IGenericRepo<Paciente, Integer> {
	
	// al extender de JpaRepository, ya tiene los metodos de CRUD: create...
}
