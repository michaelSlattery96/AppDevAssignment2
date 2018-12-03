package com.example.demo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.demo.dao.MemberDao;
import com.example.demo.dao.ProjectDao;
import com.example.demo.domain.Member;
import com.example.demo.domain.Project;

@Component
public class DataLoader implements ApplicationRunner {
	
	@Autowired
	MemberDao memberDao;
	
	@Autowired
	ProjectDao projectDao;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Member member1 = new Member("michael.slattery1@mycit.ie", "Michael", "Password");
		Member member2 = new Member("allen.simbul@mycit.ie", "Allen", "Password");
		
		Project project1 = new Project("Project 1", "", 50, 0, LocalDate.now(), member1.getMemberId());
		Project project2 = new Project("Project 2", "", 50, 0, LocalDate.now(), member1.getMemberId());
		Project project3 = new Project("Project 3", "", 50, 0, LocalDate.now(), member1.getMemberId());
		
		memberDao.save(member1);
		memberDao.save(member2);
		
		projectDao.save(project1);
		projectDao.save(project2);
		projectDao.save(project3);
		
		System.out.println(memberDao.findAll());
		System.out.println(projectDao.findAll());
	}
}
