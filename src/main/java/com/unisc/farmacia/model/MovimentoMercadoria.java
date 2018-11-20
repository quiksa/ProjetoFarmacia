package com.unisc.farmacia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "movimentomercadoria")
public class MovimentoMercadoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idmovimentomercadoria")
	private int idMovimentoMercadoria;

	@Column(name = "qtmovimentomercadoria")
	private int qtMovimentoMercadoria;

	@Column(name = "vlmovimentomercadoria")
	private String vlMovimentoMercadoria;

	@ManyToOne
	@JoinColumn(name = "idfornecedor")
	private Fornecedor fornecedor;

	@ManyToOne
	@JoinColumn(name = "idmercadoria")
	private Mercadoria mercadoria;

	@ManyToOne
	@JoinColumn(name = "idestoque")
	private Estoque estoque;

	@OneToOne
	@JoinColumn(name = "idmovimentoestoque")
	@Cascade(CascadeType.ALL)
	private MovimentoEstoque movimentoestoque;

	@Transient
	private String idfornecedor;

	@Transient
	private String idestoque;

	@Transient
	private String idmercadoria;

	@Transient
	private String dslote;

	@Transient
	private int idmovimentoestoque;

	public int getIdMovimentoMercadoria() {
		return idMovimentoMercadoria;
	}

	public void setIdMovimentoMercadoria(int idMovimentoMercadoria) {
		this.idMovimentoMercadoria = idMovimentoMercadoria;
	}

	public int getQtMovimentoMercadoria() {
		return qtMovimentoMercadoria;
	}

	public void setQtMovimentoMercadoria(int qtMovimentoMercadoria) {
		this.qtMovimentoMercadoria = qtMovimentoMercadoria;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Mercadoria getMercadoria() {
		return mercadoria;
	}

	public void setMercadoria(Mercadoria mercadoria) {
		this.mercadoria = mercadoria;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	public MovimentoEstoque getMovimentoestoque() {
		return movimentoestoque;
	}

	public void setMovimentoestoque(MovimentoEstoque movimentoestoque) {
		this.movimentoestoque = movimentoestoque;
	}

	public String getIdfornecedor() {
		return idfornecedor;
	}

	public String getIdestoque() {
		return idestoque;
	}

	public String getIdmercadoria() {
		return idmercadoria;
	}

	public String getDslote() {
		return dslote;
	}

	public String getVlMovimentoMercadoria() {
		return vlMovimentoMercadoria;
	}

	public void setVlMovimentoMercadoria(String vlMovimentoMercadoria) {
		this.vlMovimentoMercadoria = vlMovimentoMercadoria;
	}

	public int getIdmovimentoestoque() {
		return idmovimentoestoque;
	}

	public void setIdmovimentoestoque(int idmovimentoestoque) {
		this.idmovimentoestoque = idmovimentoestoque;
	}

}
