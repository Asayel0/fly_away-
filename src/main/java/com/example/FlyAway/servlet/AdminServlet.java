package com.example.FlyAway.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.FlyAway.dao.AdminDao;
import com.example.FlyAway.model.Admin;


@WebServlet(name = "admin", urlPatterns = { "/admin" })
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	AdminDao adminDao;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admin admin = adminDao.findByUsernameAndPassword(request.getParameter("username"),request.getParameter("password"));
		
		if(admin == null) {
			
			response.sendRedirect("/");
		}else {
			HttpSession session = request.getSession();
			session.setAttribute( "username", request.getParameter("username"));
			response.sendRedirect("dashboard.jsp");
		}
	}


}
