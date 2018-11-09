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

import com.unisc.farmacia.model.Categoria;
import com.unisc.farmacia.model.Cidade;
import com.unisc.farmacia.model.Endereco;
import com.unisc.farmacia.model.Fornecedor;
import com.unisc.farmacia.model.Mercadoria;
import com.unisc.farmacia.repository.CategoriaRepository;
import com.unisc.farmacia.repository.CidadeRepository;
import com.unisc.farmacia.repository.EnderecoRepository;
import com.unisc.farmacia.repository.FornecedorRepository;
import com.unisc.farmacia.repository.MercadoriaRepository;

@RestController
@RequestMapping("/mercadoria")
public class MercadoriaResources {

	@Autowired
	private MercadoriaRepository mr;
	@Autowired
	private EnderecoRepository er;
	@Autowired
	private FornecedorRepository fr;
	@Autowired
	private CategoriaRepository cr;

	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Mercadoria> listaMercadorias() {
		Iterable<Mercadoria> listaMercadorias = mr.findAll();

		return listaMercadorias;
	}

	@PostMapping()
	public Mercadoria insereMercadoria(@RequestBody Mercadoria mercadoria) {
		return mr.save(mercadoria);
	}

	@DeleteMapping
	public Mercadoria deletaMercadoria(@RequestBody Mercadoria mercadoria) {
		mr.delete(mercadoria);
		return mercadoria;
	}

	@Transactional
	@RequestMapping(value = "/insertMercadoria", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Mercadoria> retornaMercadoria(@RequestBody Mercadoria mercadoria) {	
		try {
			if(!mercadoria.getNmMercadoria().equals("") && !mercadoria.getDsComplemento().equals("") && 
					!mercadoria.getTcnpjFornec().equals("") && !mercadoria.gettDsCategoria().equals("") && 
					!mercadoria.gettDsFornecedor().equals("") && !mercadoria.gettIdEnderecoFornecedor().equals("")){
				Optional<Endereco> en = er.findById(Integer.parseInt(mercadoria.gettIdEnderecoFornecedor()));
				if(en.isPresent()) {
					Fornecedor f = new Fornecedor();
					f.setCnpj(mercadoria.getTcnpjFornec());
					f.setEndereco(en.get());
					f.setDsFornecedor(mercadoria.gettDsFornecedor());
					fr.save(f);
					fr.flush();
					Categoria c = new Categoria();
					c.setDsCategoria(mercadoria.gettDsCategoria());
					cr.save(c);
					cr.flush();
					Mercadoria m = new Mercadoria();
					m.setCategoria(c);
					m.setFornecedor(f);
					m.setDsComplemento(mercadoria.getDsComplemento());
					m.setNmMercadoria(mercadoria.getNmMercadoria());
					mr.save(m);
					mr.flush();				
				}else {
					return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
				}

			}else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<>(mercadoria, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}


	}
}
