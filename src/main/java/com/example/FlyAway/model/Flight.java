package com.example.FlyAway.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "tbl_flight")
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String departure;
	private String arrival;
	private String departureDate;
	private int price;
	
	@ManyToOne
	private Airline airline;
	
	@ManyToMany(mappedBy = "flights", fetch = FetchType.LAZY)
	private Set<FlightBooking> bookings;

	public Flight() {
		super();
	}

	public Flight(int id, String departure, String arrival, String departureDate,int price, Airline airline) {
		super();
		this.id = id;
		this.departure = departure;
		this.arrival = arrival;
		this.departureDate = departureDate;
		this.airline = airline;
		this.price =price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}

	public Set<FlightBooking> getBookings() {
		return bookings;
	}

	public void setBookings(Set<FlightBooking> bookings) {
		this.bookings = bookings;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}


	
}