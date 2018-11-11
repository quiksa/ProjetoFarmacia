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

import com.unisc.farmacia.model.Cidade;
import com.unisc.farmacia.model.Endereco;
import com.unisc.farmacia.model.Fornecedor;
import com.unisc.farmacia.model.Pessoa;
import com.unisc.farmacia.repository.CidadeRepository;
import com.unisc.farmacia.repository.EnderecoRepository;
import com.unisc.farmacia.repository.FornecedorRepository;
import com.unisc.farmacia.repository.PessoaRepository;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorResources {

	@Autowired
	private FornecedorRepository fr;
	@Autowired
	private CidadeRepository cidr;
	@Autowired
	private EnderecoRepository er;
	@Autowired
	private PessoaRepository pr;

	@GetMapping()
	public @ResponseBody Iterable<Fornecedor> listaFornecedores() {
		Iterable<Fornecedor> listaFornecedores = fr.findAll();
		return listaFornecedores;
	}

	@PostMapping()
	public Fornecedor insereFornecedor(@RequestBody Fornecedor fornecedor) {
		return fr.save(fornecedor);
	}

	@DeleteMapping
	public Fornecedor deletaFornecedor(@RequestBody Fornecedor fornecedor) {
		fr.delete(fornecedor);
		return fornecedor;
	}

	@Transactional
	@RequestMapping(value = "/insertOrUpdadeFornecedor", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Fornecedor> insertFornecedor(@RequestBody Fornecedor fornecedor) {
		try {
			if (!fornecedor.getNmPessoa().equals("") && !fornecedor.getBairro().equals("")
					&& !fornecedor.getDscomplemento().equals("") && !fornecedor.getEmail().equals("")
					&& !fornecedor.getIdcidade().equals("") && !fornecedor.getNmrua().equals("")
					&& !fornecedor.getCnpj().equals("") && !fornecedor.getNrtelefone().equals("")) {
				Optional<Cidade> cid = cidr.findById(Integer.parseInt(fornecedor.getIdcidade()));
				if (cid.isPresent()) {
					Endereco end = new Endereco();
					end.setBairro(fornecedor.getBairro());
					end.setCidade(cid.get());
					end.setDsComplemento(fornecedor.getDscomplemento());
					if (fornecedor.getIdendereco() != null) {
						end.setIdEndereco(Integer.parseInt(fornecedor.getIdendereco()));
					}
					end.setNmRua(fornecedor.getNmrua());
					er.save(end);
					er.flush();
					Pessoa p = new Pessoa();
					if (fornecedor.getIdpessoa() != null) {
						p.setIdPessoa(Integer.parseInt(fornecedor.getIdpessoa()));
					}
					p.setEndereco(end);
					p.setNmPessoa(fornecedor.getNmPessoa());
					p.setNrtelefone(fornecedor.getNrtelefone());
					p.setEmail(fornecedor.getEmail());
					pr.save(p);
					pr.flush();
					fornecedor.setPessoa(p);
					fr.save(fornecedor);
					return new ResponseEntity<Fornecedor>(fornecedor, HttpStatus.OK);
				} else {
					return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
				}
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return null;
	}
	
	@Transactional
	@RequestMapping(value = "/deleteFornecedor", method = RequestMethod.GET)
	public ResponseEntity<Fornecedor> delfornecedor(
			@RequestParam(value = "idFornecedor", required = true, name = "idFornecedor") int idFornecedor) {
		try {
			Optional<Fornecedor> fornecedor = fr.findById(idFornecedor);
			if (fornecedor.isPresent()) {
				fr.delete(fornecedor.get());
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

}
