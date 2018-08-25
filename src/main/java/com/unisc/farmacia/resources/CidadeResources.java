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
import com.unisc.farmacia.model.Cidade;
import com.unisc.farmacia.repository.CidadeRepository;

@RestController
@RequestMapping("/cidade")
public class CidadeResources {

	@Autowired
	private CidadeRepository cr;
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Cidade> listaCidades() {
		Iterable<Cidade> listaCidades = cr.findAll();
		return listaCidades;
	}
	
	@PostMapping()
	public Cidade insereCidade(@RequestBody Cidade cidade) {
		return cr.save(cidade);
	}
	
	@DeleteMapping
	public Cidade deletaCidade(@RequestBody Cidade cidade) {
		cr.delete(cidade);
		return cidade;
	}
	
}
