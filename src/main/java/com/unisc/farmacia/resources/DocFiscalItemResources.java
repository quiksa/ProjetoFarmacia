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

import com.unisc.farmacia.model.DocFiscalItem;
import com.unisc.farmacia.repository.DocFiscalItemRepository;

@RestController
public class DocFiscalItemResources {

	@Autowired
	private DocFiscalItemRepository cr;

	@GetMapping("/docFiscalItem")
	public @ResponseBody Iterable<DocFiscalItem> listaDocFiscalItems() {
		Iterable<DocFiscalItem> listaDocFiscalItems = cr.findAll();

		return listaDocFiscalItems;
	}

	@PostMapping("/docFiscalItem")
	public DocFiscalItem insereDocFiscalItem(@RequestBody DocFiscalItem docFiscaItem) {
		return cr.save(docFiscaItem);
	}

	@DeleteMapping("/docFiscalItem")
	public DocFiscalItem deletaDocFiscalItem(@RequestBody DocFiscalItem docFiscaItem) {
		cr.delete(docFiscaItem);
		return docFiscaItem;
	}

	// POR ITEM UNICO

	@GetMapping("/docFiscalItem/{id}")
	public @ResponseBody Optional<DocFiscalItem> retornaDocFiscalItemPorId(@PathVariable Integer id) {
		Optional<DocFiscalItem> docFiscalItem = cr.findById(id);
		return docFiscalItem;
	}

}
