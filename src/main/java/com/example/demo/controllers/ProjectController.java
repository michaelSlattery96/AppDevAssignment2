package com.example.demo.controllers;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@GetMapping("/newproject")
	public String addNewProjectForm(Model model)
	{
		
		model.addAttribute("project", new Project());
		return "newproject";
	}
	
	@PostMapping("/newproject")
	public String addNewProjectSave(@Valid Project project, BindingResult binding, RedirectAttributes redirectAttributes) {
	System.out.println(project);
		projectDao.save(project);
		return "redirect:projectDetails/"+project.getProjectId();
	}
}