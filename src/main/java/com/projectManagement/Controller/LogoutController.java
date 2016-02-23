package com.projectManagement;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet; 

import java.io.IOException;  
import java.io.PrintWriter;

@RestController
public class LogoutController extends HttpServlet {

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public boolean project1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	

		HttpSession session = request.getSession(false); 
		if(session != null) {
			session.invalidate();
			response.sendRedirect("index.html");
			return true;
		}

		return false;

	}

}
