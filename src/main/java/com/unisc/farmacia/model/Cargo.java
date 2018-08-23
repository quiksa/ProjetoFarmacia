package com.unisc.farmacia.model;

import javax.persistence.*;

@Entity
@Table(name = "cargo")
public class Cargo {

	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idcargo")
	private int idCargo;
	
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
}
