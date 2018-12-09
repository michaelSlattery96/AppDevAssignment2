package com.example.demo.controllers.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ProjectDao;
import com.example.demo.domain.Member;
import com.example.demo.domain.Project;
import com.example.demo.service.MemberService;

@RestController
@RequestMapping("/api")
public class RestControllersProjects {
	
	@Autowired
	MemberService memberService;

	@Autowired
	ProjectDao projectDao;
	
	@GetMapping("projects")
	List<Project> myRestProjects() {
		
		return projectDao.findAllByOrderByProjectNameAsc();
	}
	
	@GetMapping("userProjects/{id}")
	List<Project> userRestProjects(@PathVariable("id") int id) {
		
		Member member = memberService.findById(id);
		
		return member.getProjects();
	}
}
