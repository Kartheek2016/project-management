package com.projectManagement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import java.util.List;
import java.util.ArrayList;

public class Authorization{

        HttpSession session;
	private int curUser = 0;

	public HttpSession sessionUser(){
		return session;
	}

	public int checkOrCreateSession(HttpServletRequest request, List<User> list) throws ServletException {

		int userId = list.get(0).getId();
		session = request.getSession();
		if(session != null){
			session = request.getSession(true);
			session.setAttribute("userId", userId);
			curUser = (Integer)session.getAttribute("userId");
			return curUser;
		}

		return curUser;

	}

}
