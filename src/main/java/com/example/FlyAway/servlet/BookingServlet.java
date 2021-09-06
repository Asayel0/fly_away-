package com.example.FlyAway.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.FlyAway.dao.FlightBookingDAO;
import com.example.FlyAway.model.FlightBooking;


@WebServlet(name = "booking", urlPatterns = { "/booking" })
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	FlightBookingDAO flightBookingDAO;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Iterable<FlightBooking> flightBooking = flightBookingDAO.findAll();
		request.setAttribute("bookingList", flightBooking);
		
		RequestDispatcher rd = request.getRequestDispatcher("booking.jsp");
		rd.forward(request, response);
		
	}

}
