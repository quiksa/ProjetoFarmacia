package com.unisc.farmacia.model;

public class EstoqueItem {
	
	private int idEstoqueItem;
	private String dtFabricacao;
	private String dtValidade;
	private int quantidade;
	private double vlCompra;
	private String dsLote;
	private Mercadoria mercadoria;
	private Estoque estoque;
	private double vlVenda;
	public int getIdEstoqueItem() {
		return idEstoqueItem;
	}
	public void setIdEstoqueItem(int idEstoqueItem) {
		this.idEstoqueItem = idEstoqueItem;
	}
	public String getDtFabricacao() {
		return dtFabricacao;
	}
	public void setDtFabricacao(String dtFabricacao) {
		this.dtFabricacao = dtFabricacao;
	}
	public String getDtValidade() {
		return dtValidade;
	}
	public void setDtValidade(String dtValidade) {
		this.dtValidade = dtValidade;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getVlCompra() {
		return vlCompra;
	}
	public void setVlCompra(double vlCompra) {
		this.vlCompra = vlCompra;
	}
	public String getDsLote() {
		return dsLote;
	}
	public void setDsLote(String dsLote) {
		this.dsLote = dsLote;
	}
	public Mercadoria getMercadoria() {
		return mercadoria;
	}
	public void setMercadoria(Mercadoria mercadoria) {
		this.mercadoria = mercadoria;
	}
	public Estoque getEstoque() {
		return estoque;
	}
	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}
	public double getVlVenda() {
		return vlVenda;
	}
	public void setVlVenda(double vlVenda) {
		this.vlVenda = vlVenda;
	}
	
	

}
