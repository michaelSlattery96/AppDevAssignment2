package com.example.demo.controllers;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dao.ProjectDao;
import com.example.demo.domain.Member;
import com.example.demo.domain.Project;
import com.example.demo.service.MemberService;

@Controller
public class ProjectController {
	
	@Autowired
	MemberService memberServcie;

	@Autowired
	ProjectDao projectDao;
	
	@GetMapping("/showprojects")
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
		model.addAttribute("project", project);
		return "projectdetails";
	}
	
	@GetMapping("/editproject/{id}")
	public String editAProject(@PathVariable(name="id") int id, Model model, Locale locale) {
		
		Project project = projectDao.findById(id).get();
		if (project == null) {
			
			model.addAttribute("id", id);
			return "notFoundError";
		}
		model.addAttribute("project", project);
		return "editproject";
	}
	
	@Transactional
	@PutMapping("/projectdetails/{id}")
	public String editAProjectSave(@Valid Project project, @PathVariable(name="id") int id, Model model, Locale locale) {
		
		projectDao.updateProjectDescription(project.getProjectDescription(), id);
		
		model.addAttribute("project", projectDao.findById(id).get());
		
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
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails user = (UserDetails) auth.getPrincipal();
		Member member = memberServcie.findByEmail(user.getUsername());
		
		project.setCreator(member);

		projectDao.save(project);
		return "redirect:showprojects/";
	}
}