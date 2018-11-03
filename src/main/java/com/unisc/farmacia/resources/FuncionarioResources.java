package com.unisc.farmacia.resources;

import java.time.LocalDate;
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
import com.unisc.farmacia.model.Cidade;
import com.unisc.farmacia.model.Endereco;
import com.unisc.farmacia.model.Funcionario;
import com.unisc.farmacia.model.Pessoa;
import com.unisc.farmacia.model.Unidade;
import com.unisc.farmacia.repository.CargoRepository;
import com.unisc.farmacia.repository.CidadeRepository;
import com.unisc.farmacia.repository.EnderecoRepository;
import com.unisc.farmacia.repository.FuncionarioRepository;
import com.unisc.farmacia.repository.PessoaRepository;
import com.unisc.farmacia.repository.UnidadeRepository;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioResources {

	@Autowired
	private FuncionarioRepository fr;
	@Autowired
	private PessoaRepository pr;
	@Autowired
	private EnderecoRepository er;
	@Autowired
	private CidadeRepository cidr;
	@Autowired
	private CargoRepository cr;
	@Autowired
	private UnidadeRepository ur;

	@GetMapping("/load")
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
	@RequestMapping(value = "/signin", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Funcionario> retornaFuncionario(@RequestBody Funcionario f) {
		String senha = f.getSenha();
		String login = f.getLogin();
		String idunidade = f.getIdunidade();
		Funcionario func = new Funcionario();
		func = fr.listaFuncionario(login, senha, Integer.parseInt(idunidade));
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
			if (!funcionario.getNmPessoa().equals("") && !funcionario.getNrCpf().equals("")
					&& !funcionario.getBairro().equals("") && !funcionario.getIdcargo().equals("")
					&& !funcionario.getDscomplemento().equals("") && !funcionario.getDtnascimento().equals("")
					&& !funcionario.getEmail().equals("") && !funcionario.getIdcidade().equals("")
					&& !funcionario.getIdunidade().equals("") && !funcionario.getLogin().equals("")
					&& !funcionario.getNmrua().equals("") && !funcionario.getSenha().equals("")
					&& !funcionario.getSgsexo().equals("") && !funcionario.getNrTelefone().equals("")) {
				Optional<Cidade> cid = cidr.findById(Integer.parseInt(funcionario.getIdcidade()));
				if (cid.isPresent()) {
					Endereco end = new Endereco();
					end.setBairro(funcionario.getBairro());
					end.setCidade(cid.get());
					end.setDsComplemento(funcionario.getDscomplemento());
					if (funcionario.getIdEndereco() != null) {
						end.setIdEndereco(Integer.parseInt(funcionario.getIdEndereco()));
					}
					end.setNmRua(funcionario.getNmrua());
					er.save(end);
					er.flush();
					Pessoa p = new Pessoa();
					if (funcionario.getIdpessoa() != null) {
						p.setIdPessoa(Integer.parseInt(funcionario.getIdpessoa()));
					}
					p.setEndereco(end);
					p.setNmPessoa(funcionario.getNmPessoa());
					p.setNrcpf(funcionario.getNrCpf());
					p.setNrtelefone(funcionario.getNrTelefone());
					p.setSgsexo(funcionario.getSgsexo());
					p.setEmail(funcionario.getEmail());
					p.setDtnascimento(LocalDate.parse(funcionario.getDtnascimento()));
					pr.save(p);
					pr.flush();
					Optional<Unidade> unid = ur.findById(Integer.parseInt(funcionario.getIdunidade()));
					Optional<Cargo> cargo = cr.findById(Integer.parseInt(funcionario.getIdcargo()));
					if (unid.isPresent() && cargo.isPresent()) {
						funcionario.setPessoa(p);
						funcionario.setUnidade(unid.get());
						funcionario.setCargo(cargo.get());
						fr.save(funcionario);
						return new ResponseEntity<Funcionario>(funcionario, HttpStatus.OK);
					} else {
						return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
					}

				} else {
					return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
				}
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return null;
	}

}