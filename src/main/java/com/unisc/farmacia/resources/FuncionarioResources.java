package com.unisc.farmacia.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.unisc.farmacia.model.Funcionario;
import com.unisc.farmacia.repository.FuncionarioRepository;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioResources {

	@Autowired
	private FuncionarioRepository fr;
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Funcionario> listaFuncionarios() {
		Iterable<Funcionario> listaFuncionarios = fr.findAll();
		
		return listaFuncionarios;
	}
	/*
	public @ResponseBody Optional<Funcionario> exibeFuncionario(int id){
		Optional<Funcionario> funcionario = fr.findById(id);
		return funcionario;
	}
	*/
	
	@PostMapping()
	public Funcionario insereFuncionario(@RequestBody Funcionario funcionario) {
		return fr.save(funcionario);
	}
	
	@DeleteMapping
	public Funcionario deletaFuncionario(@RequestBody Funcionario funcionario) {
		fr.delete(funcionario);
		return funcionario;
	}
	
}
