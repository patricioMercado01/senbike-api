package com.smartcity.senbike.controller;

import java.util.List;

import com.smartcity.senbike.model.Bicicletero;

import com.smartcity.senbike.service.BicicleteroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BicicleteroController{

    @Autowired
    private BicicleteroService bicicleteroService;
    
    @RequestMapping("/")
    public String test(){
        return "it's alive";
    }

    @RequestMapping(value="/bicicletero", method= RequestMethod.POST)
    public Bicicletero addBicicletero(@RequestBody Bicicletero bicicletero){
        bicicleteroService.addBiciletero(bicicletero);
        return bicicletero;
    }

    @RequestMapping(value="/bicicletero/{bicicleteroId}", method= RequestMethod.GET)
    public Bicicletero getBiciletero(@PathVariable long bicicleteroId){
        return bicicleteroService.getBicicletero(bicicleteroId);
    }

    @RequestMapping(value="/bicicletero/{bicicleteroId}", method= RequestMethod.DELETE)
    public void deleteBiciletero(@PathVariable long bicicleteroId){
        bicicleteroService.deleteBicicletero(bicicleteroId);
    }

    @RequestMapping(value="/bicicletero/{bicicleteroId}/espacios", method= RequestMethod.GET)
    public int getNumEspaciosBicicletero(@PathVariable long bicicleteroId){
        return bicicleteroService.numDisponible(bicicleteroId);
    }

    @RequestMapping(value="/bicicletero/{bicicleteroId}/buscar/{tuiId}", method= RequestMethod.GET)
    public boolean findBike(@PathVariable long bicicleteroId, @PathVariable long tuiId){
        return bicicleteroService.findBike(tuiId,bicicleteroId);
    }

    @RequestMapping(value="/bicicletero/", method= RequestMethod.GET)
    public  List<Bicicletero> getBicicleteros(){
        return bicicleteroService.getBicicleteros();
    }
}