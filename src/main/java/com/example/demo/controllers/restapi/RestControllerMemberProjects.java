package com.example.demo.controllers.restapi;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.MemberDao;
import com.example.demo.dao.ProjectDao;
import com.example.demo.domain.Member;
import com.example.demo.domain.Project;

import ch.qos.logback.core.net.SyslogOutputStream;

@RestController
@RequestMapping("/api")
public class RestControllerMemberProjects {

	@Autowired
	MemberDao memberDao;
			
	@GetMapping("/profile/{memberEmail}")
	List<Project> membersProjects(@PathVariable(name="memberEmail") String memberEmail) {
		System.out.println("Hello World");
//		Member member = memberDao.findByEmail(memberEmail);
		
//		return member.getProjects();
		
		return null;
		
	}
	
}
