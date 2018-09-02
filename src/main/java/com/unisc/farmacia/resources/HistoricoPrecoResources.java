package com.unisc.farmacia.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.unisc.farmacia.model.HistoricoPreco;
import com.unisc.farmacia.repository.HistoricoPrecoRepository;

@RestController
@RequestMapping("/historico")
public class HistoricoPrecoResources {

	@Autowired
	private HistoricoPrecoRepository hr;
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<HistoricoPreco> listaHistoricoPrecos() {
		Iterable<HistoricoPreco> listaHistoricoPrecos = hr.findAll();
		
		return listaHistoricoPrecos;
	}
	/*
	public @ResponseBody Optional<HistoricoPreco> exibeHistoricoPreco(int id){
		Optional<HistoricoPreco> historicopreco = hr.findById(id);
		return historicopreco;
	}
	*/
	
	@PostMapping()
	public HistoricoPreco insereHistoricoPreco(@RequestBody HistoricoPreco historicopreco) {
		return hr.save(historicopreco);
	}
	
	@DeleteMapping
	public HistoricoPreco deletaHistoricoPreco(@RequestBody HistoricoPreco historicopreco) {
		hr.delete(historicopreco);
		return historicopreco;
	}
	
}
