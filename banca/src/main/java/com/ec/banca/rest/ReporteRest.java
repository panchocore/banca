package com.ec.banca.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ec.banca.model.Reporte;
import com.ec.banca.repository.ReporteRepo;



@RestController
@RequestMapping("/reportes")
public class ReporteRest {
	
	@Autowired
	private ReporteRepo repo;
	
	@GetMapping("/movimientos/{id}/{f1}/{f2}")
	public List<Reporte> listar(@PathVariable("id") Integer id, @PathVariable("f1") String f1, @PathVariable("f2") String f2){	
		return repo.getReporte(id, f1, f2);
	}
}
