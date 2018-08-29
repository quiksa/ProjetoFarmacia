package com.unisc.farmacia.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.unisc.farmacia.model.Mercadoria;
import com.unisc.farmacia.repository.MercadoriaRepository;

@RestController
@RequestMapping("/mercadoria")
public class MercadoriaResources {

	@Autowired
	private MercadoriaRepository cr;
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Mercadoria> listaMercadorias() {
		Iterable<Mercadoria> listaMercadorias = cr.findAll();
		
		return listaMercadorias;
	}
	/*
	public @ResponseBody Optional<Mercadoria> exibeMercadoria(int id){
		Optional<Mercadoria> mercadoria = cr.findById(id);
		return mercadoria;
	}
	*/
	
	@PostMapping()
	public Mercadoria insereMercadoria(@RequestBody Mercadoria mercadoria) {
		return cr.save(mercadoria);
	}
	
	@DeleteMapping
	public Mercadoria deletaMercadoria(@RequestBody Mercadoria mercadoria) {
		cr.delete(mercadoria);
		return mercadoria;
	}
	
}
