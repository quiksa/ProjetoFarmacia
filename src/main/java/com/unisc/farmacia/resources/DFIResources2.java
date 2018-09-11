package com.unisc.farmacia.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.unisc.farmacia.model.DocFiscalItem;
import com.unisc.farmacia.repository.DocFiscalItemRepository;

@RestController
@RequestMapping("/docFiscalItem")
public class DFIResources2 {

	@Autowired
	private DocFiscalItemRepository cr;
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<DocFiscalItem> listaDocFiscalItems() {
		Iterable<DocFiscalItem> listaDocFiscalItems = cr.findAll();
		
		return listaDocFiscalItems;
	}
	
	@PostMapping()
	public DocFiscalItem insereDocFiscalItem(@RequestBody DocFiscalItem docFiscaItem) {
		return cr.save(docFiscaItem);
	}
	
	@DeleteMapping
	public DocFiscalItem deletaDocFiscalItem(@RequestBody DocFiscalItem docFiscaItem) {
		cr.delete(docFiscaItem);
		return docFiscaItem;
	}
	
}
