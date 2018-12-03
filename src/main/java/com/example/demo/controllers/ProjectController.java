package com.example.demo.controllers;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
	
	@GetMapping("/projectdetails/{id}")
	public String showAProject(@PathVariable(name="id") int id, Model model, Locale locale) {
		
		Project project = projectDao.findById(id).get();
		if (project == null) {
			model.addAttribute("id", id);
			return "notFoundError";
		}
		model.addAttribute("projectdetails", project);
		return "projectdetails";
	}
}
