package com.unisc.farmacia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name= "tipopagamento")
public class TipoPagamento {

	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idtipopagamento")
	private int idTipoPagamento;
	
	@Column(name="dscomplemento")
	private String dsComplemento;
	
	
	public int getIdTipoPagamento() {
		return idTipoPagamento;
	}
	public void setIdTipoPagamento(int idTipoPagamento) {
		this.idTipoPagamento = idTipoPagamento;
	}
	public String getDsComplemento() {
		return dsComplemento;
	}
	public void setDsComplemento(String dsComplemento) {
		this.dsComplemento = dsComplemento;
	}
	
	
	
}
