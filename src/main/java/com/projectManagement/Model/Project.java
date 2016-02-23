package com.projectManagement;

import java.util.Set;
import java.io.Serializable;
import java.io.*;

import javax.persistence.*;

@Entity
@Table(name = "PROJECTS")
public class Project implements Serializable {
   	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "PROJECT_NAME")
	private String projectName;
	
	@ManyToOne
	@JoinColumn(name = "OWNER")
	private User user1;
	private int owner;
	
	@OneToMany(mappedBy ="project", fetch = FetchType.EAGER)
	private Set<ProjectMember> projectMember;
	
	public Project() {
 
    	}
 
    	public Project(int id, String projectName, int owner) {
        	this.id = id;
        	this.projectName = projectName;
        	this.owner = owner;
    	}
	
	public int getOwner() {
      		return owner;
   	}
   	
	public void setOwner( int owner ) {
      		this.owner = owner;
   	}

	public int getId() {
      		return id;
   	}
   	
	public void setId( int id ) {
      		this.id = id;
   	}
	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public User gerUser1(){
	 	return user1;
	 }
	 public void setUser(User user1){
	 	this.user1 = user1;
	 }
	 public Set<ProjectMember> getProjectMember(){
	 	return projectMember;
	 }
	 public void setProjectMember(Set<ProjectMember> projectMember){
	 	this.projectMember = projectMember;
	 }	

}
