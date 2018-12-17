package com.unisc.farmacia.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "docfiscal")
public class DocFiscal {

	@Id
	@Column(name = "iddocfiscal")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDocFiscal;

	@OneToOne
	@JoinColumn(name = "idfuncionario")
	private Funcionario funcionario;

	@Column(name = "vltotal")
	private double vlTotal;

	@Column(name = "tpoperacao")
	private String tpOperacao;

	@Column(name = "status")
	private String status;

	@OneToOne
	@JoinColumn(name = "idcliente")
	private Cliente cliente;

	@Column(name = "nrcnpjemissor")
	private String cnpjEmissor;

	@Column(name = "dhinsert")
	private LocalDateTime dhinsert;

	@OneToOne
	@JoinColumn(name = "idformapagamento")
	private FormaPagamento formaPagamento;

	@OneToOne
	@JoinColumn(name = "idunidade")
	private Unidade unidade;

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

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public LocalDateTime getDhinsert() {
		return dhinsert;
	}

}
