package com.unisc.farmacia.resources;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.unisc.farmacia.model.FormaPagamento;
import com.unisc.farmacia.repository.FormaPagamentoRepository;

@RestController
@RequestMapping("/formapagamento")
public class FormaPagamentoResources {

	@Autowired
	private FormaPagamentoRepository cr;

	@GetMapping("/load")
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

	@RequestMapping(value = "/insertOrUpdateFormaPagamento", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<FormaPagamento> insertFormaPagamento(@RequestBody FormaPagamento formapagamento) {
		try {
			if (!formapagamento.getDsFormaPagamento().equals("") && !formapagamento.getDsTipoPagamento().equals("")) {
				cr.save(formapagamento);
			} else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<FormaPagamento>(formapagamento, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@Transactional
	@RequestMapping(value = "/deleteFormaPagamento", method = RequestMethod.GET)
	public ResponseEntity<FormaPagamento> delFormaPagamento(
			@RequestParam(value = "idFormaPagamento", required = true, name = "idFormaPagamento") int idFormaPagamento) {
		try {
			Optional<FormaPagamento> formapagamento = cr.findById(idFormaPagamento);
			if (formapagamento.isPresent()) {
				cr.delete(formapagamento.get());
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
}
