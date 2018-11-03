package com.unisc.farmacia.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.unisc.farmacia.model.Cargo;
import com.unisc.farmacia.repository.CargoRepository;

@RestController
@RequestMapping("/cargo")
public class CargoResources {

	@Autowired
	private CargoRepository cr;

	@GetMapping("/load")
	public @ResponseBody Iterable<Cargo> listaCargos() {
		Iterable<Cargo> listaCargos = cr.findAll();
		return listaCargos;
	}

	@Transactional
	@RequestMapping(value = "/insertOrUpdadeCargo", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Cargo> retornaUnidade(@RequestBody Cargo cargo) {
		try {
			if (!cargo.getDsCargo().equals("") || !cargo.getNmCargo().equals("")) {
				cr.save(cargo);
			} else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<>(cargo, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/cargo")
	public Cargo insereCargo(@RequestBody Cargo cargo) {
		return cr.save(cargo);
	}

	@RequestMapping(value = "/deleteCargo", method = RequestMethod.GET)
	public ResponseEntity<Cargo> delCargo(
			@RequestParam(value = "idcargo", required = true, name = "idcargo") int idcargo) {
		try {
			Optional<Cargo> cargo = cr.findById(idcargo);
			if (cargo.isPresent()) {
				cr.delete(cargo.get());
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	// POR ITEM UNICO

	@GetMapping("/cargo/id={id}")
	public @ResponseBody Optional<Cargo> retornaCargoPorId(@PathVariable Integer id) {
		Optional<Cargo> cargo = cr.findCargoById(id);
		return cargo;
	}

	@GetMapping("/cargo/ds={ds}")
	public @ResponseBody Optional<Cargo> retornaCargoPorId(@PathVariable String ds) {
		Optional<Cargo> cargo = cr.findCargoByDs(ds);
		return cargo;
	}

}
