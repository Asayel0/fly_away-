package com.example.FlyAway.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.FlyAway.model.FlightBooking;

public interface FlightBookingDAO extends CrudRepository<FlightBooking, Integer> {
	
	
}
