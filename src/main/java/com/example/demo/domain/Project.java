package com.example.demo.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int projectId;
	
	@Column(nullable=false)
	private String projectName;
	
	@Column(nullable=false)
	private String projectDescription;
	
	@Column(nullable=false)
	private int targetAmount;

	@Column(nullable=false)
	private int currentAmount;
	
	@Column(nullable=false)
	private LocalDate dateCreated;
	
	@JsonIgnore
	@ManyToOne( fetch=FetchType.EAGER)
    @JoinColumn(nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private Member creator;
	
	@JsonIgnore
	@OneToMany(mappedBy="project", fetch=FetchType.EAGER, cascade= CascadeType.ALL)
	private List<Pledge> pledges = new ArrayList<Pledge>();
	
	public Project(String projectName, String projectDescription, int targetAmount, int currentAmount,
			LocalDate dateCreated, Member creator) {
		super();
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.targetAmount = targetAmount;
		this.currentAmount = currentAmount;
		this.dateCreated = dateCreated;
		this.creator = creator;
	}
	
	public Project() {
		this.dateCreated = LocalDate.now();
	}

	public int getProjectId() {
		return projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public int getTargetAmount() {
		return targetAmount;
	}

	public void setTargetAmount(int targetAmount) {
		this.targetAmount = targetAmount;
	}

	public int getCurrentAmount() {
		return currentAmount;
	}

	public void setCurrentAmount(int currentAmount) {
		this.currentAmount = currentAmount;
	}
	
	public List<Pledge> getPledge() {
		return pledges;
	}

	public void setPledge(List<Pledge> pledges) {
		this.pledges = pledges;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Member getCreator() {
		return creator;
	}

	public void setCreator(Member creator) {
		this.creator = creator;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", projectDescription="
				+ projectDescription + ", targetAmount=" + targetAmount + ", currentAmount=" + currentAmount
				+ ", dateCreated=" + dateCreated + ", creatorId=" + creator + "]";
	}
}
