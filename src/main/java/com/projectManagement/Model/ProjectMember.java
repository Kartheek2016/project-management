package com.projectManagement;

import java.util.Set;
import java.io.Serializable;
import java.io.*;


import javax.persistence.*;

@Entity
@Table(name = "PROJECT_MEMBERS")
public class ProjectMember implements Serializable {
   	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  	@Column(name = "ID")
  	private int id;	

    	@Column(name = "PROJECT_ID")
	private int projectId;	

	@Column(name = "MEMBER_ID")
	private int memberId;

	@Column(name = "OWNER")
	private boolean owner;
	
	@ManyToOne
	@JoinColumn(name="ID", insertable=false , updatable=false)
	private Project project;
	

	public 	ProjectMember() {
 
    	}
 
    	public ProjectMember(int id, int projectId, int memberId, boolean owner) {
        	this.id = id;
        	this.projectId = projectId;
        	this.memberId = memberId;
        	this.owner = owner;
    	}
	
	public int getId() {
      		return id;
   	}

   	public void setId( int id ) {
      		this.id = id;
   	}
	
	public int getProjectId() {
      		return projectId;
   	}

   	public void setProjectId( int projectId ) {
      		this.projectId = projectId;
   	}
	
	public int getMemberId() {
      		return memberId;
   	}

   	public void setMemberId( int memberId ) {
      		this.memberId = memberId;
   	}

	public boolean getOwner() {
      		return owner;
   	}

   	public void setOwner( boolean owner ) {
      		this.owner = owner;
   	}
   	
   	/*public Project getProject(){
   		return project;
   	}
   	public void setProject( Project project){
   		this.project = project;
   	}*/
	
}
