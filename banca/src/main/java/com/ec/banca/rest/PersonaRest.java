package com.ec.banca.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.ec.banca.model.GenericMapper;
import com.ec.banca.model.Persona;
import com.ec.banca.repository.PersonaRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;


@RestController
@RequestMapping("/personas")
public class PersonaRest {

	@Autowired
	private PersonaRepo repo;
	
	@GetMapping("/listarPersonas")
	public List<Persona> listarPersonas(){
		return null;
	}
	
	@PostMapping("/crear")
	public void guardar(@RequestBody Persona obj) throws JsonMappingException, JsonProcessingException {
				
		/*
		// Serializar:
		String json = GenericMapper.serialize(obj);
		// Deserializar, clase Persona
		Persona p = GenericMapper.deserialize(json, Persona.class);
		*/
		
		repo.save(obj);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Persona obj){
		repo.save(obj);
	}
	
	@DeleteMapping(value = "/eliminar/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		repo.deleteById(id);
	}
}
