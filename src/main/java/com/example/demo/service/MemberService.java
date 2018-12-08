package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Member;
import com.example.demo.domain.Project;

public interface MemberService {
	
	Member findById(int id);
	Member findByEmail(String email);
	List<Project> findMembersWithProjects(String projectName);
	Member save(Member member);
}
