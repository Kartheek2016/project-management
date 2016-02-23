package com.projectManagement;

import java.util.List;
import java.util.ArrayList;

import org.hibernate.Session;  
import org.hibernate.Transaction;  
import org.hibernate.Query;

public class ProjectMemberDao{

	public List<ProjectMember> getListOfProjectMembers(){
		List<ProjectMember> list = new ArrayList<ProjectMember>();

		Session session = HibernateSessionManager.getSessionFactory().openSession();
		session.beginTransaction();

		Transaction tx = null;       
		try {
			tx = session.getTransaction();
			tx.begin();
			list = (List<ProjectMember>) session.createQuery("from ProjectMember").list();
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
