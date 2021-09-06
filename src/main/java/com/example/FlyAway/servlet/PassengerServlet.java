package com.example.FlyAway.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.FlyAway.dao.FlightBookingDAO;
import com.example.FlyAway.dao.FlightDAO;
import com.example.FlyAway.dao.PassengerDAO;
import com.example.FlyAway.model.Flight;
import com.example.FlyAway.model.FlightBooking;
import com.example.FlyAway.model.Passenger;


@WebServlet(name = "passenger", urlPatterns = { "/passenger" })
public class PassengerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	PassengerDAO passengerDAO;
	@Autowired
	FlightBookingDAO flightBookingDAO;
	@Autowired
	FlightDAO flightDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Passenger user = passengerDAO.getPassengerByEmail(request.getParameter("email"));
		
		if(user == null) {
			user = new Passenger(request.getParameter("pass"), request.getParameter("fname"), request.getParameter("lname"),
					request.getParameter("email"));
			passengerDAO.save(user);
		}
		

			Flight flight = flightDAO.findById(Integer.parseInt(request.getParameter("id"))).get();
			Set<Flight> flights = new HashSet<Flight>();
			flights.add(flight);
			
			FlightBooking f = new FlightBooking(user, flights);
			flightBookingDAO.save(f);
			response.sendRedirect("done.jsp");
//		} catch (Exception e) {
//			response.getWriter().append("error").append(request.getContextPath());
//		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
