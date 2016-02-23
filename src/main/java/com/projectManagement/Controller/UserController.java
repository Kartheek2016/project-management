package com.projectManagement;

import java.util.List;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Query;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@RequestMapping("/UserController")
	public List<User> management() {

		UserDao users = new UserDao();
		List list = users.getListOfUsers();

		return list;

	}

}
