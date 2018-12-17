package com.unisc.farmacia.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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

	@Column(name = "dtvalidade")
	private LocalDate dtValidade;

	@Column(name = "qtmovimentoestoque")
	private int qtMovimentoEstoque;

	@Column(name = "dslote")
	private String dsLote;

	@OneToOne
	@JoinColumn(name = "idfuncionario")
	private Funcionario funcionario;

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

	public LocalDate getDtValidade() {
		return dtValidade;
	}

	public void setDtValidade(LocalDate dtValidade) {
		this.dtValidade = dtValidade;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}
