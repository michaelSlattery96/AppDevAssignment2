package com.example.demo.controllers;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dao.MemberDao;
import com.example.demo.dao.RoleDao;
import com.example.demo.domain.Member;
import com.example.demo.domain.Role;

@Controller
public class SignUpController {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	MemberDao memberDao;
	
	@Autowired
	RoleDao roleDao;

	@GetMapping("/signup")
	public String addNewMemberForm(Model model, Locale locale) {
		
		model.addAttribute("member", new Member());
		return "signup";
	}
	
	@PostMapping("/signup")
	public String addNewMemberSave(@Valid Member member, BindingResult binding, RedirectAttributes redirectAttributes) {
		Role userRole = new Role(member.getMemberEmail(), "User");
		
		roleDao.save(userRole);
		
		member.setMemberPassword(passwordEncoder.encode(member.getMemberPassword()));
		member.setMemberRole(userRole);
		member.setMemberEnabled(true);
				
		if (binding.hasErrors()) {
			
			return "signup";
		}
		if (memberDao.save(member) != null) {
			return "index";
		} else {
			
			redirectAttributes.addFlashAttribute("duplicate", true);
			return "redirect:signup";
		}
	}
}
