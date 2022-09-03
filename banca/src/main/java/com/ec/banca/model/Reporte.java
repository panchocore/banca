package com.ec.banca.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reporte {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int r_id;
	
	private String fecha;
	private String cliente;
	private String cuenta;
	private String tipo;
	private int saldoInicial;
	private boolean estado;
	private int movimiento;
	private int saldoDisponible;
	
	
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getCuenta() {
		return cuenta;
	}
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getSaldoInicial() {
		return saldoInicial;
	}
	public void setSaldoInicial(int saldoInicial) {
		this.saldoInicial = saldoInicial;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public int getMovimiento() {
		return movimiento;
	}
	public void setMovimiento(int movimiento) {
		this.movimiento = movimiento;
	}
	public int getSaldoDisponible() {
		return saldoDisponible;
	}
	public void setSaldoDisponible(int saldoDisponible) {
		this.saldoDisponible = saldoDisponible;
	}
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	@Override
	public String toString() {
		return "Reporte [r_id=" + r_id + ", fecha=" + fecha + ", cliente=" + cliente + ", cuenta=" + cuenta + ", tipo="
				+ tipo + ", saldoInicial=" + saldoInicial + ", estado=" + estado + ", movimiento=" + movimiento
				+ ", saldoDisponible=" + saldoDisponible + "]";
	}
	public Reporte(int r_id, String fecha, String cliente, String cuenta, String tipo, int saldoInicial, boolean estado,
			int movimiento, int saldoDisponible) {
		super();
		this.r_id = r_id;
		this.fecha = fecha;
		this.cliente = cliente;
		this.cuenta = cuenta;
		this.tipo = tipo;
		this.saldoInicial = saldoInicial;
		this.estado = estado;
		this.movimiento = movimiento;
		this.saldoDisponible = saldoDisponible;
	}
	
	public Reporte(int r_id) {
		super();
		this.r_id = r_id;
	}
	
	public Reporte(String fecha, String cliente, String cuenta, String tipo, int saldoInicial, boolean estado,
			int movimiento, int saldoDisponible) {
		super();
		this.fecha = fecha;
		this.cliente = cliente;
		this.cuenta = cuenta;
		this.tipo = tipo;
		this.saldoInicial = saldoInicial;
		this.estado = estado;
		this.movimiento = movimiento;
		this.saldoDisponible = saldoDisponible;
	}
	

	public Reporte() {
		super();
	}
}
