package com.example.demo.controllers;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dao.ProjectDao;
import com.example.demo.domain.Project;

@Controller
public class ProjectController {

	@Autowired
	ProjectDao projectDao;
	
	@GetMapping("/projects")
	public String showProjects(Model model, Locale locale) {
		List<Project> projects = projectDao.findAll();
		model.addAttribute("projects", projects);
		return "projects";
	}
}
