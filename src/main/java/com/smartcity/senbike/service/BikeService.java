package com.smartcity.senbike.service;

import java.util.ArrayList;
import java.util.List;

import com.smartcity.senbike.model.Bike;
import com.smartcity.senbike.model.dao.BikeDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BikeService{

    @Autowired
    private BikeDao  bikeDao;
    public Bike exitBike(long bikeId){
        Bike bikeAux = bikeDao.findById(bikeId).get();
        bikeAux.setSalida();
        return bikeAux;
    }

    public List<Bike> getBikes(long bicicleteroId){
        List<Bike> bikes = new  ArrayList<>();
        bikeDao.findByBicicleteroBicicleteroId(bicicleteroId).forEach(bikes::add);
        return bikes;
    }

    public void addBike(Bike bike){
        bikeDao.save(bike);
    }

    public boolean addBikeToBicicletero(Bike bike){
        boolean espacioDisponible = bike.getBicicletero().existenciaEspacioDisponible();
        if(espacioDisponible){
            return true;
        }else{
            return  false;
        }
    }

    public void removeBike(long bikeId){
        bikeDao.deleteById(bikeId);
    }

    public Bike getBike (long bikeId){
        return bikeDao.findById(bikeId).get();
    }

 
}