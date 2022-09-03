package com.ec.banca.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ec.banca.model.Cuenta;
import com.ec.banca.repository.ClienteRepo;
import com.ec.banca.repository.CuentaRepo;

@RestController
@RequestMapping("/cuentas")
public class CuentaRest {
	
	@Autowired
	private CuentaRepo repo;
	
	@Autowired
	private ClienteRepo clienteRepo;
	
	@PostMapping("/crear/{id}")
	private void crear(@RequestBody Cuenta obj, @PathVariable("id") Integer id) {
		
		obj.setCliente(clienteRepo.findById(id).get());
		repo.save(obj);
	}
	
	@PutMapping("/actualizar")
	private void actualizar(@RequestBody Cuenta obj) {
		repo.save(obj);
	}
	
	@DeleteMapping(value = "/eliminar/{id}")
	private void eliminar(@PathVariable("id") Integer id) {
		repo.deleteById(id);
	}

}
