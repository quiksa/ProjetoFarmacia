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
			if (!unidade.getCnpj().equals("") && !unidade.getNmBairro().equals("")
					&& !unidade.getDsComplemento().equals("") && !unidade.getNmRua().equals("")) {
				//faz busca de uma cidade com argumento passado pelo front
				Optional<Cidade> un = cr.findById(Integer.parseInt(unidade.getIdCidade()));
				Endereco end = new Endereco();
				end.setCidade(un.get());
				end.setBairro(unidade.getNmBairro());
				end.setDsComplemento(unidade.getDsComplemento());
				end.setNmRua(unidade.getNmRua());
				er.save(end);
				er.flush();
				Unidade unid = new Unidade();
				unid.setEndereco(end);
				unid.setCnpj(unidade.getCnpj());
				unid.setDsUnidade(unidade.getDsUnidade());
				unid.setNmUnidade(unidade.getNmUnidade());
				unid.setNmRduzido(unidade.getNmRduzido());
				ur.save(unid);
			} else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
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
