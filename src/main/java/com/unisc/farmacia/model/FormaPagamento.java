package com.unisc.farmacia.model;

public class FormaPagamento {
	
	private int idFormaPagamento;
	private String dsFormaPagamento;
	private TipoPagamento tipoPagamento;
	public int getIdFormaPagamento() {
		return idFormaPagamento;
	}
	public void setIdFormaPagamento(int idFormaPagamento) {
		this.idFormaPagamento = idFormaPagamento;
	}
	public String getDsFormaPagamento() {
		return dsFormaPagamento;
	}
	public void setDsFormaPagamento(String dsFormaPagamento) {
		this.dsFormaPagamento = dsFormaPagamento;
	}
	public TipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}
	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
	
	

}
