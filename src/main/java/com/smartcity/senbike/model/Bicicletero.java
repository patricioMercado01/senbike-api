package com.smartcity.senbike.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bicicletero")
public class Bicicletero{

    @Id
    @Column(name = "bicicletero_id")
    private int bicicleteroId;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "espacios", nullable = false)
    private int espacios;

    @OneToMany(mappedBy =  "bicicletero")
    private List<Bike> bikes;

	public void setBicicleteroId(int bicicleteroId) {
		this.bicicleteroId = bicicleteroId;
    }

    //retorna si existe espacios disponibles en el bicicletero
    public boolean existenciaEspacioDisponible(){
        if(bikes.size() <= espacios){
            return true;
        }else{
            return false;
        }
    }
    
    //calcula la cantidad de espacios disponibles en el bicicletero
    public int calcularEspaciosDisponibles(){
        return espacios - bikes.size();
    }


    public int getEspacios(){
        return espacios;
    }
    public Bicicletero() {
    }

    public Bicicletero(int bicicleteroId) {
        this.bicicleteroId = bicicleteroId;
    }

    public int getBicicleteroId() {
        return bicicleteroId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEspacios(int espacios) {
        this.espacios = espacios;
    }


    public void setBikes(List<Bike> bikes) {
        this.bikes = bikes;
    }

    public boolean findBike(int tuiId){
        return bikes.stream().anyMatch(bike -> bike.getTuiId() ==tuiId);
    }
}