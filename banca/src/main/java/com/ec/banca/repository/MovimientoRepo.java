package com.ec.banca.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.ec.banca.model.Movimientos;

@Repository
public interface MovimientoRepo extends JpaRepository<Movimientos, Integer> {

	@Procedure(value = "GET_TOTAL_SALDO")
	int getTotalSaldo(int id, String fecha);
	
	@Procedure(value = "GET_SALDO_INICIAL")
	int getSaldoInicial(int id);
	
	
}
