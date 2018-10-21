package com.unisc.farmacia.model;

import java.time.LocalDate;
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

@Entity
@Table(name="unidade")
public class Unidade {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idunidade")
	private int idUnidade;
	
	@Column(name="dsunidade")
	private String dsUnidade;
	
	@Column(name="nmunidade")
	private String nmUnidade;
	
	@Column(name="nmreduzido")
	private String nmRduzido;
	
	@Column(name="cnpj")
	private String cnpj;
	
	@OneToOne
	@JoinColumn(name="idendereco")
	private Endereco endereco;
	
	@Column(name="dhdesativacao")
	private LocalDate dtDesativacao;
	
	@OneToMany(mappedBy="unidade",orphanRemoval = true)
	@Cascade(CascadeType.ALL)
	private List<Funcionario> unidade = new ArrayList<Funcionario>();
	
	public int getIdUnidade() {
		return idUnidade;
	}
	public void setIdUnidade(int idUnidade) {
		this.idUnidade = idUnidade;
	}
	public String getDsUnidade() {
		return dsUnidade;
	}
	public void setDsUnidade(String dsUnidade) {
		this.dsUnidade = dsUnidade;
	}
	public String getNmUnidade() {
		return nmUnidade;
	}
	public void setNmUnidade(String nmUnidade) {
		this.nmUnidade = nmUnidade;
	}
	public String getNmRduzido() {
		return nmRduzido;
	}
	public void setNmRduzido(String nmRduzido) {
		this.nmRduzido = nmRduzido;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public LocalDate getDtDesativacao() {
		return dtDesativacao;
	}
	public void setDtDesativacao(LocalDate dtDesativacao) {
		this.dtDesativacao = dtDesativacao;
	}

}
