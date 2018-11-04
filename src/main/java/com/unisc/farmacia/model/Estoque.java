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
@Table(name="estoque")
public class Estoque {

	@Id
	@Column(name="idestoque")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEstoque;
	
	@OneToOne
	@JoinColumn(name="idunidade")
	private Unidade unidade;
	
	
	/**************************
	 * TRANSIENTS DE UNIDADE***
	 *************************/
	
	@Transient
	private String dsUnidade;
	
	@Transient
	private String nmUnidade;
	
	@Transient
	private String nmReduzido;
	
	@Transient
	private String cnpj;
	
	@Transient
	private String idEndereco;
	
	
	
	
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
	public String getNmReduzido() {
		return nmReduzido;
	}
	public void setNmReduzido(String nmReduzido) {
		this.nmReduzido = nmReduzido;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(String idEndereco) {
		this.idEndereco = idEndereco;
	}
	
	//-----------------------------------------------------//
	
	
	public int getIdEstoque() {
		return idEstoque;
	}
	public void setIdEstoque(int idEstoque) {
		this.idEstoque = idEstoque;
	}
	public Unidade getUnidade() {
		return unidade;
	}
	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
	
	
	
}
