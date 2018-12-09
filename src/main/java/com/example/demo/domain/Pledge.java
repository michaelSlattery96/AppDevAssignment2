package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Pledge {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pledgeId;
	
	@ManyToOne( fetch=FetchType.EAGER)
    @JoinColumn(nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private Project project;
	
	@ManyToOne( fetch=FetchType.LAZY)
	@JoinColumn(nullable = false)
	private Member member;

	public int getPledgeId() {
		return pledgeId;
	}
	
	public Pledge(int pledgeId, Project project, Member member) {
		super();
		this.pledgeId = pledgeId;
		this.project = project;
		this.member = member;
	}
	
	public Pledge() {
		
	}

	public void setPledgeId(int pledgeId) {
		this.pledgeId = pledgeId;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return "Pledge [pledgeId=" + pledgeId + ", project=" + project + ", member=" + member + "]";
	}
}
