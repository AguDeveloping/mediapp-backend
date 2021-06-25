package com.mitocode.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mitocode.model.SignoVital;

public interface ISignoVitalService extends ICRUD<SignoVital, Integer> {

	Page<SignoVital> listarPageable(Pageable pageable);
	
	List<SignoVital> buscarPorIdPaciente(Integer idPaciente);
}
