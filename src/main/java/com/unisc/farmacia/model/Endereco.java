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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="endereco")
public class Endereco {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idendereco")
	private int idEndereco;
	
	@Column (name="nmrua")
	private String nmRua;
	
	@Column (name="dscomplemento")
	private String dsComplemento;
	
	@Column (name="bairro")
	private String bairro;
	
	@OneToOne(mappedBy="endereco",orphanRemoval = true) // mappedBy = como é o nome desse atributo na classe fornecedor
	@Cascade(CascadeType.ALL)
	@JsonBackReference
	private Fornecedor fornecedor;
	
	@ManyToOne
	@JoinColumn(name="idcidade")
	@JsonBackReference
	private Cidade cidade;
	
	public int getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}
	public String getNmRua() {
		return nmRua;
	}
	public void setNmRua(String nmRua) {
		this.nmRua = nmRua;
	}
	public String getDsComplemento() {
		return dsComplemento;
	}
	public void setDsComplemento(String dsComplemento) {
		this.dsComplemento = dsComplemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	

	
	
}
