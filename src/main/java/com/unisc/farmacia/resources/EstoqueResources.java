package com.unisc.farmacia.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.unisc.farmacia.model.Estoque;
import com.unisc.farmacia.repository.EstoqueRepository;

@RestController
@RequestMapping("/estoque")
public class EstoqueResources {

	@Autowired
	private EstoqueRepository er;
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Estoque> listaEstoques() {
		Iterable<Estoque> listaEstoques = er.findAll();
		
		return listaEstoques;
	}
	/*
	public @ResponseBody Optional<Estoque> exibeEstoque(int id){
		Optional<Estoque> estoque = er.findById(id);
		return estoque;
	}
	*/
	
	@PostMapping()
	public Estoque insereEstoque(@RequestBody Estoque estoque) {
		return er.save(estoque);
	}
	
	@DeleteMapping
	public Estoque deletaEstoque(@RequestBody Estoque estoque) {
		er.delete(estoque);
		return estoque;
	}
	
}
