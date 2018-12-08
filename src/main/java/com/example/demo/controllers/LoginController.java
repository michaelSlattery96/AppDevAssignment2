package com.example.demo.controllers;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping(value = "/login")
	public String login(Locale locale) 
	{
		
		return "login";
	}
	
	@GetMapping(value="/logout")
	public String register(HttpSession session)
	{
		session.removeAttribute("member");
		//session.invalidate();
		return "index";
	}
	
	@GetMapping("/loggedin")
	public void login(HttpSession session) 
	{
		if (session.getAttribute("loggedin") == null) {
			session.setAttribute("loggedin",  true);
		}
	}
}
