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
@Table(name = "estoque")
public class Estoque {

	@Id
	@Column(name = "idestoque")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEstoque;

	@OneToOne
	@JoinColumn(name = "idunidade")
	private Unidade unidade;

	@Column(name = "dsestoque")
	private String dsEstoque;

	@Transient
	private String idUnidade;

	public String getIdUnidade() {
		return idUnidade;
	}

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

	public String getDsEstoque() {
		return dsEstoque;
	}

	public void setDsEstoque(String dsEstoque) {
		this.dsEstoque = dsEstoque;
	}

}
