package com.example.demo.controllers;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dao.MemberDao;
import com.example.demo.domain.Member;

@Controller
public class SignUpController {
	
	@Autowired
	MemberDao memberDao;

	@GetMapping("/signup")
	public String addNewMemberForm(Model model, Locale locale) {
		
		model.addAttribute("member", new Member());
		return "signup";
	}
	
	@PostMapping("/signup")
	public String addNewMemberSave(@Valid Member member, BindingResult binding, RedirectAttributes redirectAttributes) {
		System.out.println("binding.hasErrors() " + binding.hasErrors());
		System.out.println("Test Hello World " + memberDao.save(member));
		if (binding.hasErrors()) {
			
			return "signup";
		}
		System.out.println("Test Hello World " + (memberDao.save(member) != null));
		if (memberDao.save(member) != null) {
			System.out.println("Test SignUpController " + memberDao);
			return "redirect:index/";
		} else {
			
			redirectAttributes.addFlashAttribute("duplicate", true);
			return "redirect:signup";
		}
	}
}
