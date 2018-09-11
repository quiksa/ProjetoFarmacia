package com.unisc.farmacia.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.unisc.farmacia.model.Cliente;
import com.unisc.farmacia.repository.ClienteRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteResources {

	@Autowired
	private ClienteRepository cr;
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Cliente> listaClientes() {
		Iterable<Cliente> listaClientes = cr.findAll();
		
		return listaClientes;
	}
	/*
	public @ResponseBody Optional<Cliente> exibeCliente(int id){
		Optional<Cliente> cliente = cr.findById(id);
		return cliente;
	}
	*/
	
	@PostMapping()
	public Cliente insereCliente(@RequestBody Cliente cliente) {
		return cr.save(cliente);
	}
	
	@DeleteMapping
	public Cliente deletaCliente(@RequestBody Cliente cliente) {
		cr.delete(cliente);
		return cliente;
	}
	
}
