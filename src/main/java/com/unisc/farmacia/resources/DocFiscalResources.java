package com.unisc.farmacia.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unisc.farmacia.model.DocFiscal;
import com.unisc.farmacia.repository.DocFiscalRepository;

@RestController
@RequestMapping("/docfiscal")
public class DocFiscalResources {

	@Autowired
	private DocFiscalRepository cr;

//	@GetMapping("/docFiscal")
//	public @ResponseBody Iterable<DocFiscal> listaDocFiscal() {
//		Iterable<DocFiscal> listaDocFiscals = cr.findAll();
//		return listaDocFiscals;
//	}
	
	@RequestMapping(value = "/docfiscalsaida", method = RequestMethod.GET)
	public ResponseEntity<Iterable<DocFiscal>> loaddocfsicalsaida(@RequestParam(value = "idunidade", required = true, name = "idunidade") int idunidade) {
		try {
			Iterable<DocFiscal> listdocfiscalsaida = cr.getDocfiscalSaida(idunidade);
			return new ResponseEntity<Iterable<DocFiscal>>(listdocfiscalsaida,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

//	@PostMapping("/docFiscal")
//	public DocFiscal insereDocFiscal(@RequestBody DocFiscal docFiscal) {
//		return cr.save(docFiscal);
//	}
//
//	@DeleteMapping("/docFiscal")
//	public DocFiscal deletaDocFiscal(@RequestBody DocFiscal docFiscal) {
//		cr.delete(docFiscal);
//		return docFiscal;
//	}
//
//	// POR ITEM UNICO
//
//	@GetMapping("/docFiscal/{id}")
//	public @ResponseBody Optional<DocFiscal> retornaDocFiscalPorId(@PathVariable Integer id) {
//		Optional<DocFiscal> docfiscal = cr.findById(id);
//		return docfiscal;
//	}

}
