package com.unisc.farmacia.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.unisc.farmacia.model.Cargo;
import com.unisc.farmacia.repository.CargoRepository;

@RestController
public class CargoResources {

	@Autowired
	private CargoRepository cr;
	
	@GetMapping("/cargo")
	public @ResponseBody Iterable<Cargo> listaCargos() {
		Iterable<Cargo> listaCargos = cr.findAll();
		
		return listaCargos;
	}

	@PostMapping("/cargo")
	public Cargo insereCargo(@RequestBody Cargo cargo) {
		return cr.save(cargo);
	}
	
	@DeleteMapping("/cargo")
	public Cargo deletaCargo(@RequestBody Cargo cargo) {
		cr.delete(cargo);
		return cargo;
	}
	
	
	// POR ITEM UNICO
	
	@GetMapping("/cargo/{id}")
	public @ResponseBody Optional<Cargo> retornaCargoPorId(@PathVariable Integer id) {
		Optional<Cargo> cargo = cr.findById(id);
		return cargo;
	}
	
	
}
