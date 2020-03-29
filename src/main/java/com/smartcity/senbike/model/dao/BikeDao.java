package com.smartcity.senbike.model.dao;

import java.util.List;

import javax.transaction.Transactional;

import com.smartcity.senbike.model.Bike;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface BikeDao extends CrudRepository<Bike, Long>{
    public List<Bike> findByBicicleteroBicicleteroId(long bicicleteroId);
}