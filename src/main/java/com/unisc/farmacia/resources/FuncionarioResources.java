package com.unisc.farmacia.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.unisc.farmacia.model.Funcionario;
import com.unisc.farmacia.repository.FuncionarioRepository;

@RestController
public class FuncionarioResources {

	@Autowired
	private FuncionarioRepository fr;

	@GetMapping("/funcionario")
	public @ResponseBody Iterable<Funcionario> listaFuncionarios() {
		Iterable<Funcionario> listaFuncionarios = fr.findAll();

		return listaFuncionarios;
	}

	@PostMapping("/funcionario")
	public Funcionario insereFuncionario(@RequestBody Funcionario funcionario) {
		return fr.save(funcionario);
	}

	@DeleteMapping("/funcionario")
	public Funcionario deletaFuncionario(@RequestBody Funcionario funcionario) {
		fr.delete(funcionario);
		return funcionario;
	}

	// Por item único

	@GetMapping("/funcionario/{id}")
	public @ResponseBody Optional<Funcionario> retornaFuncionarioPorId(@PathVariable Integer id) {
		Optional<Funcionario> funcionario = fr.findById(id);
		return funcionario;
	}
	
	@GetMapping("/funcionario/{login}/{senha}")
	public @ResponseBody Optional<Funcionario>retornaFuncionario(@RequestParam String login, @RequestParam String senha){
		
		Optional<Funcionario>funcionario = fr.listaFuncionario(login,senha);
		return funcionario;
		
	}
	
	

}
