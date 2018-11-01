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

import com.unisc.farmacia.model.Cidade;
import com.unisc.farmacia.model.Cliente;
import com.unisc.farmacia.model.Endereco;
import com.unisc.farmacia.model.Pessoa;
import com.unisc.farmacia.repository.CidadeRepository;
import com.unisc.farmacia.repository.ClienteRepository;
import com.unisc.farmacia.repository.EnderecoRepository;
import com.unisc.farmacia.repository.PessoaRepository;

@RestController
public class ClienteResources {

	@Autowired
	private ClienteRepository cr;
	private EnderecoRepository er;
	private PessoaRepository pr;


	@GetMapping("/cliente")
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

	@GetMapping("/cliente/{id}")
	public @ResponseBody Optional<Cliente> retornaClientePorId(@PathVariable Integer id) {
		Optional<Cliente> cliente = cr.findById(id);
		return cliente;
	}

	@Transactional
	@RequestMapping(value = "/insertOrUpdadeCliente", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Cliente> retornaCliente(@RequestBody Cliente cliente){
		try {
			if(!cliente.getIdEndereco().equals("")&& !cliente.getNmPessoa().equals("") && !cliente.getNrCpf().equals("") && 
					!cliente.getNrTelefone().equals("")) {
				//busca um endereco com esse id
				Optional <Endereco> end = er.findById(cliente.getIdCliente());
				Pessoa p = new Pessoa();
				p.setEndereco(end.get());
				p.setNmPessoa(cliente.getNmPessoa());
				p.setNrcpf(cliente.getNrCpf());
				p.setNrtelefone(cliente.getNrTelefone());
				pr.save(p);
				pr.flush();
				Cliente cli = new Cliente();
				cli.setPessoa(p);
			} else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}