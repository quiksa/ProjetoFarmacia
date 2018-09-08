package com.unisc.farmacia.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.unisc.farmacia.model.Pessoa;
import com.unisc.farmacia.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoa")
public class PessoaResources {

	@Autowired
	private PessoaRepository pr;
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Pessoa> listaPessoas() {
		Iterable<Pessoa> listaPessoas = pr.findAll();
		
		return listaPessoas;
	}
	/*
	public @ResponseBody Optional<Pessoa> exibePessoa(int id){
		Optional<Pessoa> pessoa = pr.findById(id);
		return pessoa;
	}
	*/
	
	@PostMapping()
	public Pessoa inserePessoa(@RequestBody Pessoa pessoa) {
		return pr.save(pessoa);
	}
	
	@DeleteMapping
	public Pessoa deletaPessoa(@RequestBody Pessoa pessoa) {
		pr.delete(pessoa);
		return pessoa;
	}
	
}
