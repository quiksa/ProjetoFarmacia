package com.unisc.farmacia.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.unisc.farmacia.model.Estado;
import com.unisc.farmacia.repository.EstadoRepository;

@RestController
@RequestMapping("/estado")
public class EstadoResources {
	
	@Autowired
	private EstadoRepository er;
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Estado> listaEstados() {
		Iterable<Estado> listaEstados = er.findAll();
		return listaEstados;
	}
	
	@PostMapping()
	public Estado insereEstado(@RequestBody Estado estado) {
		return er.save(estado);
	}
	
	@DeleteMapping
	public Estado deletaEstado(@RequestBody Estado estado) {
		er.delete(estado);
		return estado;
	}

}
