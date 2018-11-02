package com.unisc.farmacia.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.lang.Nullable;

@Entity
@Table(name="funcionario")
public class Funcionario {

	
	@Id
	@Column(name="idfuncionario")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idFuncionario;
	
	@OneToOne
	@JoinColumn(name="idpessoa")
	private Pessoa pessoa;
	
	@Column(name="login")
	private String login;
	
	@Column(name="senha")
	private String senha;
	
	@ManyToOne
	@JoinColumn(name="idunidade")
	private Unidade unidade;
	
	@Column(name="dhdesativacao")
	private LocalDate dtDesativacao;
	
	@OneToOne
	@JoinColumn(name="idcargo")
	private Cargo cargo;
	
	//Transient da tabela cargo------------------------
	@Transient
	private String dsCargo;
	
	public String getDsCargo() {
		return dsCargo;
	}
	public void setDsCargo(String dsCargo) {
		this.dsCargo = dsCargo;
	}
	//Transient da tabela pessoa-----------------------
	@Transient
	private String nmPessoa;
	
	@Transient
	private String nrCpf;
	
	@Transient
	private String nrTelefone;
	
	@Transient
	private String idEndereco;
	
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
	public String getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(String idEndereco) {
		this.idEndereco = idEndereco;
	}
	//----------------------------------------------------------------
	public int getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Unidade getUnidade() {
		return unidade;
	}
	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	public LocalDate getDtDesativacao() {
		return dtDesativacao;
	}
	public void setDtDesativacao(LocalDate dtDesativacao) {
		this.dtDesativacao = dtDesativacao;
	}
	
}
