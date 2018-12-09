package com.example.demo.controllers.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ProjectDao;
import com.example.demo.domain.Project;

@RestController
@RequestMapping("/api")
public class RestControllersProjects {

	@Autowired
	ProjectDao projectDao;
	
	@GetMapping("projects")
	List<Project> myRestProjects() {
		
		return projectDao.findAllByOrderByProjectNameAsc();
	}
}
