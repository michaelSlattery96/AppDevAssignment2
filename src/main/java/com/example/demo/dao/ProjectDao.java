package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.domain.Project;

public interface ProjectDao extends JpaRepository<Project, Integer> {

	@Modifying
	@Query("UPDATE Project p SET p.projectDescription=?1 WHERE p.projectId=?2")
	void updateProjectDescription(String projectDescription, int projectId);
}
