package com.projectManagement;
import java.util.Set;
import java.io.Serializable;
import java.io.*;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class User implements Serializable {
   	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "USER_NAME")
	private String userName;
	
	@Column(name = "EMAIL_ID", unique = true)
	private String emailId;

	@Column(name = "PASSWORD")
	private String password;

	@OneToOne(mappedBy="user")
    	private UserProfile userProfile;
    	
    	@OneToMany(mappedBy ="user1", fetch = FetchType.EAGER)
    	private Set<Project> project;
    	

	public 	User() {
	}

	public void User(int id, String userName, String emailId, String password, UserProfile userProfile) {
		this.id = id;
		this.userName = userName;
		this.emailId = emailId;
		this.password = password;
		this.userProfile = userProfile;
    	}

	public int getId() {
		return id;
	}

   	public void setId( int id ) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	public Set<Project> getProject(){
	 	return project;
	}
	public void setProject(Set<Project> project){
		this.project = project;
	}	
		
}
