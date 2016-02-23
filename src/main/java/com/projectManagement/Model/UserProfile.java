package com.projectManagement;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "USER_PROFILES")
public class UserProfile implements Serializable {
   	
	@Id
	@Column(name = "ID")
	private int id;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="USER_ID")
	private int userId;

	@Column(name = "PHONE_NUMBER")
	private long phoneNumber;

	@OneToOne
	@PrimaryKeyJoinColumn
	private User user;

	public void UserProfile() {

	}

	public void UserProfile(int userId, long phoneNumber, User user) {
		this.userId = userId;
		this.phoneNumber = phoneNumber;
		this.user = user;
    	}

	public int getId() {
		return id;
	}

   	public void setId( int id ) {
		this.id = id;
	}
	
	public int getUserId(){
	   	return userId;
	}

	public void setUserId( int userId ) {
		this.userId = userId;
	}

	public long getPhoneNumber() {
      		return phoneNumber;
   	}
   	
	public void setPhoneNumber( long phoneNumber ) {
      		this.phoneNumber = phoneNumber;
   	}

}
