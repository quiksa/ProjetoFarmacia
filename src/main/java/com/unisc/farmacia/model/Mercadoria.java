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
	@JoinColumn(name = "idfornecedor")
	@JsonBackReference
	private Fornecedor fornecedor;

	@ManyToOne
	@JoinColumn(name = "idcategoria")
	private Categoria categoria;

	@OneToMany(mappedBy = "mercadoria", orphanRemoval = true)
	@Cascade(CascadeType.ALL)
	private List<HistoricoPreco> historicoDePrecos = new ArrayList<HistoricoPreco>();

	@Transient
	private String idfornecedor;

	@Transient
	private String idcategoria;

	public List<HistoricoPreco> getHistoricoDePrecos() {
		return historicoDePrecos;
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

	public String getIdfornecedor() {
		return idfornecedor;
	}

	public String getIdcategoria() {
		return idcategoria;
	}

}
