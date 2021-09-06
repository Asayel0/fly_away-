package com.example.FlyAway.dao;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.FlyAway.model.Flight;

public interface FlightDAO extends CrudRepository<Flight, Integer> {
	
	@Query(nativeQuery = true, value = "select * from tbl_flight u where u.departure like :departure and u.arrival like :arrival"
			+ " and departure_date like :departure_date")
	List<Flight> search(@Param("departure") String departure,@Param("arrival")  String arrival, String departure_date);
	
	@Query(nativeQuery = true, value = "select DISTINCT u.departure from tbl_flight u" )
	Iterable<String> getDeparture();
	
	@Query(nativeQuery = true, value = "select DISTINCT u.arrival from tbl_flight u" )
	Iterable<String> getArrival();
}
