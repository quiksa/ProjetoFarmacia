package com.unisc.farmacia.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.unisc.farmacia.model.FormaPagamento;
import com.unisc.farmacia.repository.FormaPagamentoRepository;

@RestController
@RequestMapping("/formaPagamento")
public class FormaPagamentoResources {

	@Autowired
	private FormaPagamentoRepository cr;
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<FormaPagamento> listaFormaPagamentos() {
		Iterable<FormaPagamento> listaFormaPagamentos = cr.findAll();
		
		return listaFormaPagamentos;
	}
	
	@PostMapping()
	public FormaPagamento insereFormaPagamento(@RequestBody FormaPagamento formaPagamento) {
		return cr.save(formaPagamento);
	}
	
	@DeleteMapping
	public FormaPagamento deletaFormaPagamento(@RequestBody FormaPagamento formaPagamento) {
		cr.delete(formaPagamento);
		return formaPagamento;
	}
	
}
