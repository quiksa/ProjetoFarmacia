package com.unisc.farmacia.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="mercadoria")
public class Mercadoria {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "idmercadoria")
	private int idMercadoria;
	
	@Column(name="nmmercadoria")
	private String nmMercadoria;
	
	@Column(name="dscomplemento")
	private String dsComplemento;
	
	@ManyToOne
	@JoinColumn(name="idfornecedor")
	@JsonBackReference
	private Fornecedor fornecedor;
	
	@ManyToOne
	@JoinColumn(name="idcategoria")
	private Categoria categoria;
	
	// Transient de Categoria
	
	@Transient
	private String tDsCategoria;
	
	@Transient
	private String tcnpjFornec;
	
	@Transient
	private String tDsFornecedor;
	
	@Transient
	private String tIdEnderecoFornecedor;
	
	public String gettDsCategoria() {
		return tDsCategoria;
	}
	public void settDsCategoria(String tDsCategoria) {
		this.tDsCategoria = tDsCategoria;
	}
	public String getTcnpjFornec() {
		return tcnpjFornec;
	}
	public void setTcnpjFornec(String tcnpjFornec) {
		this.tcnpjFornec = tcnpjFornec;
	}
	public String gettDsFornecedor() {
		return tDsFornecedor;
	}
	public void settDsFornecedor(String tDsFornecedor) {
		this.tDsFornecedor = tDsFornecedor;
	}
	public String gettIdEnderecoFornecedor() {
		return tIdEnderecoFornecedor;
	}
	public void settIdEnderecoFornecedor(String tIdEnderecoFornecedor) {
		this.tIdEnderecoFornecedor = tIdEnderecoFornecedor;
	}	
	
	
	
	//--------------------------------
	
	
	public List<HistoricoPreco> getHistoricoDePrecos() {
		return historicoDePrecos;
	}
	public void setHistoricoDePrecos(List<HistoricoPreco> historicoDePrecos) {
		this.historicoDePrecos = historicoDePrecos;
	}
	@OneToMany(mappedBy="mercadoria",orphanRemoval = true)
	@Cascade(CascadeType.ALL)
	@JsonManagedReference
	private List<HistoricoPreco> historicoDePrecos = new ArrayList <HistoricoPreco>();
	
	
	public int getIdMercadoria() {
		return idMercadoria;
	}
	public void setIdMercadoria(int idMercadoria) {
		this.idMercadoria = idMercadoria;
	}
	public String getNmMercadoria() {
		return nmMercadoria;
	}
	public void setNmMercadoria(String nmMercadoria) {
		this.nmMercadoria = nmMercadoria;
	}
	public String getDsComplemento() {
		return dsComplemento;
	}
	public void setDsComplemento(String dsComplemento) {
		this.dsComplemento = dsComplemento;
	}
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	
}
