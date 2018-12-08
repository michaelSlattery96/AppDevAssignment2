package com.example.demo.controllers;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.service.MemberService;
import com.example.demo.dao.ProjectDao;
import com.example.demo.domain.Member;

@Controller
public class ProfileController {
	
	@Autowired
	MemberService memberServcie;
	
	@Autowired
	ProjectDao projectDao;
	
	@GetMapping("/profile")
	public String showProjectsInProfile(Model model, Locale locale) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		UserDetails user = (UserDetails) auth.getPrincipal();
		
		Member member = memberServcie.findByEmail(user.getUsername());
		
		if (member == null) {
			
			return "403";
		}
		
		model.addAttribute("memberId", member.getMemberId());
		
		return "profile";
	}
	
	@GetMapping("/userprojects/{id}")
	public String showUserProjects(@PathVariable(name="id") int id, Model model, Locale locale) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		UserDetails user = (UserDetails) auth.getPrincipal();
		
		Member member = memberServcie.findByEmail(user.getUsername());
		
		if (member == null || member.getMemberId() != id) {
			
			model.addAttribute("id", id);
			return "403";
		}
		
		model.addAttribute("member", member);
		
		return "userprojects";
	}
	
}
