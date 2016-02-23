package com.projectManagement;

import java.util.List;
import java.util.ArrayList;

import org.hibernate.Session;  
import org.hibernate.Transaction;  
import org.hibernate.Query;

public class UserProfileDao{

	public List<UserProfile> getListOfUserProfiles(){

		List<UserProfile> list = new ArrayList<UserProfile>();
		Session session = HibernateSessionManager.getSessionFactory().openSession();
		session.beginTransaction();
		Transaction tx = null;       

		try {
			tx = session.getTransaction();
			tx.begin();
			list = (List<UserProfile>) session.createQuery("from UserProfile").list();
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
