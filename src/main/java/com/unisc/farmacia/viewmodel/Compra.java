package com.unisc.farmacia.viewmodel;

import java.util.ArrayList;
import java.util.List;

public class Compra {

	private String idCliente;

	private String idFormaPagamento;

	private String idUnidade;

	private String idUsuario;

	private List<MercadoriaCompra> mercadoriacompra = new ArrayList<MercadoriaCompra>();

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getIdFormaPagamento() {
		return idFormaPagamento;
	}

	public void setIdFormaPagamento(String idFormaPagamento) {
		this.idFormaPagamento = idFormaPagamento;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public List<MercadoriaCompra> getMercadoriacompra() {
		return mercadoriacompra;
	}

	public void setMercadoriacompra(List<MercadoriaCompra> mercadoriacompra) {
		this.mercadoriacompra = mercadoriacompra;
	}

	public String getIdUnidade() {
		return idUnidade;
	}

	public void setIdUnidade(String idUnidade) {
		this.idUnidade = idUnidade;
	}

}
