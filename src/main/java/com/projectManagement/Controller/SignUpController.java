package com.projectManagement;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.ArrayList;

@RestController
public class SignUpController {

	@RequestMapping(value = "/SignUp", method = RequestMethod.POST)
	public int signUp(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String fullName = request.getParameter("fName");
		String emailId = request.getParameter("email");
		String password = request.getParameter("pswd");
		List<User> list = new ArrayList<User>();
		int curUser = 0;

		SignUpDao signUpDao = new SignUpDao();
		boolean isCreated = signUpDao.signUpUserDetails(fullName, emailId, password);

		if(isCreated){
			UserDao dao = new UserDao();
			list = dao.getUserObj(emailId);

			Authorization auth = new Authorization();
			curUser = auth.checkOrCreateSession(request, list);
		}

		return curUser;

	}

}
