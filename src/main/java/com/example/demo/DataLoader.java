package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.assignment2.dao.MemberDao;
import com.assignment2.domain.Member;

@Component
public class DataLoader implements ApplicationRunner {
	
	@Autowired
	MemberDao memberDao;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Member member = new Member("michael.slattery1@mycit.ie", "Michael", "Password");
		
		//memberDao.save(member);
		
		System.out.println("Test");
		//System.out.println(memberDao.findAll());
	}
}
