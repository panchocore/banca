package com.ec.banca.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity(name="cliente")
@PrimaryKeyJoinColumn(referencedColumnName = "per_id")

public class Cliente extends Persona {

	@Column(name="cli_clave", length = 12)
	private String cli_clave;
	
	@Column(name="cli_estado")
	private boolean cli_estado;
	
	@OneToMany
	@JoinColumn(name="per_id")
	private List<Cuenta> cuentaList = new ArrayList<>();
	
	
	
	
	public Cliente() {
		super();
	}

	public String getCli_clave() {
		return cli_clave;
	}

	public void setCli_clave(String cli_clave) {
		this.cli_clave = cli_clave;
	}

	public boolean getCli_estado() {
		return cli_estado;
	}

	public void setCli_estado(boolean cli_estado) {
		this.cli_estado = cli_estado;
	}

	public List<Cuenta> getCuentaList() {
		return cuentaList;
	}

	public void setCuentaList(List<Cuenta> cuentaList) {
		this.cuentaList = cuentaList;
	}

	public Cliente(String cli_clave, boolean cli_estado, List<Cuenta> cuentaList) {
		super();
		this.cli_clave = cli_clave;
		this.cli_estado = cli_estado;
		this.cuentaList = cuentaList;
	}
	
	
}
