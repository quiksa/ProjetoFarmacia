package com.unisc.farmacia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="cliente")
public class Cliente {

	@Id
	@Column(name="idcliente")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCliente;
	
	@OneToOne
	@JoinColumn(name="idpessoa")
	private Pessoa pessoa;
	
	//Transients de pessoa----------------------------------------
	
	@Transient
	private String idEndereco;
	
	@Transient
	private String nmPessoa;
	
	@Transient
	private String nrCpf;
	
	@Transient
	private String nrTelefone;
	
	public String getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(String idEndereco) {
		this.idEndereco = idEndereco;
	}
	public String getNmPessoa() {
		return nmPessoa;
	}
	public void setNmPessoa(String nmPessoa) {
		this.nmPessoa = nmPessoa;
	}
	public String getNrCpf() {
		return nrCpf;
	}
	public void setNrCpf(String nrCpf) {
		this.nrCpf = nrCpf;
	}
	public String getNrTelefone() {
		return nrTelefone;
	}
	public void setNrTelefone(String nrTelefone) {
		this.nrTelefone = nrTelefone;
	}
	
	
	//-------------------------------------------------------------
	
	
	
	
	
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}
