package com.unisc.farmacia.model;

public class DocFiscalItem {

	private int idDocFiscalItem;
	private DocFiscal docFiscal;
	private double vlItem;
	private int quantidade;
	private Mercadoria mercadoria;
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
		
}
