package com.ec.banca.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ec.banca.model.Cliente;
import com.ec.banca.repository.ClienteRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
@RequestMapping("/clientes")
public class ClienteRest {
	
	@Autowired
	private ClienteRepo repo;
	
	@PostMapping("/crear")
	public void guardar(@RequestBody Cliente obj) throws JsonMappingException, JsonProcessingException {
		repo.save(obj);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Cliente obj){
		repo.save(obj);
	}
	
	@DeleteMapping(value = "/eliminar/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		repo.deleteById(id);
	}

}
