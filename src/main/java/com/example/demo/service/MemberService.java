package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Member;
import com.example.demo.domain.Project;

public interface MemberService {
	
	Member findById(int id);
	List<Project> findMembersWithProjects(String projectName);
}
