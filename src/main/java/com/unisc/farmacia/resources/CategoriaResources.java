package com.unisc.farmacia.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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

import com.unisc.farmacia.model.Categoria;
import com.unisc.farmacia.model.Unidade;
import com.unisc.farmacia.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
public class CategoriaResources {

	@Autowired
	private CategoriaRepository cr;

	@RequestMapping("/load")
	public @ResponseBody Iterable<Categoria> listaCategorias() {
		Iterable<Categoria> listaCategorias = cr.findAll();
		return listaCategorias;
	}

	@Transactional
	@RequestMapping(value = "/insertOrUpdadeCategoria", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Categoria> retornaUnidade(@RequestBody Categoria categoria) {
		try {
			if (!categoria.getDsCategoria().equals("") && !categoria.getNmCategoria().equals("")) {
				cr.save(categoria);
			} else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<Categoria>(categoria, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/deleteCategoria", method = RequestMethod.GET)
	public ResponseEntity<Unidade> delCategoria(
			@RequestParam(value = "idCategoria", required = true, name = "idCategoria") int idCategoria) {
		try {
			Optional<Categoria> categoria = cr.findById(idCategoria);
			if (categoria.isPresent()) {
				cr.delete(categoria.get());
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
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
