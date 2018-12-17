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
import com.unisc.farmacia.model.Mercadoria;
import com.unisc.farmacia.repository.CategoriaRepository;
import com.unisc.farmacia.repository.MercadoriaRepository;

@RestController
@RequestMapping("/mercadoria")
public class MercadoriaResources {

	@Autowired
	private MercadoriaRepository mr;
	@Autowired
	private CategoriaRepository cr;

	@GetMapping("/load")
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
	@RequestMapping(value = "/insertOrUpdadeMercadoria", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Mercadoria> retornaMercadoria(@RequestBody Mercadoria mercadoria) {
		try {
			if (mercadoria.getCodBarra() > 0 && !mercadoria.getNmMercadoria().equals("")
					&& mercadoria.getVlMercadoria() > 0 && !mercadoria.getDsComplemento().equals("")
					&& !mercadoria.getIdcategoria().equals("") && !mercadoria.getIdunidade().equals("")) {
				Optional<Categoria> categoria = cr.findById(Integer.parseInt(mercadoria.getIdcategoria()));
				mercadoria.setCategoria(categoria.get());
				mr.save(mercadoria);
			} else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<Mercadoria>(mercadoria, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
