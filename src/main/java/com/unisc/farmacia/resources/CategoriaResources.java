package com.unisc.farmacia.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.unisc.farmacia.model.Categoria;
import com.unisc.farmacia.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
public class CategoriaResources {

	@Autowired
	private CategoriaRepository cr;
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Categoria> listaCategorias() {
		Iterable<Categoria> listaCategorias = cr.findAll();
		
		return listaCategorias;
	}
	/*
	public @ResponseBody Optional<Categoria> exibeCategoria(int id){
		Optional<Categoria> categoria = cr.findById(id);
		return categoria;
	}
	*/
	
	@PostMapping()
	public Categoria insereCategoria(@RequestBody Categoria categoria) {
		return cr.save(categoria);
	}
	
	@DeleteMapping
	public Categoria deletaCategoria(@RequestBody Categoria categoria) {
		cr.delete(categoria);
		return categoria;
	}
	
}
