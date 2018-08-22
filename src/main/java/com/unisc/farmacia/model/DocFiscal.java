package com.unisc.farmacia.model;

public class DocFiscal {

	private int idDocFiscal;
	private Funcionario funcionario;
	private String dtRegistro;
	private double vlTotal;
	private String tpOperacao;
	private String status;
	private Cliente cliente;
	private String cnpjEmissor;
	private FormaPagamento formaPagamento;
	public int getIdDocFiscal() {
		return idDocFiscal;
	}
	public void setIdDocFiscal(int idDocFiscal) {
		this.idDocFiscal = idDocFiscal;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public String getDtRegistro() {
		return dtRegistro;
	}
	public void setDtRegistro(String dtRegistro) {
		this.dtRegistro = dtRegistro;
	}
	public double getVlTotal() {
		return vlTotal;
	}
	public void setVlTotal(double vlTotal) {
		this.vlTotal = vlTotal;
	}
	public String getTpOperacao() {
		return tpOperacao;
	}
	public void setTpOperacao(String tpOperacao) {
		this.tpOperacao = tpOperacao;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getCnpjEmissor() {
		return cnpjEmissor;
	}
	public void setCnpjEmissor(String cnpjEmissor) {
		this.cnpjEmissor = cnpjEmissor;
	}
	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	
	
	
	
}
