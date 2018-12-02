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

	@Column(name = "codbarras")
	private int codBarra;

	@Column(name = "vlmercadoria")
	private float vlMercadoria;

	@ManyToOne
	@JoinColumn(name = "idcategoria")
	private Categoria categoria;

	@OneToMany(mappedBy = "mercadoria", orphanRemoval = true)
	@Cascade(CascadeType.ALL)
	private List<HistoricoPreco> historicoDePrecos = new ArrayList<HistoricoPreco>();

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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getIdcategoria() {
		return idcategoria;
	}

	public int getCodBarra() {
		return codBarra;
	}

	public void setCodBarra(int codBarra) {
		this.codBarra = codBarra;
	}

	public float getVlMercadoria() {
		return vlMercadoria;
	}

	public void setVlMercadoria(float vlMercadoria) {
		this.vlMercadoria = vlMercadoria;
	}

}
