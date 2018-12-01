package com.unisc.farmacia.resources;

import java.time.LocalDate;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.unisc.farmacia.model.Cidade;
import com.unisc.farmacia.model.Cliente;
import com.unisc.farmacia.model.Endereco;
import com.unisc.farmacia.model.Pessoa;
import com.unisc.farmacia.repository.CidadeRepository;
import com.unisc.farmacia.repository.ClienteRepository;
import com.unisc.farmacia.repository.EnderecoRepository;
import com.unisc.farmacia.repository.PessoaRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteResources {

	@Autowired
	private ClienteRepository cr;
	@Autowired
	private EnderecoRepository er;
	@Autowired
	private PessoaRepository pr;
	@Autowired
	private CidadeRepository cidr;

	@GetMapping(produces = "application/json")
	public @ResponseBody Iterable<Cliente> listaClientes() {
		Iterable<Cliente> listaClientes = cr.findAll();
		return listaClientes;
	}

	@PostMapping("/cliente")
	public Cliente insereCliente(@RequestBody Cliente cliente) {
		return cr.save(cliente);
	}

	@DeleteMapping("/cliente")
	public Cliente deletaCliente(@RequestBody Cliente cliente) {
		cr.delete(cliente);
		return cliente;
	}

	// POR ITEM UNICO

	@GetMapping("/cliente/id={id}")
	public @ResponseBody Optional<Cliente> retornaClientePorId(@PathVariable Integer id) {
		Optional<Cliente> cliente = cr.findById(id);
		return cliente;
	}
	
	@GetMapping("/cliente/nome={nome}")
	public @ResponseBody List<Cliente>retornaListaClientePorNome(@PathVariable String nome){
		List<Cliente> cliente = cr.findListaClientePorNome(nome);
		return cliente;
	}


	@RequestMapping(value = "/deleteCliente", method = RequestMethod.GET)
	public ResponseEntity<Cliente> delcliente(
			@RequestParam(value = "idcliente", required = true, name = "idcliente") int idcliente) {
		try {
			Optional<Cliente> cliente = cr.findById(idcliente);
			if (cliente.isPresent()) {
				cr.delete(cliente.get());
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@Transactional
	@RequestMapping(value = "/insertOrUpdadeCliente", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Cliente> retornaCliente(@RequestBody Cliente cliente) {
		try {
			if (!cliente.getNmPessoa().equals("") && !cliente.getNrcpf().equals("")
					&& !cliente.getNrTelefone().equals("") && !cliente.getBairro().equals("")
					&& !cliente.getDscomplemento().equals("") && !cliente.getDtnascimento().equals("")
					&& !cliente.getEmail().equals("") && !cliente.getNmPessoa().equals("")
					&& !cliente.getNmrua().equals("") && !cliente.getNrTelefone().equals("")
					&& !cliente.getSgsexo().equals("")) {
				Optional<Cidade> cid = cidr.findById(Integer.parseInt(cliente.getIdcidade()));
				if (cid.isPresent()) {
					Endereco end = new Endereco();
					end.setBairro(cliente.getBairro());
					end.setCidade(cid.get());
					end.setDsComplemento(cliente.getDscomplemento());
					if (cliente.getIdEndereco() != null) {
						end.setIdEndereco(Integer.parseInt(cliente.getIdEndereco()));
					}
					end.setNmRua(cliente.getNmrua());
					er.save(end);
					er.flush();
					Pessoa p = new Pessoa();
					if (cliente.getIdpessoa() != null) {
						p.setIdPessoa(Integer.parseInt(cliente.getIdpessoa()));
					}
					p.setEndereco(end);
					p.setNmPessoa(cliente.getNmPessoa());
					p.setNrtelefone(cliente.getNrTelefone());
					p.setSgsexo(cliente.getSgsexo());
					p.setEmail(cliente.getEmail());
					p.setDtnascimento(LocalDate.parse(cliente.getDtnascimento()));
					pr.save(p);
					pr.flush();
					Cliente cli = new Cliente();
					cli.setIdCliente(cliente.getIdCliente());
					cli.setPessoa(p);
					cr.save(cli);
					return new ResponseEntity<Cliente>(cli, HttpStatus.OK);
				} else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
			} else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
}