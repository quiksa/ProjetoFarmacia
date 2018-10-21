package com.unisc.farmacia.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.unisc.farmacia.model.Unidade;
import com.unisc.farmacia.repository.EnderecoRepository;
import com.unisc.farmacia.repository.UnidadeRepository;

@RestController
@RequestMapping("/unidade")
public class UnidadeResources {

	@Autowired
	private UnidadeRepository ur;
	private EnderecoRepository er;
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Unidade> listaUnidades() {
		Iterable<Unidade> listaUnidades = ur.findAll();
		
		return listaUnidades;
	}
	/*
	public @ResponseBody Optional<Unidade> exibeUnidade(int id){
		Optional<Unidade> unidade = ur.findById(id);
		return unidade;
	}
	*/
	
	@PostMapping()
	public Unidade insereUnidade(@RequestBody Unidade unidade) {
		return ur.save(unidade);
	}
	
	@RequestMapping(value = "/insertOrUpdadeUnidade", method = RequestMethod.POST,consumes="application/json")
	public ResponseEntity<Unidade> retornaUnidade(@RequestBody Unidade unidade){
		try {	
			ur.save(unidade);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.getMessage();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping
	public Unidade deletaUnidade(@RequestBody Unidade unidade) {
		ur.delete(unidade);
		return unidade;
	}
	
}
