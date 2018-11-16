package com.unisc.farmacia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="docfiscalitem")
public class DocFiscalItem {
	
	@Id
	@Column(name="iddocfiscalitem")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDocFiscalItem;
	
	@ManyToOne 
	@JoinColumn(name="iddocfiscal")
	@JsonBackReference
	private DocFiscal docFiscal;
	
	@Column(name="vlitem")
	private double vlItem;
	
	@Column(name="quantidade")
	private int quantidade;
	
	@OneToOne
	@JoinColumn(name="idmercadoria")
	private Mercadoria mercadoria;
	
	@Column(name="vldesconto")
	private double vlDesconto;
	
	
	
	//DOCFISCAL TRANSIENTS
	
	@Transient
	private String transIdFuncionario;
	
	@Transient
	private String transIdDocFiscal;
		
	@Transient
	private String transDtRegistro;
	
	@Transient
	private String transVltotal;
	
	@Transient
	private String transTpOperacao;
	
	@Transient
	private String transStatus;
	
	@Transient
	private String  transIdCliente;
	
	@Transient
	private String transCNPJEmissor;
	
	@Transient 
	private String transIdFormaPagamento;
	
	
	
	//MERCADORIA TRANSIENTS

	@Transient
	private String transIdMercadoria;
	
	@Transient
	private String transIdFornecedor;
	
	@Transient
	private String transIdCategoria;
	
	@Transient
	private String transNmMercadoria;
	
	@Transient
	private String transDsComplementoMercadoria;
	
	
	
	public String getTransIdFuncionario() {
		return transIdFuncionario;
	}
	public void setTransIdFuncionario(String transIdFuncionario) {
		this.transIdFuncionario = transIdFuncionario;
	}
	public String getTransIdDocFiscal() {
		return transIdDocFiscal;
	}
	public void setTransIdDocFiscal(String transIdDocFiscal) {
		this.transIdDocFiscal = transIdDocFiscal;
	}
	public String getTransDtRegistro() {
		return transDtRegistro;
	}
	public void setTransDtRegistro(String transDtRegistro) {
		this.transDtRegistro = transDtRegistro;
	}
	public String getTransVltotal() {
		return transVltotal;
	}
	public void setTransVltotal(String transVltotal) {
		this.transVltotal = transVltotal;
	}
	public String getTransTpOperacao() {
		return transTpOperacao;
	}
	public void setTransTpOperacao(String transTpOperacao) {
		this.transTpOperacao = transTpOperacao;
	}
	public String getTransStatus() {
		return transStatus;
	}
	public void setTransStatus(String transStatus) {
		this.transStatus = transStatus;
	}
	public String getTransIdCliente() {
		return transIdCliente;
	}
	public void setTransIdCliente(String transIdCliente) {
		this.transIdCliente = transIdCliente;
	}
	public String getTransCNPJEmissor() {
		return transCNPJEmissor;
	}
	public void setTransCNPJEmissor(String transCNPJEmissor) {
		this.transCNPJEmissor = transCNPJEmissor;
	}
	public String getTransIdFormaPagamento() {
		return transIdFormaPagamento;
	}
	public void setTransIdFormaPagamento(String transIdFormaPagamento) {
		this.transIdFormaPagamento = transIdFormaPagamento;
	}
	public String getTransIdMercadoria() {
		return transIdMercadoria;
	}
	public void setTransIdMercadoria(String transIdMercadoria) {
		this.transIdMercadoria = transIdMercadoria;
	}
	public String getTransIdFornecedor() {
		return transIdFornecedor;
	}
	public void setTransIdFornecedor(String transIdFornecedor) {
		this.transIdFornecedor = transIdFornecedor;
	}
	public String getTransIdCategoria() {
		return transIdCategoria;
	}
	public void setTransIdCategoria(String transIdCategoria) {
		this.transIdCategoria = transIdCategoria;
	}
	public String getTransNmMercadoria() {
		return transNmMercadoria;
	}
	public void setTransNmMercadoria(String transNmMercadoria) {
		this.transNmMercadoria = transNmMercadoria;
	}
	public String getTransDsComplementoMercadoria() {
		return transDsComplementoMercadoria;
	}
	public void setTransDsComplementoMercadoria(String transDsComplementoMercadoria) {
		this.transDsComplementoMercadoria = transDsComplementoMercadoria;
	}
	
	public int getIdDocFiscalItem() {
		return idDocFiscalItem;
	}
	public void setIdDocFiscalItem(int idDocFiscalItem) {
		this.idDocFiscalItem = idDocFiscalItem;
	}
	public DocFiscal getDocFiscal() {
		return docFiscal;
	}
	public void setDocFiscal(DocFiscal docFiscal) {
		this.docFiscal = docFiscal;
	}
	public double getVlItem() {
		return vlItem;
	}
	public void setVlItem(double vlItem) {
		this.vlItem = vlItem;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Mercadoria getMercadoria() {
		return mercadoria;
	}
	public void setMercadoria(Mercadoria mercadoria) {
		this.mercadoria = mercadoria;
	}
	public double getVlDesconto() {
		return vlDesconto;
	}
	public void setVlDesconto(double vlDesconto) {
		this.vlDesconto = vlDesconto;
	}
		
}
