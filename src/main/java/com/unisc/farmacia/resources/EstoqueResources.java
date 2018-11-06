package com.unisc.farmacia.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.unisc.farmacia.model.Cidade;
import com.unisc.farmacia.model.Endereco;
import com.unisc.farmacia.model.Estoque;
import com.unisc.farmacia.model.Unidade;
import com.unisc.farmacia.repository.EnderecoRepository;
import com.unisc.farmacia.repository.EstoqueRepository;
import com.unisc.farmacia.repository.UnidadeRepository;

@RestController
@RequestMapping("/estoque")
public class EstoqueResources {

	@Autowired
	private EstoqueRepository er;
	@Autowired
	private UnidadeRepository ur;

	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Estoque> listaEstoques() {
		Iterable<Estoque> listaEstoques = er.findAll();

		return listaEstoques;
	}

	@PostMapping()
	public Estoque insereEstoque(@RequestBody Estoque estoque) {
		return er.save(estoque);
	}

	@DeleteMapping
	public Estoque deletaEstoque(@RequestBody Estoque estoque) {
		er.delete(estoque);
		return estoque;
	}


	@Transactional
	@RequestMapping(value = "/insertEstoque", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Estoque> retornaEstoque(@RequestBody Estoque estoque) {
		try {
			if(!estoque.getTransIdUnidade().equals("")) {
				Optional<Unidade> ou = ur.findById(Integer.parseInt(estoque.getTransIdUnidade()));
				if(ou.isPresent()) {
					Estoque e = new Estoque();
					e.setUnidade(ou.get());
					er.save(e);
				}else {
					return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
				}
			}else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(estoque, HttpStatus.OK);
	}
}
