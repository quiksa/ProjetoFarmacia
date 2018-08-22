package com.unisc.farmacia.model;

public class HistoricoPreco {

	private int idHistoricoPreco;
	private Mercadoria mercadoria;
	private double vlCorrente;
	private double vlAntigo;
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
