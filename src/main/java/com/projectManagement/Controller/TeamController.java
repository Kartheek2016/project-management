package com.projectManagement;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.hibernate.Session;
import org.hibernate.Query;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {

	@RequestMapping("/TeamController")
	public List<User> management() {

		TeamDao teams = new TeamDao();
		List list = teams.getListOfTeams();
		System.out.println(list);

		return list;

	}

}
