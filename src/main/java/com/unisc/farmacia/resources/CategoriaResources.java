package com.unisc.farmacia.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.unisc.farmacia.model.Cargo;
import com.unisc.farmacia.model.Categoria;
import com.unisc.farmacia.repository.CategoriaRepository;

@RestController
public class CategoriaResources {

	@Autowired
	private CategoriaRepository cr;
	
	@GetMapping("/categoria")
	public @ResponseBody Iterable<Categoria> listaCategorias() {
		Iterable<Categoria> listaCategorias = cr.findAll();
		
		return listaCategorias;
	}
	
	@PostMapping("/categoria")
	public Categoria insereCategoria(@RequestBody Categoria categoria) {
		return cr.save(categoria);
	}
	
	@DeleteMapping("/categoria")
	public Categoria deletaCategoria(@RequestBody Categoria categoria) {
		cr.delete(categoria);
		return categoria;
	}
	
	
	// POR ITEM UNICO
	@GetMapping("/categoria/{id}")
	public @ResponseBody Optional<Categoria> retornaCategoriaPorId(@PathVariable Integer id) {
		Optional<Categoria> categoria = cr.findById(id);
		return categoria;
	}
	
	
}
