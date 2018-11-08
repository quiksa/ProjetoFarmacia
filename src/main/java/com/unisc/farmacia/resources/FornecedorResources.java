package com.unisc.farmacia.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.unisc.farmacia.model.Fornecedor;
import com.unisc.farmacia.repository.FornecedorRepository;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorResources {

	@Autowired
	private FornecedorRepository fr;

	@GetMapping("/load")
	public @ResponseBody Iterable<Fornecedor> listaFornecedores() {
		Iterable<Fornecedor> listaFornecedores = fr.findAll();
		return listaFornecedores;
	}

	@PostMapping()
	public Fornecedor insereFornecedor(@RequestBody Fornecedor fornecedor) {
		return fr.save(fornecedor);
	}

	@DeleteMapping
	public Fornecedor deletaFornecedor(@RequestBody Fornecedor fornecedor) {
		fr.delete(fornecedor);
		return fornecedor;
	}

}
