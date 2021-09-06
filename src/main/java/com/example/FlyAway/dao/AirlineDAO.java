package com.example.FlyAway.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.FlyAway.model.Airline;

public interface AirlineDAO extends CrudRepository<Airline, Integer> {
	
	
}
