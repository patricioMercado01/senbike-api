package com.smartcity.senbike.model.dao;

import javax.transaction.Transactional;

import com.smartcity.senbike.model.Bicicletero;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface BicicleteroDao extends CrudRepository<Bicicletero, Long>{
}