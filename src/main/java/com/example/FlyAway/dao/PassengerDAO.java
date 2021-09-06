package com.example.FlyAway.dao;


import org.springframework.data.repository.CrudRepository;

import com.example.FlyAway.model.Passenger;


public interface PassengerDAO extends CrudRepository<Passenger, Integer> {
	
	Passenger getPassengerByEmail(String email);
}
