package com.example.FlyAway.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.FlyAway.dao.FlightDAO;


@WebServlet(name = "departure", urlPatterns = { "/departure" })
public class DepartureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	@Autowired
	FlightDAO flightDAO;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Iterable<String> departure= flightDAO.getDeparture(); 
		
		request.setAttribute("departureList", departure);
		
		RequestDispatcher rd = request.getRequestDispatcher("departure.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
