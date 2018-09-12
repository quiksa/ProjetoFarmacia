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

import com.unisc.farmacia.model.DocFiscal;
import com.unisc.farmacia.repository.DocFiscalRepository;

@RestController
public class DocFiscalResources {

	@Autowired
	private DocFiscalRepository cr;

	@GetMapping("/docFiscal")
	public @ResponseBody Iterable<DocFiscal> listaDocFiscal() {
		Iterable<DocFiscal> listaDocFiscals = cr.findAll();
		return listaDocFiscals;
	}

	@PostMapping("/docFiscal")
	public DocFiscal insereDocFiscal(@RequestBody DocFiscal docFiscal) {
		return cr.save(docFiscal);
	}

	@DeleteMapping("/docFiscal")
	public DocFiscal deletaDocFiscal(@RequestBody DocFiscal docFiscal) {
		cr.delete(docFiscal);
		return docFiscal;
	}

	// POR ITEM UNICO

	@GetMapping("/docFiscal/{id}")
	public @ResponseBody Optional<DocFiscal> retornaDocFiscalPorId(@PathVariable Integer id) {
		Optional<DocFiscal> docfiscal = cr.findById(id);
		return docfiscal;
	}

}
