package com.unisc.farmacia.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.unisc.farmacia.model.TipoPagamento;
import com.unisc.farmacia.repository.TipoPagamentoRepository;

@RestController
@RequestMapping("/tipoPagamento")
public class TipoPagamentoResources {
	
	@Autowired
	private TipoPagamentoRepository tpr;
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<TipoPagamento> listaTipoPagamentos() {
		Iterable<TipoPagamento> listaTipoPagamentos = tpr.findAll();
		return listaTipoPagamentos;
	}
	
	@PostMapping()
	public TipoPagamento insereTipoPagamento(@RequestBody TipoPagamento tipoPagamento) {
		return tpr.save(tipoPagamento);
	}
	
	@DeleteMapping
	public TipoPagamento deletaTipoPagamento(@RequestBody TipoPagamento tipoPagamento) {
		tpr.delete(tipoPagamento);
		return tipoPagamento;
	}

}
