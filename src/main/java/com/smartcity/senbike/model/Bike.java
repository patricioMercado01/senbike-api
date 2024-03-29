package com.smartcity.senbike.model;

import javax.persistence.*;


@Entity
@Table(name = "bike")
public class Bike {
    @Id
    @Column(name = "tui_id")
    private int tuiId;
    @Column(name = "ingreso")
    private String ingreso;
    @Column(name = "salida")
	private String salida;
	@Column(name = "espacio_designado", nullable = false)
	private int espacioDesignado;

	@ManyToOne
	@JoinColumn(name = "bicicletero_id",nullable = false)
	private Bicicletero bicicletero;
	
	public void setBicicletero(Bicicletero bicicletero) {
		this.bicicletero = bicicletero;
    }
    
    public void setSalida(){
        this.salida = new java.util.Date().toString();
    }
    
    public Bicicletero getBicicletero(){
        return this.bicicletero;
    }

	public int getTuiId() {
		return tuiId;
	}

	public void setTuiId(int tuiId) {
		this.tuiId = tuiId;
	}

	public String getIngreso() {
		return ingreso;
	}

	public void setIngreso(String ingreso) {
		this.ingreso = ingreso;
	}

	public String getSalida() {
		return salida;
	}

	public void setSalida(String salida) {
		this.salida = salida;
	}

	public int getEspacioDesignado() {
		return espacioDesignado;
	}

	public void setEspacioDesignado(int espacioDesignado) {
		this.espacioDesignado = espacioDesignado;
	}

	public Bike() {
	}


    
}