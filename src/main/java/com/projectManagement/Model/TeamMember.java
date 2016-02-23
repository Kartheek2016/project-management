package com.projectManagement;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "TEAM_MEMBERS")
public class TeamMember {
   	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  	@Column(name = "ID")
  	private int id;	

	@OneToMany
    	@JoinColumn(name = "TEAM_ID")
	private Set<Team> team;	

	@Column(name = "MEMBER_ID")
	private int memberId;

	@OneToOne
    	@JoinColumn(name = "USER_ID")
	private User user;

	@Column(name = "TEAM_LEADER")
	private boolean teamLeader;

	public 	TeamMember() {
 
    	}
 
    	public TeamMember(int id, int memberId, boolean teamLeder) {
        	this.id = id;
        	this.memberId = memberId;
        	this.teamLeader = teamLeader;
    	}

	public int getId() {
      		return id;
   	}

   	public void setId( int id ) {
      		this.id = id;
   	}
	
	public boolean getTeamLeader() {
      		return teamLeader;
   	}

   	public void setOwner( boolean teamLeader ) {
      		this.teamLeader = teamLeader;
   	}

}
