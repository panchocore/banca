package com.ec.banca.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ec.banca.config.exception.BadRequestException;
import com.ec.banca.model.Movimientos;
import com.ec.banca.repository.CuentaRepo;
import com.ec.banca.repository.MovimientoRepo;

@RestController
@RequestMapping("/movimientos")
public class MovimientoRest {
	
	@Autowired
	private MovimientoRepo repo;
	
	@Autowired
	private CuentaRepo cuentaRepo;
	
	
	
	@PostMapping("/crear/{id}")
	private void crear(@RequestBody Movimientos obj, @PathVariable("id") Integer id) {
		
		int salida = 0;
		salida = repo.getTotalSaldo(id, obj.getMov_fecha().toString());
		
		int saldo =0;
		saldo = repo.getSaldoInicial(id);
		
		if (salida >= 1000) {
			throw new BadRequestException("Cupo diario excedido");
		}
		
		if(obj.getMov_tipo().equalsIgnoreCase("debito")){
			
			//System.out.println("saldo: " + saldo);
			if(saldo == 0) {
				throw new BadRequestException("Saldo no disponible");	
			}
			
			obj.setMov_valor(obj.getMov_valor() * -1);
		}
		
		obj.setMov_saldo(saldo + obj.getMov_valor());
		
		obj.setCuenta(cuentaRepo.findById(id).get());
		
		repo.save(obj);
	}
	
	@PutMapping("/actualizar")
	private void actualizar(@RequestBody Movimientos obj) {
		repo.save(obj);
	}
	
	@DeleteMapping("/eliminar/{id}")
	private void eliminar(@PathVariable("id") Integer id) {
		repo.deleteById(id);
	}

}
