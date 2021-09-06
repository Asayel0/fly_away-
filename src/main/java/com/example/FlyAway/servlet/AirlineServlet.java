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
import com.example.FlyAway.model.Airline;


@WebServlet(name = "airline", urlPatterns = { "/airline" })
public class AirlineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	AirlineDAO airlineDAO;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Iterable<Airline> airlines= airlineDAO.findAll(); 
		
		request.setAttribute("airlineList", airlines);
		
		RequestDispatcher rd = request.getRequestDispatcher("airline.jsp");
		rd.forward(request, response);
		
		
		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Airline airline = new Airline(0,(String) request.getParameter("name"));
		
		airlineDAO.save(airline);
		
		
		doGet(request, response);
	}
	
	

}
