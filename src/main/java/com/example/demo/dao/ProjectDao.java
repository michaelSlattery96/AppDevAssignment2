package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.domain.Project;

public interface ProjectDao extends JpaRepository<Project, Integer> {
	
	List<Project> findAllByOrderByProjectNameAsc();

	@Modifying
	@Query("UPDATE Project p SET p.currentAmount=?1 WHERE p.projectId=?2")
	void updateProjectCurrentAmount(int currentAmount, int projectId);
	
	@Modifying
	@Query("UPDATE Project p SET p.projectDescription=?1 WHERE p.projectId=?2")
	void updateProjectDescription(String projectDescription, int projectId);
}
