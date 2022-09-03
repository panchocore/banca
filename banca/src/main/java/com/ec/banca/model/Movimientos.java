package com.ec.banca.model;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name="movimiento")
public class Movimientos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="mov_id")
	private Integer mov_id;
	
	@Column(name="mov_fecha")
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date mov_fecha;
	
	@Column(name="mov_tipo", length = 10)
	private String mov_tipo;
	
	@Column(name="mov_valor", precision = 12, scale = 2)
	private int mov_valor;
	
	@Column(name="mov_saldo", precision = 12, scale = 2)
	private int mov_saldo;

	@ManyToOne
	@JoinColumn(name="cue_id")
	Cuenta cuenta;
	
	
	
	public Integer getMov_id() {
		return mov_id;
	}

	public void setMov_id(Integer mov_id) {
		this.mov_id = mov_id;
	}

	public Date getMov_fecha() {
		return mov_fecha;
	}

	public void setMov_fecha(Date mov_fecha) {
		this.mov_fecha = mov_fecha;
	}

	public String getMov_tipo() {
		return mov_tipo;
	}

	public void setMov_tipo(String mov_tipo) {
		this.mov_tipo = mov_tipo;
	}

	public int getMov_valor() {
		return mov_valor;
	}

	public void setMov_valor(int mov_valor) {
		this.mov_valor = mov_valor;
	}

	public int getMov_saldo() {
		return mov_saldo;
	}

	public void setMov_saldo(int mov_saldo) {
		this.mov_saldo = mov_saldo;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	@Override
	public String toString() {
		return "Movimientos [mov_id=" + mov_id + ", mov_fecha=" + mov_fecha + ", mov_tipo=" + mov_tipo + ", mov_valor="
				+ mov_valor + ", mov_saldo=" + mov_saldo + ", cuenta=" + cuenta + "]";
	}

	
	
}
