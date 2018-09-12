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

import com.unisc.farmacia.model.Cidade;
import com.unisc.farmacia.model.Cidade;
import com.unisc.farmacia.repository.CidadeRepository;

@RestController
public class CidadeResources {

	@Autowired
	private CidadeRepository cr;

	@GetMapping("/cidade")
	public @ResponseBody Iterable<Cidade> listaCidades() {
		Iterable<Cidade> listaCidades = cr.findAll();
		return listaCidades;
	}

	@PostMapping("/cidade")
	public Cidade insereCidade(@RequestBody Cidade cidade) {
		return cr.save(cidade);
	}

	@DeleteMapping("/cidade")
	public Cidade deletaCidade(@RequestBody Cidade cidade) {
		cr.delete(cidade);
		return cidade;
	}

	// POR ITEM UNICO

	@GetMapping("/cidade/{id}")
	public @ResponseBody Optional<Cidade> retornaCidadePorId(@PathVariable Integer id) {
		Optional<Cidade> cidade = cr.findById(id);
		return cidade;
	}

	
}
