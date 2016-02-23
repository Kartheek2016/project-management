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
public class TeamMemberController {

	@RequestMapping("/TeamMemberController")
	public List<TeamMember> management() {

		TeamMemberDao members = new TeamMemberDao();
		List list = members.getListOfTeamMembers();
		System.out.println(list);

		return list;

	}

}
