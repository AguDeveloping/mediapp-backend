package com.mitocode.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mitocode.model.Consulta;

//@Repository
public interface IConsultaRepo extends IGenericRepo<Consulta, Integer> {

	// Para trabajar compatible la informacion a buscar: LOWER.
	// Angular : jaime
	// BD      : jaime

	@Query("FROM Consulta c WHERE c.paciente.dni = :dni OR LOWER(c.paciente.nombres) LIKE %:nombreCompleto% OR LOWER(c.paciente.apellidos) LIKE %:nombreCompleto%")
	List<Consulta> buscar(@Param("dni") String dni, @Param("nombreCompleto") String nombreCompleto);
	
	// >= 22-05-21 //< 23-05-21
	// SELECT new com.mitocode.model.Consulta(c.paciete, c.medico)
	@Query("FROM Consulta c WHERE c.fecha BETWEEN :fechaConsulta AND :fechaSiguiente")
	List<Consulta> buscarFecha(LocalDateTime fechaConsulta, LocalDateTime fechaSiguiente);
	
	@Query(value = "select * from fn_listarResumen()", nativeQuery = true)
	List<Object[]> listarResumen();
	
	// List<Object[]>
	// cantidad, fecha
	// [1      , "15/05/2021"]
	// [2      , "22/05/2021"]
	// [5      , "24/05/2021"]
	// [x[0]   , x[1]        ]
}
