package com.mitocode.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mitocode.model.SignoVital;

public interface ISignoVitalRepo extends IGenericRepo<SignoVital, Integer> {

	@Query("FROM SignoVital sv WHERE sv.paciente.idPaciente = :idPaciente")
	List<SignoVital> buscarPorIdPaciente(@Param("idPaciente") Integer idPaciente);
}
