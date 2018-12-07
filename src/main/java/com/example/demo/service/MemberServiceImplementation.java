package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MemberDao;
import com.example.demo.domain.Member;
import com.example.demo.domain.Project;

@Service
public class MemberServiceImplementation implements MemberService {
	
	@Autowired
	MemberDao memberDao;
	
	@Override
	public Member findById(int id) {
		
		return memberDao.findById(id).get();
	}

	@Override
	public List<Project> findMembersWithProjects(String projectName) {
		
		return memberDao.findMembersWithProjects(projectName);
	}
}
