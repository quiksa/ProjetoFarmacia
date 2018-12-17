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

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "docfiscalitem")
public class DocFiscalItem {

	@Id
	@Column(name = "iddocfiscalitem")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDocFiscalItem;

	@ManyToOne
	@JoinColumn(name = "iddocfiscal")
	@JsonBackReference
	private DocFiscal docFiscal;

	@OneToOne
	@JoinColumn(name = "idmovimentomercadoria")
	private MovimentoMercadoria movimentomercadoria;

	@Column(name = "vlitem")
	private double vlItem;

	@Column(name = "quantidade")
	private int quantidade;

	@OneToOne
	@JoinColumn(name = "idmercadoria")
	private Mercadoria mercadoria;

	@Column(name = "vldesconto")
	private double vlDesconto;

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

	public MovimentoMercadoria getMovimentomercadoria() {
		return movimentomercadoria;
	}

	public void setMovimentomercadoria(MovimentoMercadoria movimentomercadoria) {
		this.movimentomercadoria = movimentomercadoria;
	}

}
