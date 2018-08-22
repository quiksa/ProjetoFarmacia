package com.unisc.farmacia.model;

public class Mercadoria {

	private int idMercadoria;
	private String nmMercadoria;
	private String dsComplemento;
	private Fornecedor fornecedor;
	private Categoria categoria;
	public int getIdMercadoria() {
		return idMercadoria;
	}
	public void setIdMercadoria(int idMercadoria) {
		this.idMercadoria = idMercadoria;
	}
	public String getNmMercadoria() {
		return nmMercadoria;
	}
	public void setNmMercadoria(String nmMercadoria) {
		this.nmMercadoria = nmMercadoria;
	}
	public String getDsComplemento() {
		return dsComplemento;
	}
	public void setDsComplemento(String dsComplemento) {
		this.dsComplemento = dsComplemento;
	}
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	
}
