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
	private EnderecoRepository ery;
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
	@RequestMapping(value = "/insertOrUpdadeEstoque", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Estoque> retornaEstoque(@RequestBody Estoque estoque) {
		try {
			Estoque est = new Estoque();
			if (!estoque.getCnpj().equals("") && !estoque.getDsUnidade().equals("") && !estoque.getNmReduzido().equals("") &&
				!estoque.getNmUnidade().equals("") && !estoque.getCnpj().equals("") && !estoque.getIdEndereco().equals("") &&
				!estoque.getIdEndereco().equals("")) {
				Optional<Endereco> en = ery.findById(Integer.parseInt(estoque.getIdEndereco()));
				Unidade un = new Unidade();
				un.setCnpj(estoque.getCnpj());
				un.setDsUnidade(estoque.getDsUnidade());
				un.setNmRduzido(estoque.getNmReduzido());
				un.setNmUnidade(estoque.getNmUnidade());
				if(estoque.getIdEndereco()!=null) {
					un.setIdendereco(estoque.getIdEndereco());
				}
				ur.save(un);
				ur.flush();
				est.setUnidade(un);
				er.save(est);
				er.flush();
			} else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<>(est, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
