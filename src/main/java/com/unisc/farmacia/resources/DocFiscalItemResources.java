package com.unisc.farmacia.resources;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.unisc.farmacia.model.Categoria;
import com.unisc.farmacia.model.Cliente;
import com.unisc.farmacia.model.DocFiscal;
import com.unisc.farmacia.model.DocFiscalItem;
import com.unisc.farmacia.model.FormaPagamento;
import com.unisc.farmacia.model.Funcionario;
import com.unisc.farmacia.model.Mercadoria;
import com.unisc.farmacia.repository.CategoriaRepository;
import com.unisc.farmacia.repository.ClienteRepository;
import com.unisc.farmacia.repository.DocFiscalItemRepository;
import com.unisc.farmacia.repository.DocFiscalRepository;
import com.unisc.farmacia.repository.FormaPagamentoRepository;
import com.unisc.farmacia.repository.FuncionarioRepository;
import com.unisc.farmacia.repository.MercadoriaRepository;

@RestController
public class DocFiscalItemResources {

	@Autowired
	private DocFiscalItemRepository dfir;

	@Autowired
	private CategoriaRepository cr;

	@Autowired
	private ClienteRepository cr2;

	@Autowired
	private FormaPagamentoRepository fpr;

	@Autowired
	private FuncionarioRepository fr2;

	@Autowired
	private MercadoriaRepository mr;

	@Autowired
	private DocFiscalRepository dfr;

	@GetMapping("/docFiscalItem")
	public @ResponseBody Iterable<DocFiscalItem> listaDocFiscalItems() {
		Iterable<DocFiscalItem> listaDocFiscalItems = dfir.findAll();

		return listaDocFiscalItems;
	}

	@PostMapping("/docFiscalItem")
	public DocFiscalItem insereDocFiscalItem(@RequestBody DocFiscalItem docFiscaItem) {
		return dfir.save(docFiscaItem);
	}

	@DeleteMapping("/docFiscalItem")
	public DocFiscalItem deletaDocFiscalItem(@RequestBody DocFiscalItem docFiscaItem) {
		dfir.delete(docFiscaItem);
		return docFiscaItem;
	}

	// POR ITEM UNICO

	@GetMapping("/docFiscalItem/{id}")
	public @ResponseBody Optional<DocFiscalItem> retornaDocFiscalItemPorId(@PathVariable Integer id) {
		Optional<DocFiscalItem> docFiscalItem = dfir.findById(id);
		return docFiscalItem;
	}

	@Transactional
	@RequestMapping(value = "/insertDocFiscalItem", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<DocFiscalItem> retornaDocFiscalItem(@RequestBody DocFiscalItem docFiscalItem){
		try {
			DocFiscalItem dfi = new DocFiscalItem();
			Double vlItem = dfi.getVlItem();
			Double vlDesconto = dfi.getVlDesconto();
			if(!dfi.getTransIdDocFiscal().equals("") && !dfi.getTransIdMercadoria().equals("") && vlItem!=null 
					&& vlDesconto!=null) {
				Optional<Categoria> cat = cr.findById(Integer.parseInt(dfi.getTransIdCategoria()));
				Optional<Cliente> cli = cr2.findById(Integer.parseInt(dfi.getTransIdCliente()));
				Optional<FormaPagamento> fp = fpr.findById(Integer.parseInt(dfi.getTransIdFormaPagamento()));
				Optional<Funcionario>func= fr2.findById(Integer.parseInt(dfi.getTransIdFuncionario()));
				Mercadoria m = new Mercadoria();
				m.setDsComplemento(dfi.getTransDsComplementoMercadoria());
				m.setNmMercadoria(dfi.getTransNmMercadoria());
				m.setIdMercadoria(Integer.parseInt(dfi.getTransIdMercadoria()));
				m.setCategoria(cat.get());
				//m.setFornecedor(forn.get());
				mr.save(m);
				mr.flush();
				DocFiscal df = new DocFiscal();
				df.setCliente(cli.get());
				df.setCnpjEmissor(dfi.getTransCNPJEmissor());
				df.setStatus(dfi.getTransStatus());
				df.setTpOperacao(dfi.getTransTpOperacao());
				df.setFormaPagamento(fp.get());
				df.setFuncionario((func.get()));
				df.setVlTotal(Double.parseDouble(dfi.getTransVltotal()));
				dfr.save(df);
				dfr.flush();
				dfi.setMercadoria(m);
				dfi.setDocFiscal(df);
				dfir.save(dfi);
				dfir.flush();						
				return new ResponseEntity<>(HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(docFiscalItem,HttpStatus.BAD_REQUEST);
		}
	}


}
