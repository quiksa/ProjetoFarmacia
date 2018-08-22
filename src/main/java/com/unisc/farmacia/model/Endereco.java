package com.unisc.farmacia.model;

public class Endereco {

	private int idEndereco;
	private String nmRua;
	private String dsComplemento;
	private String bairro;
	private Cidade cidade;
	public int getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}
	public String getNmRua() {
		return nmRua;
	}
	public void setNmRua(String nmRua) {
		this.nmRua = nmRua;
	}
	public String getDsComplemento() {
		return dsComplemento;
	}
	public void setDsComplemento(String dsComplemento) {
		this.dsComplemento = dsComplemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	

	
	
}
