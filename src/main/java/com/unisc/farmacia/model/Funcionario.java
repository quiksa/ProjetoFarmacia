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
	
	@Column(name="dhinsert")
	private String dtRegistro;
	
	
	@Column(name="dhdesativacao")
	private String dtDesativacao;
	
	@OneToOne
	@JoinColumn(name="idcargo")
	private Cargo cargo;
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
	public String getDtRegistro() {
		return dtRegistro;
	}
	public void setDtRegistro(String dtRegistro) {
		this.dtRegistro = dtRegistro;
	}
	public String getDtDesativacao() {
		return dtDesativacao;
	}
	public void setDtDesativacao(String dtDesativacao) {
		this.dtDesativacao = dtDesativacao;
	}
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	
	
	
	
}
