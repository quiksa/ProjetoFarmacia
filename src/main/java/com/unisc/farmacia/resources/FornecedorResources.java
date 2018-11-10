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

	@GetMapping("/load")
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
			if (!fornecedor.getPessoa().getNmPessoa().equals("") && !fornecedor.getEndereco().getBairro().equals("")
					&& !fornecedor.getEndereco().getDsComplemento().equals("")
					&& !fornecedor.getPessoa().getEmail().equals("") && !fornecedor.getIdcidade().equals("")
					&& !fornecedor.getNmrua().equals("") && !fornecedor.getCnpj().equals("")
					&& !fornecedor.getPessoa().getNrtelefone().equals("")) {
				Optional<Cidade> cid = cidr.findById(Integer.parseInt(fornecedor.getIdcidade()));
				if (cid.isPresent()) {
					Endereco end = new Endereco();
					end.setBairro(fornecedor.getEndereco().getBairro());
					end.setCidade(cid.get());
					end.setDsComplemento(fornecedor.getEndereco().getDsComplemento());
					end.setIdEndereco(fornecedor.getEndereco().getIdEndereco());
					end.setNmRua(fornecedor.getNmrua());
					er.save(end);
					er.flush();
					Pessoa p = new Pessoa();
					p.setIdPessoa(fornecedor.getPessoa().getIdPessoa());
					p.setEndereco(end);
					p.setNmPessoa(fornecedor.getPessoa().getNmPessoa());
					p.setNrtelefone(fornecedor.getPessoa().getNrtelefone());
					p.setEmail(fornecedor.getPessoa().getEmail());
					pr.save(p);
					pr.flush();
					fornecedor.setPessoa(p);
					fornecedor.setEndereco(end);
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

}
