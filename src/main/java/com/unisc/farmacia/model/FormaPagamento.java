package com.unisc.farmacia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="formapagamento")
public class FormaPagamento {
	
	
	@Id
	@Column(name="idformapagamento")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idFormaPagamento;
	
	@Column(name="dsformapagamento")
	private String dsFormaPagamento;
	
	@OneToOne
	@JoinColumn(name="idtipopagamento")
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
