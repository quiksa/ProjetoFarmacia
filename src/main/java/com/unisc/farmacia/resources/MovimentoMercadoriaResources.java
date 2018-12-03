package com.unisc.farmacia.resources;

import java.awt.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.unisc.farmacia.model.DocFiscal;
import com.unisc.farmacia.model.Estoque;
import com.unisc.farmacia.model.Fornecedor;
import com.unisc.farmacia.model.Mercadoria;
import com.unisc.farmacia.model.MovimentoEstoque;
import com.unisc.farmacia.model.MovimentoMercadoria;
import com.unisc.farmacia.repository.EstoqueRepository;
import com.unisc.farmacia.repository.FornecedorRepository;
import com.unisc.farmacia.repository.MercadoriaRepository;
import com.unisc.farmacia.repository.MovimentoEstoqueRepository;
import com.unisc.farmacia.repository.MovimentoMercadoriaRepository;

@RestController
@RequestMapping("/movimentomercadoriaestoque")
public class MovimentoMercadoriaResources {

	@Autowired
	private MovimentoMercadoriaRepository mmr;
	@Autowired
	private MovimentoEstoqueRepository mer;
	@Autowired
	private MercadoriaRepository mr;
	@Autowired
	private EstoqueRepository er;
	@Autowired
	private FornecedorRepository fr;

	@GetMapping("/load")
	public @ResponseBody Iterable<MovimentoMercadoria> listMovimentomercadoriaestoque() {
		Iterable<MovimentoMercadoria> listaMovimentoMercadoriaEstoque = mmr.findAll();
		return listaMovimentoMercadoriaEstoque;
	}

	@Transactional
	@RequestMapping(value = "/insertOrUpdadeMovimentoMercadoriaEstoque", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<MovimentoMercadoria> retornaMercadoria(@RequestBody MovimentoMercadoria movimentomercadoria) {
		try {
			if (!movimentomercadoria.getIdfornecedor().equals("")
					&& !movimentomercadoria.getVlMovimentoMercadoria().equals("")
					&& !movimentomercadoria.getIdestoque().equals("")
					&& !movimentomercadoria.getIdmercadoria().equals("")
					&& movimentomercadoria.getQtMovimentoMercadoria() > 0) {
				Optional<Mercadoria> mercadoria = mr.findById(Integer.parseInt(movimentomercadoria.getIdmercadoria()));
				movimentomercadoria.setMercadoria(mercadoria.get());
				Optional<Estoque> estoque = er.findById(Integer.parseInt(movimentomercadoria.getIdestoque()));
				movimentomercadoria.setEstoque(estoque.get());
				Optional<Fornecedor> fornecedor = fr.findById(Integer.parseInt(movimentomercadoria.getIdfornecedor()));
				movimentomercadoria.setFornecedor(fornecedor.get());
				MovimentoEstoque me = new MovimentoEstoque();
				me.setDsLote(movimentomercadoria.getDslote());
				me.setQtMovimentoEstoque(movimentomercadoria.getQtMovimentoMercadoria());
				me.setTpMovimentoEstoque("EN");
				me.setIdMovimentoEstoque(movimentomercadoria.getIdmovimentoestoque());
				mercadoria.get().setVlMercadoria(Float.parseFloat(movimentomercadoria.getVlMovimentoMercadoria()));
				mr.save(mercadoria.get());
				mer.save(me);
				mer.flush();
				movimentomercadoria.setMovimentoestoque(me);
				mmr.save(movimentomercadoria);
			} else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<MovimentoMercadoria>(movimentomercadoria, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@Transactional
	@RequestMapping(value = "/saveVenda", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<DocFiscal> retornaVenda(@RequestParam("listMercadorias") List listMercadorias,
			@RequestParam("idCliente") String idCliente, @RequestParam("idUsuario") String idUsuario) {
		try {
			if (idCliente.equals("")) {

			} else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<DocFiscal>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/deleteMovimentacao", method = RequestMethod.GET)
	public ResponseEntity<MovimentoMercadoria> delMovimentacao(
			@RequestParam(value = "idMovimentoMercadoria", required = true, name = "idMovimentoMercadoria") int idMovimentoMercadoria) {
		try {
			Optional<MovimentoMercadoria> movimentomercadoria = mmr.findById(idMovimentoMercadoria);
			if (movimentomercadoria.isPresent()) {
				mmr.delete(movimentomercadoria.get());
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
