package com.unisc.farmacia.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "estado")
public class Estado {

	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idestado")
	private int idEstado;
	
	@Column (name="nmestado")
	private String nmEstado;
	
	@Column (name="uf")
	private String uf;
	
	@OneToMany(mappedBy="estado",orphanRemoval = true)//mapear o atributo da classe cidade que faz referencia a Estado
	@Cascade(CascadeType.ALL)
	private List<Cidade>cidade = new ArrayList<Cidade>();
		
	public int getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}
	public String getNmEstado() {
		return nmEstado;
	}
	public void setNmEstado(String nmEstado) {
		this.nmEstado = nmEstado;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	
}
