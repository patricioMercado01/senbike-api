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

    public Bicicletero getBicicletero(long bicicleteroId){
        return bicicleteroDao.findById(bicicleteroId).get();
    }

    public List<Bicicletero> getBicicleteros(){
        List<Bicicletero> bicicletero = new  ArrayList<>();
        bicicleteroDao.findAll().forEach(bicicletero::add);
        return bicicletero;
    }

    public void removeBicicletero(long bicicleteroId){
        bicicleteroDao.deleteById(bicicleteroId);
    }

    public void updateBiciletero(Bicicletero bicicletero){
        bicicleteroDao.save(bicicletero);
    }

    //Busca si existe espacio disponible en e bicicletero
    public boolean espacioDisponibles(long bicicleteroId){
        Bicicletero bicicleteroAux = bicicleteroDao.findById(bicicleteroId).get();
        return bicicleteroAux.existenciaEspacioDisponible();
    }   

    public int numDisponible(long bicicleteroId){
        return bicicleteroDao.findById(bicicleteroId).get().calcularEspaciosDisponibles();
    }

    public boolean findBike(long tuiId, long bicicleteroId){
        return bicicleteroDao.findById(bicicleteroId).get().findBike(tuiId);
    }

    //Restorna los lugares en los que hay espacios disponibles
    public int[] espaciosDisponibles(long bicicleteroId){
        return bicicleteroDao.findById(bicicleteroId).get().mostrarEspaciosLibres();
    }
    
    public void deleteBicicletero(long bicicleteroId){
        bicicleteroDao.deleteById(bicicleteroId);
    }
}