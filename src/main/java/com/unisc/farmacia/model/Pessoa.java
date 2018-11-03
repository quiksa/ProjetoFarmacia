package com.unisc.farmacia.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "pessoa")
public class Pessoa {

	@Id
	@Column(name = "idpessoa")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPessoa;

	@Column(name = "nmpessoa")
	private String nmPessoa;

	@Column(name = "sgsexo")
	private String sgsexo;

	@Column(name = "email")
	private String email;

	@ManyToOne
	@JoinColumn(name = "idendereco")
	@Cascade(CascadeType.ALL)
	private Endereco endereco;

	public String getNrcpf() {
		return nrcpf;
	}

	public void setNrcpf(String nrcpf) {
		this.nrcpf = nrcpf;
	}

	public String getNrtelefone() {
		return nrtelefone;
	}

	public void setNrtelefone(String nrtelefone) {
		this.nrtelefone = nrtelefone;
	}

	@Column(name = "nrcpf")
	private String nrcpf;

	@Column(name = "nrtelefone")
	private String nrtelefone;

	@Column(name = "dtnascimento")
	private LocalDate dtnascimento;

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNmPessoa() {
		return nmPessoa;
	}

	public void setNmPessoa(String nmPessoa) {
		this.nmPessoa = nmPessoa;
	}

	public LocalDate getDtnascimento() {
		return dtnascimento;
	}

	public void setDtnascimento(LocalDate dtnascimento) {
		this.dtnascimento = dtnascimento;
	}

	public String getSgsexo() {
		return sgsexo;
	}

	public void setSgsexo(String sgsexo) {
		this.sgsexo = sgsexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
