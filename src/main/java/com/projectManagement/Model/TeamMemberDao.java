package com.projectManagement;

import java.util.List;
import java.util.ArrayList;

import org.hibernate.Session;  
import org.hibernate.Transaction;  
import org.hibernate.Query;

public class TeamMemberDao{

	public List<TeamMember> getListOfTeamMembers(){

		List<TeamMember> list = new ArrayList<TeamMember>();
		Session session = HibernateSessionManager.getSessionFactory().openSession();
		session.beginTransaction();
		Transaction tx = null;       

	        try {
			tx = session.getTransaction();
			tx.begin();
			list = (List<TeamMember>) session.createQuery("from TeamMember").list();
			session.save(list);
			tx.commit();
	        } catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
	        } finally {
			session.close();
	        }

	        return list;

	}

}
