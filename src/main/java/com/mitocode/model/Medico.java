package com.mitocode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medico")
public class Medico {

	// JPQL Java Persistence Query Language
	// JPQL -> FROM Medico m WHERE m.idMedico = 1 // apunta a la clases en Codigo.
	// SQL -> SELECT * FROM MEDICO m WHERE m.id_medico = 1 // apunta a las tablas

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMedico;

	@Column(name = "nombres", nullable = false, length = 70)
	private String nombres;

	@Column(name = "apellidos", nullable = false, length = 70)
	private String apellidos;

	@Column(name = "CMP", nullable = false, length = 12, unique = true)
	private String CMP;

	@Column(name = "foto_url", nullable = true)
	private String fotoUrl;

	public Integer getIdMedico() {
		return this.idMedico;
	}

	public void setIdMedico(Integer idMedico) {
		this.idMedico = idMedico;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCMP() {
		return this.CMP;
	}

	public void setCMP(String cmp) {
		this.CMP = cmp;
	}

	public String getFotoUrl() {
		return this.fotoUrl;
	}

	public void setFotoUrl(String fotoUrl) {
		this.fotoUrl = fotoUrl;
	}

}
