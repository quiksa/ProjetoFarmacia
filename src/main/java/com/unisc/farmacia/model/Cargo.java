package com.unisc.farmacia.model;

import javax.persistence.*;

@Entity
@Table(name = "cargo")
public class Cargo {

	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idcargo")
	private int idCargo;
	
	@Column (name="nmcargo")
	private String nmCargo;
	
	@Column (name="dscargo")
	private String dsCargo;
	
	public int getIdCargo() {
		return idCargo;
	}
	public void setIdCargo(int idCargo) {
		this.idCargo = idCargo;
	}
	public String getDsCargo() {
		return dsCargo;
	}
	public void setDsCargo(String dsCargo) {
		this.dsCargo = dsCargo;
	}
	public String getNmCargo() {
		return nmCargo;
	}
	public void setNmCargo(String nmCargo) {
		this.nmCargo = nmCargo;
	}
	
}
