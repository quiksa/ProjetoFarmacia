package com.unisc.farmacia.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.unisc.farmacia.model.Endereco;
import com.unisc.farmacia.repository.EnderecoRepository;

@RestController
@RequestMapping("/endereco")
public class EnderecoResources {

	@Autowired
	private EnderecoRepository er;
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Endereco> listaEnderecos() {
		Iterable<Endereco> listaEnderecos = er.findAll();
		return listaEnderecos;
	}
	
	@PostMapping()
	public Endereco insereEndereco(@RequestBody Endereco Endereco) {
		return er.save(Endereco);
	}
	
	@DeleteMapping
	public Endereco deletaEndereco(@RequestBody Endereco Endereco) {
		er.delete(Endereco);
		return Endereco;
	}
	
}
