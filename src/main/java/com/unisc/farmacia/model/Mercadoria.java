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

@Entity
@Table(name = "mercadoria")
public class Mercadoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idmercadoria")
	private int idMercadoria;

	@Column(name = "nmmercadoria")
	private String nmMercadoria;

	@Column(name = "dscomplemento")
	private String dsComplemento;
	
	@ManyToOne
	@JoinColumn(name="idfornecedor")
	@JsonBackReference
	private Fornecedor fornecedor;

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public void setIdcategoria(String idcategoria) {
		this.idcategoria = idcategoria;
	}

	@Column(name = "codbarras")
	private String codBarra;

	@Column(name = "vlmercadoria")
	private double vlMercadoria;
	
	@ManyToOne
	@JoinColumn(name = "idcategoria")
	private Categoria categoria;

	@OneToMany(mappedBy = "mercadoria", orphanRemoval = true)
	@Cascade(CascadeType.ALL)
	private List<HistoricoPreco> historicoDePrecos = new ArrayList<HistoricoPreco>();

	@Transient
	private String idcategoria;
	
	@Transient
	private String transIdFornecedor;

	public List<HistoricoPreco> getHistoricoDePrecos() {
		return historicoDePrecos;
	}

	public String getTransIdFornecedor() {
		return transIdFornecedor;
	}

	public void setTransIdFornecedor(String transIdFornecedor) {
		this.transIdFornecedor = transIdFornecedor;
	}

	public void setHistoricoDePrecos(List<HistoricoPreco> historicoDePrecos) {
		this.historicoDePrecos = historicoDePrecos;
	}

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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getIdcategoria() {
		return idcategoria;
	}

	public String getCodBarra() {
		return codBarra;
	}

	public void setCodBarra(String codBarra) {
		this.codBarra = codBarra;
	}

	public double getVlMercadoria() {
		return vlMercadoria;
	}

	public void setVlMercadoria(double vlMercadoria) {
		this.vlMercadoria = vlMercadoria;
	}

}
