package com.example.demo.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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
	
	@Column(nullable=false)
	private int creatorId;
	
	public Project(String projectName, String projectDescription, int targetAmount, int currentAmount,
			LocalDate dateCreated, int creatorId) {
		super();
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.targetAmount = targetAmount;
		this.currentAmount = currentAmount;
		this.dateCreated = dateCreated;
		this.creatorId = creatorId;
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

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	public int getCreator() {
		return creatorId;
	}

	public void setCreator(int creatorId) {
		this.creatorId = creatorId;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", projectDescription="
				+ projectDescription + ", targetAmount=" + targetAmount + ", currentAmount=" + currentAmount
				+ ", dateCreated=" + dateCreated + ", creatorId=" + creatorId + "]";
	}
}
