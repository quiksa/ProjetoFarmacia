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

@Entity
@Table(name = "funcionario")
public class Funcionario {

	@Id
	@Column(name = "idfuncionario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFuncionario;

	@OneToOne
	@JoinColumn(name = "idpessoa")
	private Pessoa pessoa;

	@Column(name = "login")
	private String login;

	@Column(name = "senha")
	private String senha;

	@Column(name = "nrcpf")
	private String nrcpf;

	@ManyToOne
	@JoinColumn(name = "idunidade")
	private Unidade unidade;

	@Column(name = "dhdesativacao")
	private LocalDate dtDesativacao;

	@OneToOne
	@JoinColumn(name = "idcargo")
	private Cargo cargo;

	@Transient
	private String nmPessoa;

	@Transient
	private String idcargo;

	@Transient
	private String idcidade;

	@Transient
	private String idpessoa;

	@Transient
	private String idunidade;

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
	private String sgsexo;

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

	public String getIdcargo() {
		return idcargo;
	}

	public void setIdcargo(String idcargo) {
		this.idcargo = idcargo;
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

	public String getIdunidade() {
		return idunidade;
	}

	public void setIdunidade(String idunidade) {
		this.idunidade = idunidade;
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

	public String getSgsexo() {
		return sgsexo;
	}

	public void setSgsexo(String sgsexo) {
		this.sgsexo = sgsexo;
	}

	public String getNrcpf() {
		return nrcpf;
	}

	public void setNrcpf(String nrcpf) {
		this.nrcpf = nrcpf;
	}

}
