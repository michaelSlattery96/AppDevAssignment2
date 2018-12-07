package com.example.demo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.demo.dao.MemberDao;
import com.example.demo.dao.ProjectDao;
import com.example.demo.dao.RoleDao;
import com.example.demo.domain.Member;
import com.example.demo.domain.Project;
import com.example.demo.domain.Role;

@Component
public class DataLoader implements ApplicationRunner {
	
	@Autowired
	MemberDao memberDao;
	
	@Autowired
	ProjectDao projectDao;
	
	@Autowired
	RoleDao roleDao;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Role role1 = new Role("michael.slattery1@mycit.ie", "USER");
		Role role2 = new Role("allen.simbul@mycit.ie", "ADMIN");
		
		roleDao.save(role1);
		roleDao.save(role2);
		
		Member member1 = new Member("michael.slattery1@mycit.ie", "Michael", passwordEncoder.encode("Password"), role1, true);
		Member member2 = new Member("allen.simbul@mycit.ie", "Allen", passwordEncoder.encode("Password"), role2, true);
		
		memberDao.save(member1);
		memberDao.save(member2);
		
		Project project1 = new Project("Project 1", "", 50, 0, LocalDate.now(), member1);
		Project project2 = new Project("Project 2", "", 100, 10, LocalDate.now(), member1);
		Project project3 = new Project("Project 3", "", 150, 20, LocalDate.now(), member2);
		
		projectDao.save(project1);
		projectDao.save(project2);
		projectDao.save(project3);
	}
}
