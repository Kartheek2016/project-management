package com.projectManagement;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class CurrentUserController {

	@RequestMapping(value ="/CurrentUser", method = RequestMethod.GET)
	public int signin(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();

		if(session != null && session.getAttribute("userId") != null){
                       return 200;
		}else{
                        return 401;
		} 

	}

}
