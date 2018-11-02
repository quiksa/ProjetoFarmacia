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

@Entity
@Table(name = "pessoa")
public class Pessoa {

	@Id
	@Column(name = "idpessoa")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPessoa;

	@Column(name = "nmpessoa")
	private String nmPessoa;
<<<<<<< HEAD
	
	@Column(name="nrcpf")
	private String  nrcpf;
	
	@Column(name="nrtelefone")
	private String nrtelefone;
	
=======

	@Column(name = "sgsexo")
	private String sgsexo;

	@Column(name = "email")
	private String email;

>>>>>>> 18f88f9100e30e8916e62bdd2e476f48c0696f9e
	@ManyToOne
	@JoinColumn(name = "idendereco")
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
<<<<<<< HEAD
	}	
=======
	}

	@Column(name = "nrcpf")
	private String nrcpf;

	@Column(name = "nrtelefone")
	private String nrtelefone;

	@Column(name = "dtnascimento")
	private LocalDate dtnascimento;

>>>>>>> 18f88f9100e30e8916e62bdd2e476f48c0696f9e
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
