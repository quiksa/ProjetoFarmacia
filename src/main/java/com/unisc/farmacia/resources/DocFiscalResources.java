package com.unisc.farmacia.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.unisc.farmacia.model.DocFiscal;
import com.unisc.farmacia.repository.DocFiscalRepository;

@RestController
@RequestMapping("/docFiscal")
public class DocFiscalResources {

	@Autowired
	private DocFiscalRepository cr;
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<DocFiscal> listaDocFiscal() {
		Iterable<DocFiscal> listaDocFiscals = cr.findAll();	
		return listaDocFiscals;
	}
	
	@PostMapping()
	public DocFiscal insereDocFiscal(@RequestBody DocFiscal docFiscal) {
		return cr.save(docFiscal);
	}
	
	@DeleteMapping
	public DocFiscal deletaDocFiscal(@RequestBody DocFiscal docFiscal) {
		cr.delete(docFiscal);
		return docFiscal;
	}
	
}
