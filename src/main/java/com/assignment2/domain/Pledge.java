package com.assignment2.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pledge {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pledgeId;
	
	@Column(nullable=false)
	private int projectId;
	
	@Column(nullable=false)
	private String memberEmail;

	public int getPledgeId() {
		return pledgeId;
	}
	
	public Pledge(int pledgeId, int projectId, String memberEmail) {
		super();
		this.pledgeId = pledgeId;
		this.projectId = projectId;
		this.memberEmail = memberEmail;
	}
	
	public Pledge() {
		
	}

	public void setPledgeId(int pledgeId) {
		this.pledgeId = pledgeId;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
}
