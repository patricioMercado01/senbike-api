package com.smartcity.senbike.service;

import java.util.ArrayList;
import java.util.List;

import com.smartcity.senbike.model.Bicicletero;
import com.smartcity.senbike.model.dao.BicicleteroDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BicicleteroService{

    @Autowired
    public BicicleteroDao bicicleteroDao;

    public void addBiciletero(Bicicletero bicicletero){
        bicicleteroDao.save(bicicletero);
    }

    public Bicicletero getBicicletero(int bicicleteroId){
        return bicicleteroDao.findById(bicicleteroId).get();
    }

    public List<Bicicletero> getBicicleteros(){
        List<Bicicletero> bicicletero = new  ArrayList<>();
        bicicleteroDao.findAll().forEach(bicicletero::add);
        return bicicletero;
    }

    public void removeBicicletero(int bicicleteroId){
        bicicleteroDao.deleteById(bicicleteroId);
    }

    public void updateBiciletero(Bicicletero bicicletero){
        bicicleteroDao.save(bicicletero);
    }

    //Busca si existe espacio disponible en e bicicletero
    public boolean espacioDisponibles(int bicicleteroId){
        Bicicletero bicicleteroAux = bicicleteroDao.findById(bicicleteroId).get();
        return bicicleteroAux.existenciaEspacioDisponible();
    }   

    public int numDisponible(int bicicleteroId){
        return bicicleteroDao.findById(bicicleteroId).get().calcularEspaciosDisponibles();
    }

    public boolean findBike(int tuiId, int bicicleteroId){
        return bicicleteroDao.findById(bicicleteroId).get().findBike(tuiId);
    }
    
    public void deleteBicicletero(int bicicleteroId){
        bicicleteroDao.deleteById(bicicleteroId);
    }
}