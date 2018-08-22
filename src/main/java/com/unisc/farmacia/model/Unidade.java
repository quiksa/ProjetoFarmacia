package com.unisc.farmacia.model;

public class Unidade {

	private int idUnidade;
	private String dsUnidade;
	private String nmUnidade;
	private String nmRduzido;
	private String cnpj;
	private Endereco endereco;
	private String dtRegistro;
	private String dtDesativacao;
	public int getIdUnidade() {
		return idUnidade;
	}
	public void setIdUnidade(int idUnidade) {
		this.idUnidade = idUnidade;
	}
	public String getDsUnidade() {
		return dsUnidade;
	}
	public void setDsUnidade(String dsUnidade) {
		this.dsUnidade = dsUnidade;
	}
	public String getNmUnidade() {
		return nmUnidade;
	}
	public void setNmUnidade(String nmUnidade) {
		this.nmUnidade = nmUnidade;
	}
	public String getNmRduzido() {
		return nmRduzido;
	}
	public void setNmRduzido(String nmRduzido) {
		this.nmRduzido = nmRduzido;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String getDtRegistro() {
		return dtRegistro;
	}
	public void setDtRegistro(String dtRegistro) {
		this.dtRegistro = dtRegistro;
	}
	public String getDtDesativacao() {
		return dtDesativacao;
	}
	public void setDtDesativacao(String dtDesativacao) {
		this.dtDesativacao = dtDesativacao;
	}
	
	
}
