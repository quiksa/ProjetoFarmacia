package com.unisc.farmacia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="historicopreco")
public class HistoricoPreco {

	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idhistoricopreco")
	private int idHistoricoPreco;
	
	@ManyToOne
	@JoinColumn(name="idmercadoria")
	@JsonBackReference
	private Mercadoria mercadoria;
	
	@Column(name="vlcorrente")
	private double vlCorrente;
	
	@Column(name="vlantigo")
	private double vlAntigo;
	
	@Column(name="dtregistro")
	private String dtRegistro;
	
	public int getIdHistoricoPreco() {
		return idHistoricoPreco;
	}
	public void setIdHistoricoPreco(int idHistoricoPreco) {
		this.idHistoricoPreco = idHistoricoPreco;
	}
	public Mercadoria getMercadoria() {
		return mercadoria;
	}
	public void setMercadoria(Mercadoria mercadoria) {
		this.mercadoria = mercadoria;
	}
	public double getVlCorrente() {
		return vlCorrente;
	}
	public void setVlCorrente(double vlCorrente) {
		this.vlCorrente = vlCorrente;
	}
	public double getVlAntigo() {
		return vlAntigo;
	}
	public void setVlAntigo(double vlAntigo) {
		this.vlAntigo = vlAntigo;
	}
	public String getDtRegistro() {
		return dtRegistro;
	}
	public void setDtRegistro(String dtRegistro) {
		this.dtRegistro = dtRegistro;
	}
	
}
