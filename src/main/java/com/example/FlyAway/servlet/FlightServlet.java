package com.example.FlyAway.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.FlyAway.dao.AirlineDAO;
import com.example.FlyAway.dao.FlightDAO;
import com.example.FlyAway.model.Airline;
import com.example.FlyAway.model.Flight;


@WebServlet(name = "flight", urlPatterns = { "/flight" })
public class FlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	@Autowired
	FlightDAO flightDAO;
	@Autowired
	AirlineDAO airlineDAO;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Iterable<Flight> flights= flightDAO.findAll();
		Iterable<Airline> airlines= airlineDAO.findAll(); 
		
		request.setAttribute("airlineList", airlines);
		
		request.setAttribute("flightsList", flights);
		
		RequestDispatcher rd = request.getRequestDispatcher("flight.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Airline airline = airlineDAO.findById(Integer.parseInt(request.getParameter("airline"))).get();

		Flight flight = new Flight(0,(String) request.getParameter("departure"),
				(String) request.getParameter("arrival"),
				(String) request.getParameter("departureDate"),Integer.parseInt(request.getParameter("price")),airline);
		
		flightDAO.save(flight);
		
		doGet(request, response);
	}

}
