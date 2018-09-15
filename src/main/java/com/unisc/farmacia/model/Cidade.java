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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@Entity
@Table(name="cidade")
public class Cidade {

	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idcidade")
	private int idCidade;
	
	@Column(name="nmcidade")
	private String nmCidade;
	
	@Column(name="cep")
	private String cep;
	
	@ManyToOne
	@JoinColumn(name="idestado")
	private Estado estado;
	
	@OneToMany(mappedBy="cidade",orphanRemoval = true)
	@Cascade(CascadeType.ALL)
	private List<Endereco> endereco = new ArrayList<Endereco>();
	
	
	public int getIdCidade() {
		return idCidade;
	}
	public void setIdCidade(int idCidade) {
		this.idCidade = idCidade;
	}
	public String getNmCidade() {
		return nmCidade;
	}
	public void setNmCidade(String nmCidade) {
		this.nmCidade = nmCidade;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
	
	
}
