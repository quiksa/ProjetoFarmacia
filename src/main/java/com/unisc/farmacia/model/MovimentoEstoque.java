package com.unisc.farmacia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movimentoestoque")
public class MovimentoEstoque {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idmovimentoestoque")
	private int idMovimentoEstoque;

	@Column(name = "tpmovimentoestoque")
	private String tpMovimentoEstoque;

	@Column(name = "qtmovimentoestoque")
	private int qtMovimentoEstoque;

	@Column(name = "dslote")
	private String dsLote;

	public int getIdMovimentoEstoque() {
		return idMovimentoEstoque;
	}

	public void setIdMovimentoEstoque(int idMovimentoEstoque) {
		this.idMovimentoEstoque = idMovimentoEstoque;
	}

	public String getTpMovimentoEstoque() {
		return tpMovimentoEstoque;
	}

	public void setTpMovimentoEstoque(String tpMovimentoEstoque) {
		this.tpMovimentoEstoque = tpMovimentoEstoque;
	}

	public String getDsLote() {
		return dsLote;
	}

	public void setDsLote(String dsLote) {
		this.dsLote = dsLote;
	}

	public int getQtMovimentoEstoque() {
		return qtMovimentoEstoque;
	}

	public void setQtMovimentoEstoque(int qtMovimentoEstoque) {
		this.qtMovimentoEstoque = qtMovimentoEstoque;
	}

}
