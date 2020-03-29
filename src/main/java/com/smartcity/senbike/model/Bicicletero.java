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
    private long bicicleteroId;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "espacios", nullable = false)
    private int espacios;

    @OneToMany(mappedBy =  "bicicletero")
    private List<Bike> bikes;

	public void setBicicleteroId(long bicicleteroId) {
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

    //Retorna lista de espacios diponibles
    public int[] mostrarEspaciosLibres(){
        int[] espaciosDisponibles = new int[calcularEspaciosDisponibles()];
        int espacioAux = 0;
        for(int i = 0; i<= espacios;i++){
            if(i +1 == bikes.get(i).getEspacioDesignado()){
                //si se cumple la función me dice que el espacio actual se encuentra ocupado
            }else{
                espaciosDisponibles[espacioAux]=(i+1);
                espacioAux++;
            }
        }
        return espaciosDisponibles;
    }

    public int getEspacios(){
        return espacios;
    }
    public Bicicletero() {
    }

    public Bicicletero(long bicicleteroId) {
        this.bicicleteroId = bicicleteroId;
    }

    public long getBicicleteroId() {
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

    public boolean findBike(long tuiId){
        return bikes.stream().anyMatch(bike -> bike.getTuiId() ==tuiId);
    }
}