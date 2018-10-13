package com.unisc.farmacia.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.unisc.farmacia.model.Cliente;
import com.unisc.farmacia.repository.ClienteRepository;

@RestController
public class ClienteResources {

	@Autowired
	private ClienteRepository cr;
	
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
	
}