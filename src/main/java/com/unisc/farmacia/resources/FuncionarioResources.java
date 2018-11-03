package com.unisc.farmacia.resources;

import java.util.Optional;

import javax.transaction.Transactional;
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

import com.unisc.farmacia.model.Cargo;
import com.unisc.farmacia.model.Endereco;
import com.unisc.farmacia.model.Funcionario;
import com.unisc.farmacia.model.Pessoa;
import com.unisc.farmacia.repository.CargoRepository;
import com.unisc.farmacia.repository.EnderecoRepository;
import com.unisc.farmacia.repository.FuncionarioRepository;
import com.unisc.farmacia.repository.PessoaRepository;

@RestController
public class FuncionarioResources {

	@Autowired
	private FuncionarioRepository fr;
	@Autowired
	private PessoaRepository pr;
	@Autowired
	private EnderecoRepository er;
	@Autowired
	private CargoRepository cr;
	
	

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
	
	@Transactional
	@RequestMapping(value = "/insertOrUpdadeFuncionario", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Funcionario> insertFuncionario(@RequestBody Funcionario funcionario) {
		try {
			if(!funcionario.getDsCargo().equals("") && !funcionario.getNmPessoa().equals("") && 
					!funcionario.getNrCpf().equals("") && !funcionario.getNrTelefone().equals("")){
				//passa o idendereco por parametro do front-end
				Optional<Endereco> end = er.findById(Integer.parseInt(funcionario.getIdEndereco()));
				Pessoa p = new Pessoa();
				p.setEndereco(end.get());
				p.setNmPessoa(funcionario.getNmPessoa());
				p.setNrcpf(funcionario.getNrCpf());
				p.setNrtelefone(funcionario.getNrTelefone());
				pr.save(p);
				pr.flush();
				Cargo c = new Cargo();
				c.setDsCargo(funcionario.getDsCargo());
				cr.save(c);
				cr.flush();
				Funcionario func = new Funcionario();
				func.setLogin(funcionario.getLogin());
				func.setSenha(funcionario.getSenha());
				fr.save(func);
				fr.flush();
				
			}else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return null;
	}
	
	
	
}