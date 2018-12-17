package com.unisc.farmacia.resources;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unisc.farmacia.model.Cliente;
import com.unisc.farmacia.model.DocFiscal;
import com.unisc.farmacia.model.DocFiscalItem;
import com.unisc.farmacia.model.FormaPagamento;
import com.unisc.farmacia.model.Fornecedor;
import com.unisc.farmacia.model.Funcionario;
import com.unisc.farmacia.model.Mercadoria;
import com.unisc.farmacia.model.MovimentoEstoque;
import com.unisc.farmacia.model.MovimentoMercadoria;
import com.unisc.farmacia.model.Unidade;
import com.unisc.farmacia.viewmodel.Compra;
import com.unisc.farmacia.viewmodel.MercadoriaCompra;
import com.unisc.farmacia.repository.ClienteRepository;
import com.unisc.farmacia.repository.DocFiscalItemRepository;
import com.unisc.farmacia.repository.DocFiscalRepository;
import com.unisc.farmacia.repository.FormaPagamentoRepository;
import com.unisc.farmacia.repository.FornecedorRepository;
import com.unisc.farmacia.repository.FuncionarioRepository;
import com.unisc.farmacia.repository.MercadoriaRepository;
import com.unisc.farmacia.repository.MovimentoEstoqueRepository;
import com.unisc.farmacia.repository.MovimentoMercadoriaRepository;
import com.unisc.farmacia.repository.UnidadeRepository;

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
	private UnidadeRepository ur;
	@Autowired
	private FornecedorRepository fr;
	@Autowired
	private FuncionarioRepository funcionarior;
	@Autowired
	private ClienteRepository cli;
	@Autowired
	private FormaPagamentoRepository fpg;
	@Autowired
	private DocFiscalRepository dfr;
	@Autowired
	private DocFiscalItemRepository dfir;

//	@GetMapping("/load")
//	public @ResponseBody Iterable<MovimentoMercadoria> listMovimentomercadoriaestoque() {
//		Iterable<MovimentoMercadoria> listaMovimentoMercadoriaEstoque = mmr.findAll();
//		return listaMovimentoMercadoriaEstoque;
//	}
	
	@RequestMapping(value = "/loadentrada", method = RequestMethod.GET)
	public ResponseEntity<Iterable<MovimentoMercadoria>> loadentrada(@RequestParam(value = "idunidade", required = true, name = "idunidade") int idunidade) {
		try {
			Iterable<MovimentoMercadoria> listaMovimentoMercadoriaEstoque = mmr.getEntradaEstoque(idunidade);
			return new ResponseEntity<Iterable<MovimentoMercadoria>>(listaMovimentoMercadoriaEstoque,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}

	@Transactional
	@RequestMapping(value = "/insertOrUpdadeMovimentoMercadoriaEstoque", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<MovimentoMercadoria> retornaMercadoria(@RequestBody MovimentoMercadoria movimentomercadoria) {
		try {
			if (!movimentomercadoria.getIdfornecedor().equals("")
					&& !movimentomercadoria.getVlMovimentoMercadoria().equals("")
					&& !movimentomercadoria.getIdunidade().equals("")
					&& !movimentomercadoria.getIdmercadoria().equals("")
					&& !movimentomercadoria.getDtvalidade().equals("")
					&& movimentomercadoria.getQtMovimentoMercadoria() > 0) {
				Optional<Mercadoria> mercadoria = mr.findById(Integer.parseInt(movimentomercadoria.getIdmercadoria()));
				Optional<Funcionario> funcionario = funcionarior.findById(Integer.parseInt(movimentomercadoria.getIdfuncionario()));
				movimentomercadoria.setMercadoria(mercadoria.get());
				Optional<Unidade> unidade = ur.findById(Integer.parseInt(movimentomercadoria.getIdunidade()));
				movimentomercadoria.setUnidade(unidade.get());
				Optional<Fornecedor> fornecedor = fr.findById(Integer.parseInt(movimentomercadoria.getIdfornecedor()));
				movimentomercadoria.setFornecedor(fornecedor.get());
				MovimentoEstoque me = new MovimentoEstoque();
				me.setDsLote(movimentomercadoria.getDslote());
				me.setQtMovimentoEstoque(movimentomercadoria.getQtMovimentoMercadoria());
				me.setTpMovimentoEstoque("EN");
				me.setIdMovimentoEstoque(movimentomercadoria.getIdmovimentoestoque());
				me.setDtValidade(LocalDate.parse(movimentomercadoria.getDtvalidade()));
				me.setFuncionario(funcionario.get());
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

	@RequestMapping(value = "/deleteMovimentacao", method = RequestMethod.GET)
	public ResponseEntity<MovimentoMercadoria> delMovimentacao(@RequestParam(value = "idMovimentoMercadoria", required = true, name = "idMovimentoMercadoria") int idMovimentoMercadoria) {
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

	public String calculaValor(Mercadoria m, MercadoriaCompra mc) {
		String valorFinal = new String();
		BigDecimal vl = new BigDecimal(m.getVlMercadoria());
		BigDecimal qt = new BigDecimal(mc.getQuantidade());
		valorFinal = String.valueOf(vl.multiply(qt).setScale(2,RoundingMode.DOWN));

		if (!mc.getDesconto().equals("") && !mc.getDesconto().equals("0")) {
			BigDecimal desc = new BigDecimal(mc.getDesconto());
			BigDecimal vlDesconto = vl.multiply(qt).multiply(desc.divide(new BigDecimal(100)));
			valorFinal = String.valueOf(vl.multiply(qt).subtract(vlDesconto));
		}
		return valorFinal;
	}

	@Transactional
	@RequestMapping(value = "/saveVenda", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<DocFiscal> retornaVenda(@RequestBody Compra compra) {
		try {
			if (compra.getIdCliente().equals("") || compra.getIdFormaPagamento().equals("")
					|| compra.getIdUnidade().equals("") || compra.getIdUsuario().equals("")) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			} else {
				Optional<Funcionario> func = funcionarior.findById(Integer.parseInt(compra.getIdUsuario()));
				Optional<Cliente> cl = cli.findById(Integer.parseInt(compra.getIdCliente()));
				Optional<FormaPagamento> fp = fpg.findById(Integer.parseInt(compra.getIdFormaPagamento()));
				Optional<Unidade> unidade = ur.findById(Integer.parseInt(compra.getIdUnidade()));
				if (!func.isPresent() || !cl.isPresent() || !fp.isPresent()) {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				} else {
					DocFiscal df = new DocFiscal();
					df.setFuncionario(func.get());
					df.setCliente(cl.get());
					df.setTpOperacao("SA");
					df.setStatus("A");
					df.setCnpjEmissor(unidade.get().getCnpj());
					df.setFormaPagamento(fp.get());
					df.setUnidade(unidade.get());
					dfr.save(df);
					
					BigDecimal somaTotal = new BigDecimal(0);
					for (MercadoriaCompra item : compra.getMercadoriacompra()) {
						BigDecimal soma = new BigDecimal(0);
						int qtEntrada = mmr.getQuantidadeEntrada(Integer.parseInt(item.getIdMercadoria()),
								Integer.parseInt(compra.getIdUnidade()));
						int qtSaida = mmr.getQuantidadeSaida(Integer.parseInt(item.getIdMercadoria()),
								Integer.parseInt(compra.getIdUnidade()));
						int qtdisponivel = qtEntrada - qtSaida;
						if (qtdisponivel < Integer.parseInt(item.getQuantidade())) {
							return new ResponseEntity<>(HttpStatus.NOT_FOUND);
						}

						Optional<Mercadoria> mercadoria = mr.findById(Integer.parseInt(item.getIdMercadoria()));
						MovimentoEstoque me = new MovimentoEstoque();
						me.setTpMovimentoEstoque("SA");
						me.setQtMovimentoEstoque(Integer.parseInt(item.getQuantidade()));
						me.setFuncionario(func.get());
						mer.save(me);

						MovimentoMercadoria mm = new MovimentoMercadoria();
						mm.setMercadoria(mercadoria.get());
						mm.setUnidade(unidade.get());
						mm.setQtMovimentoMercadoria(Integer.parseInt(item.getQuantidade()));
						mm.setMovimentoestoque(me);
						mm.setVlMovimentoMercadoria(this.calculaValor(mercadoria.get(), item));
						somaTotal = soma.add(new BigDecimal(mm.getVlMovimentoMercadoria()));
						mmr.save(mm);

						DocFiscalItem dfi = new DocFiscalItem();
						dfi.setDocFiscal(df);
						dfi.setVlItem(Double.parseDouble(mm.getVlMovimentoMercadoria()));
						dfi.setQuantidade(Integer.parseInt(item.getQuantidade()));
						dfi.setMercadoria(mercadoria.get());
						dfi.setVlDesconto(Double.parseDouble(item.getDesconto()));
						dfi.setMovimentomercadoria(mm);
						dfir.save(dfi);
					}
					df.setVlTotal(Double.parseDouble(somaTotal.toString()));
					dfr.save(df);
					
					return new ResponseEntity<DocFiscal>(df, HttpStatus.OK);
				}
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
