package com.example.demo.controllers;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dao.ProjectDao;
import com.example.demo.domain.Member;
import com.example.demo.service.MemberService;

@Controller
public class AccountController {

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
		
		model.addAttribute("member", member);
		
		return "profile";
	}
}
