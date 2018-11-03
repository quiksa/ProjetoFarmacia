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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@Column(name = "idcliente")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCliente;

	@OneToOne
	@JoinColumn(name = "idpessoa")
	@Cascade(CascadeType.ALL)
	private Pessoa pessoa;

	@Transient
	private String idEndereco;

	@Transient
	private String sgsexo;

	@Transient
	private String bairro;

	@Transient
	private String dscomplemento;

	@Transient
	private String dtnascimento;

	@Transient
	private String email;

	@Transient
	private String nmrua;

	@Transient
	private String idcidade;

	@Transient
	private String nmPessoa;

	@Transient
	private String idpessoa;

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

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getDscomplemento() {
		return dscomplemento;
	}

	public void setDscomplemento(String dscomplemento) {
		this.dscomplemento = dscomplemento;
	}

	public String getDtnascimento() {
		return dtnascimento;
	}

	public void setDtnascimento(String dtnascimento) {
		this.dtnascimento = dtnascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNmrua() {
		return nmrua;
	}

	public void setNmrua(String nmrua) {
		this.nmrua = nmrua;
	}

	public String getIdcidade() {
		return idcidade;
	}

	public void setIdcidade(String idcidade) {
		this.idcidade = idcidade;
	}

	public String getIdpessoa() {
		return idpessoa;
	}

	public void setIdpessoa(String idpessoa) {
		this.idpessoa = idpessoa;
	}

	public String getSgsexo() {
		return sgsexo;
	}

	public void setSgsexo(String sgsexo) {
		this.sgsexo = sgsexo;
	}

}
