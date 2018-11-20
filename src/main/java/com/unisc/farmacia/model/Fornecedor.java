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
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "fornecedor")
public class Fornecedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idfornecedor")
	private int idFornecedor;

	@Column(name = "cnpj")
	private String cnpj;

	@Column(name = "dsfornecedor")
	private String dsFornecedor;

	@OneToOne
	@JoinColumn(name = "idpessoa")
	@Cascade(CascadeType.ALL)
	private Pessoa pessoa;
	
	@OneToMany(mappedBy="fornecedor",orphanRemoval = true)
	@JsonManagedReference
	private List<Mercadoria> mercadorias = new ArrayList<Mercadoria>();
	
	public List<Mercadoria> getMercadorias() {
		return mercadorias;
	}

	public void setMercadorias(List<Mercadoria> mercadorias) {
		this.mercadorias = mercadorias;
	}

	@Transient
	private String idcidade;

	@Transient
	private String nmrua;

	@Transient
	private String bairro;

	@Transient
	private String dscomplemento;

	@Transient
	private String nmPessoa;

	@Transient
	private String email;

	@Transient
	private String idendereco;

	@Transient
	private String idpessoa;

	@Transient
	private String nrtelefone;

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

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getIdcidade() {
		return idcidade;
	}

	public String getNmrua() {
		return nmrua;
	}

	public String getDsFornecedor() {
		return dsFornecedor;
	}

	public void setDsFornecedor(String dsFornecedor) {
		this.dsFornecedor = dsFornecedor;
	}

	public String getBairro() {
		return bairro;
	}

	public String getDscomplemento() {
		return dscomplemento;
	}

	public String getNmPessoa() {
		return nmPessoa;
	}

	public String getEmail() {
		return email;
	}

	public String getNrtelefone() {
		return nrtelefone;
	}

	public String getIdendereco() {
		return idendereco;
	}

	public String getIdpessoa() {
		return idpessoa;
	}
	
	

}
