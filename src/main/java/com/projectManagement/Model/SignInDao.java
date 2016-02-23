package com.projectManagement;

import org.hibernate.Session;  
import org.hibernate.Transaction;  
import org.hibernate.Query;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;

import java.util.List;
import java.util.ArrayList;

import java.security.*;

public class SignInDao{

	public boolean signInUserDetails( String email, String password){

		List<User> list = new ArrayList<User>();
 		Session session = HibernateSessionManager.getSessionFactory().openSession();
		session.beginTransaction();
		Transaction tx = null;
		User user = new User();

		try {
			tx = session.getTransaction();
			tx.begin();
			list =  session.createQuery("from User").list();

			for (int i = 0; i < list.size(); i++){
	 		 	user = (User)list.get(i);
	 			if(user.getEmailId().equals(email) && user.getPassword().equals(encryptPassword(password))){
	 		 		return true;
	 		 	}
	 		 }	

 			session.save(user);
			tx.commit();
	        } catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
	        } finally {
			session.close();
 		}

		return false;
	}

	public String encryptPassword(String password) {

		String passwordToHash = password;
		String generatedPassword = null;

		try {
			MessageDigest md = MessageDigest.getInstance("MD5");// Create MessageDigest instance for MD5
			md.update(passwordToHash.getBytes());//Add password bytes to digest
			byte[] bytes = md.digest();//Get the hash's bytes 
			StringBuilder sb = new StringBuilder();//This bytes[] has bytes in decimal format; Convert it to hexadecimal format
			for(int i=0; i< bytes.length ;i++){
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			generatedPassword = sb.toString();//Get complete hashed password in hex format
		}
		catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return generatedPassword;

    	}

}
