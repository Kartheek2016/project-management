package com.projectManagement;

import java.util.List;
import java.util.ArrayList;
import java.lang.StringBuilder;

import org.hibernate.Session;  
import org.hibernate.Transaction;  
import org.hibernate.Query;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;

public class UserDao{

	List<User> list = new ArrayList<User>();

	public List<User> getListOfUsers(){

		Session session = HibernateSessionManager.getSessionFactory().openSession();
		session.beginTransaction();
		Transaction tx = null;       

	        try {
			tx = session.getTransaction();
			tx.begin();
			list = (List<User>) session.createQuery("from User").list();
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

	public List<User> getUserObj(String email){
		
		Session session = HibernateSessionManager.getSessionFactory().openSession();
		session.beginTransaction();
		Transaction tx = null;  

		try {
			tx = session.getTransaction();
			tx.begin();
			StringBuilder query = new StringBuilder();
			email = query.append("from User where emailId = '").append(email).append("'").toString();
			list = (List<User>) session.createQuery(email).list();
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
