package com.mitocode.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mitocode.exception.ModeloNotFoundException;
import com.mitocode.model.SignoVital;
import com.mitocode.service.ISignoVitalService;

@RestController
@RequestMapping("/signos-vitales")
public class SignoVitalController {

	@Autowired
	private ISignoVitalService service;
	
	@GetMapping
	public ResponseEntity<List<SignoVital>> listar() throws Exception {
		List<SignoVital> lista = service.listar();
		return new ResponseEntity<List<SignoVital>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<SignoVital> listarPorId(@PathVariable("id") Integer id) throws Exception {
		SignoVital lista = service.listarPorId(id);
		
		if(lista == null) {
			throw new ModeloNotFoundException("ID: " + id + ", NO ENCONTRADO.");
		}
		return new ResponseEntity<SignoVital>(lista, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<SignoVital> registrar(@Valid @RequestBody SignoVital sv) throws Exception {
		SignoVital registro_sv = service.registrar(sv);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(registro_sv.getIdSignoVital())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<SignoVital> modificar(@Valid @RequestBody SignoVital sv) throws Exception {
		SignoVital registro_sv = service.modificar(sv);
		return new ResponseEntity<SignoVital>(registro_sv, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
		SignoVital sv = service.listarPorId(id);
		if(sv == null) {
			throw new ModeloNotFoundException("ID: " + id + ", NO ENCONTRADO.");
		}
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/pageable")
	public ResponseEntity<Page<SignoVital>> listarPageable(Pageable pageable) throws Exception {
		Page<SignoVital> lista = service.listarPageable(pageable);
		return new ResponseEntity<Page<SignoVital>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/buscar-por-id-paciente/{idPaciente}")
	public ResponseEntity<List<SignoVital>> buscarPorIdPaciente(@PathVariable("idPaciente") Integer idPaciente) throws Exception {
		List<SignoVital> obj = service.buscarPorIdPaciente(idPaciente);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + idPaciente);
		}

		return new ResponseEntity<List<SignoVital>>(obj, HttpStatus.OK);
	}

}
	