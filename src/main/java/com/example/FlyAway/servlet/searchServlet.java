package com.example.FlyAway.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.FlyAway.dao.FlightDAO;
import com.example.FlyAway.model.Flight;
 
@WebServlet(name = "search", urlPatterns = { "/search" })
public class searchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	@Autowired
	FlightDAO flightDAO;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String arrival = request.getParameter("arrival");
		String departure =  request.getParameter("departure");
		Iterable<Flight> search = flightDAO.search((String)departure,(String) arrival,request.getParameter("date"));
		request.setAttribute("search",search);
		request.setAttribute("person", request.getParameter("person"));
		RequestDispatcher rd = request.getRequestDispatcher("search.jsp");
		rd.forward(request, response);
	}

	
}
