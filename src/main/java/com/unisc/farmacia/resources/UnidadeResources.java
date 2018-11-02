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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.unisc.farmacia.model.Cidade;
import com.unisc.farmacia.model.Endereco;
import com.unisc.farmacia.model.Unidade;
import com.unisc.farmacia.repository.CidadeRepository;
import com.unisc.farmacia.repository.EnderecoRepository;
import com.unisc.farmacia.repository.UnidadeRepository;

@RestController
@RequestMapping("/unidade")
public class UnidadeResources {

	@Autowired
	private UnidadeRepository ur;
	@Autowired
	private EnderecoRepository er;
	@Autowired
	private CidadeRepository cr;

	@GetMapping(produces = "application/json")
	public @ResponseBody Iterable<Unidade> listaUnidades() {
		Iterable<Unidade> listaUnidades = ur.findAll();

		return listaUnidades;
	}

	@PostMapping()
	public Unidade insereUnidade(@RequestBody Unidade unidade) {
		return ur.save(unidade);

	}

	@Transactional
	@RequestMapping(value = "/insertOrUpdadeUnidade", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Unidade> retornaUnidade(@RequestBody Unidade unidade) {
		try {
			Unidade unid = new Unidade();
			if (!unidade.getCnpj().equals("") && !unidade.getNmBairro().equals("") && !unidade.getDsComplemento().equals("") && !unidade.getNmRua().equals("")) {
				Optional<Cidade> un = cr.findById(Integer.parseInt(unidade.getIdCidade()));
				Endereco end = new Endereco();
				end.setCidade(un.get());
				end.setBairro(unidade.getNmBairro());
				end.setDsComplemento(unidade.getDsComplemento());
				end.setNmRua(unidade.getNmRua());
				if(unidade.getIdendereco() != null) {
					end.setIdEndereco(Integer.parseInt(unidade.getIdendereco()));
				}
				er.save(end);
				er.flush();
				
				unid.setEndereco(end);
				unid.setCnpj(unidade.getCnpj());
				unid.setDsUnidade(unidade.getDsUnidade());
				unid.setNmUnidade(unidade.getNmUnidade());
				unid.setNmRduzido(unidade.getNmRduzido());
				if(!String.valueOf(unidade.getIdUnidade()).equals("0")) {
					unid.setIdUnidade(unidade.getIdUnidade());
				}
				ur.save(unid);
			} else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<>(unid, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/deletaUnidade", method = RequestMethod.GET)
	public ResponseEntity<Unidade> delUnidade(@RequestParam(value = "idunidade", required = true, name = "idunidade") int idunidade) {
		try {
			Optional<Unidade> unidade = ur.findById(idunidade);
			if (unidade.isPresent()) {
				ur.delete(unidade.get());
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping
	public Unidade deletaUnidade(@RequestBody Unidade unidade) {
		ur.delete(unidade);
		return unidade;
	}

}
