package com.unisc.farmacia.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.unisc.farmacia.model.Estado;
import com.unisc.farmacia.repository.EstadoRepository;

@RestController
public class EstadoResources {

	@Autowired
	private EstadoRepository er;

	@GetMapping("/estado")
	public @ResponseBody Iterable<Estado> listaEstados() {
		Iterable<Estado> listaEstados = er.findAll();
		return listaEstados;
	}

	@PostMapping("/estado")
	public Estado insereEstado(@RequestBody Estado estado) {
		return er.save(estado);
	}

	@DeleteMapping("/estado")
	public Estado deletaEstado(@RequestBody Estado estado) {
		er.delete(estado);
		return estado;
	}

	@GetMapping("/estado={id}")
	public @ResponseBody Optional<Estado> retornaEstadoPorId(@PathVariable Integer id) {
		Optional<Estado> estado = er.findById(id);
		return estado;
	}
	
		

}
