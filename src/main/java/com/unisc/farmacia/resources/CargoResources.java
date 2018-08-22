package com.unisc.farmacia.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.unisc.farmacia.model.Cargo;
import com.unisc.farmacia.repository.CargoRepository;

@RestController
@RequestMapping("/cargo")
public class CargoResources {

	@Autowired
	private CargoRepository cr;
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Cargo> listaCargos() {
		Iterable<Cargo> listaCargos = cr.findAll();
		return listaCargos;
	}
	
	@PostMapping()
	public Cargo insereCargo(@RequestBody Cargo cargo) {
		return cr.save(cargo);
	}
	
	@DeleteMapping
	public Cargo deletaCargo(@RequestBody Cargo cargo) {
		cr.delete(cargo);
		return cargo;
	}
	
}
