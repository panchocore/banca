package com.ec.banca.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity(name="cuenta")
public class Cuenta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cue_id")
	private Integer cue_id;

	@Column(name="cue_numero", length = 15)
	private String cue_numero;
	
	@Column(name="cue_tipo", length = 10)
	private String cue_tipo;
	
	@Column(name="cue_saldo_inicial")
	private int cue_saldo_inicial;
	
	@Column(name="cue_estado")
	private boolean cue_estado;
	
	@ManyToOne
	@JoinColumn(name="per_id")
	Cliente cliente;
	
	//getters & setters
	public Integer getCue_id() {
		return cue_id;
	}

	public void setCue_id(Integer cue_id) {
		this.cue_id = cue_id;
	}

	public String getCue_numero() {
		return cue_numero;
	}

	public void setCue_numero(String cue_numero) {
		this.cue_numero = cue_numero;
	}

	public String getCue_tipo() {
		return cue_tipo;
	}

	public void setCue_tipo(String cue_tipo) {
		this.cue_tipo = cue_tipo;
	}

	public int getCue_saldo_inicial() {
		return cue_saldo_inicial;
	}

	public void setCue_saldo_inicial(int cue_saldo_inicial) {
		this.cue_saldo_inicial = cue_saldo_inicial;
	}

	public boolean getCue_estado() {
		return cue_estado;
	}

	public void setCue_estado(boolean cue_estado) {
		this.cue_estado = cue_estado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cuenta(Integer cue_id, String cue_numero, String cue_tipo, int cue_saldo_inicial, boolean cue_estado,
			Cliente cliente) {
		super();
		this.cue_id = cue_id;
		this.cue_numero = cue_numero;
		this.cue_tipo = cue_tipo;
		this.cue_saldo_inicial = cue_saldo_inicial;
		this.cue_estado = cue_estado;
		this.cliente = cliente;
	}

	public Cuenta(Integer cue_id) {
		super();
		this.cue_id = cue_id;
	}
	
	public Cuenta(String cue_numero, String cue_tipo, int cue_saldo_inicial, boolean cue_estado,
			Cliente cliente) {
		super();
		this.cue_numero = cue_numero;
		this.cue_tipo = cue_tipo;
		this.cue_saldo_inicial = cue_saldo_inicial;
		this.cue_estado = cue_estado;
		this.cliente = cliente;
	}
	
	public Cuenta() {
		super();
	}
}
