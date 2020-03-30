package com.smartcity.senbike.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

import com.smartcity.senbike.model.Bicicletero;
import com.smartcity.senbike.model.Bike;
import com.smartcity.senbike.service.BikeService;



@RestController
public class BikeController{

    @Autowired
    private BikeService  bikeService;
    
    @RequestMapping(value ="/bicicletero/{bicicleteroId}/bike", method = RequestMethod.GET)
    public List<Bike> getBicicletas(@PathVariable int bicicleteroId){
        return bikeService.getBikes(bicicleteroId);
    }
    
    @RequestMapping(value ="/bicicletero/{bicicleteroId}/bike/{bikeId}", method = RequestMethod.DELETE)
    public Bike retirarBike(@PathVariable int bikeId ){
        Bike bikeAux = bikeService.exitBike(bikeId);
        bikeService.removeBike(bikeId);
        return bikeAux;
    }

    @RequestMapping(value ="/bicicletero/{bicicleteroId}/bike/{bikeId}", method = RequestMethod.GET)
    public Bike getBicicleta(@PathVariable int bikeId){
        return bikeService.getBike(bikeId);
    }

    @RequestMapping(value ="/bicicletero/{bicicleteroId}/bike", method = RequestMethod.POST)
    public String addBike(@PathVariable int bicicleteroId, @RequestBody Bike bike){
        bike.setBicicletero(new Bicicletero(bicicleteroId));
        bike.setIngreso(new Date().toString());
        bikeService.addBike(bike);
        if(bikeService.addBikeToBicicletero(bikeService.getBike(bike.getTuiId()))){
            return "Bicicleta guardada";
        }else{
            bikeService.removeBike(bike.getTuiId());
            return "No hay espacio diponible";
        }
    }
}