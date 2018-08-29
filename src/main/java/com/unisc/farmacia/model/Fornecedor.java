package com.unisc.farmacia.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="fornecedor")
public class Fornecedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idfornecedor")
	private int idFornecedor;
	
	@Column(name="cnpj")
	private String cnpj;
	
	@Column(name="dscomplemento")
	private String dsComplemento;
	
	@OneToOne
	@JoinColumn(name="idendereco")
	 @JsonManagedReference
	private Endereco endereco;
	
	@OneToMany(mappedBy="fornecedor",orphanRemoval = true)
	@Cascade(CascadeType.ALL)
	@JsonManagedReference
	private List <Mercadoria> mercadorias = new ArrayList<Mercadoria>();
	
	public List<Mercadoria> getMercadorias() {
		return mercadorias;
	}
	public void setMercadorias(List<Mercadoria> mercadorias) {
		this.mercadorias = mercadorias;
	}
	public int getIdFornecedor() {
		return idFornecedor;
	}
	public void setIdFornecedor(int idFornecedor) {
		this.idFornecedor = idFornecedor;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getDsComplemento() {
		return dsComplemento;
	}
	public void setDsComplemento(String dsComplemento) {
		this.dsComplemento = dsComplemento;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	
}
