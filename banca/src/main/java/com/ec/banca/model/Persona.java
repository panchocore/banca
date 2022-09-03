package com.ec.banca.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity(name = "persona")
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="per_id")
	private int per_id;
	
	@Column(name="per_nombre", length = 100)
	private String per_nombre;
	
	@Column(name="per_genero", length = 15)
	private String per_genero;
	
	@Column(name="per_edad", length = 3)
	private int per_edad;
	
	@Column(name="per_identificacion", length = 10)
	private String per_identificacion;
	
	@Column(name="per_direccion")
	private String per_direccion;
	
	@Column(name="per_telefono", length = 30)
	private String per_telefono;

	
	//getters & setters
	public int getPer_id() {
		return per_id;
	}

	public void setPer_id(int per_id) {
		this.per_id = per_id;
	}

	public String getPer_nombre() {
		return per_nombre;
	}

	public void setPer_nombre(String per_nombre) {
		this.per_nombre = per_nombre;
	}

	public String getPer_genero() {
		return per_genero;
	}

	public void setPer_genero(String per_genero) {
		this.per_genero = per_genero;
	}

	public int getPer_edad() {
		return per_edad;
	}

	public void setPer_edad(int per_edad) {
		this.per_edad = per_edad;
	}

	public String getPer_identificacion() {
		return per_identificacion;
	}

	public void setPer_identificacion(String per_identificacion) {
		this.per_identificacion = per_identificacion;
	}

	public String getPer_direccion() {
		return per_direccion;
	}

	public void setPer_direccion(String per_direccion) {
		this.per_direccion = per_direccion;
	}

	public String getPer_telefono() {
		return per_telefono;
	}

	public void setPer_telefono(String per_telefono) {
		this.per_telefono = per_telefono;
	}

	
	
}
