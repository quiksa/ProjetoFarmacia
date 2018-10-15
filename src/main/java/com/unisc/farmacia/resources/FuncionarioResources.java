package com.unisc.farmacia.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@GetMapping("/funcionario/id={id}")
	public @ResponseBody Optional<Funcionario> retornaFuncionarioPorId(@PathVariable Integer id) {
		Optional<Funcionario> funcionario = fr.findById(id);
		return funcionario;
	}

	@GetMapping("/funcionario/nome={nome}")
	public @ResponseBody Optional<Object> buscaFuncporNome(@PathVariable String nome) {
		Optional<Object> funcs = fr.buscaCargoFuncionario(nome);
		return funcs;
	}

	// http://localhost:8080/funcionario/signin?login=Ascostofes&senha=ascostofes
	@RequestMapping(value = "/funcionario/signin", method = RequestMethod.POST,consumes="application/json")
	public ResponseEntity<Funcionario> retornaFuncionario(@RequestBody Funcionario f){
		String senha = f.getSenha();
		String login = f.getLogin();
		Funcionario func = new Funcionario();
		func = fr.listaFuncionario(login, senha);
		if (func.equals(null)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Funcionario>(func, HttpStatus.OK);
		}
	}
}