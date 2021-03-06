package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.domain.Member;
import com.example.demo.domain.Project;

public interface MemberDao extends JpaRepository<Member, Integer> {
	
	boolean existsByMemberEmail(String memberEmail);

	@Query("SELECT m FROM Member m WHERE m.memberEmail=:memberEmail")
	Member findByEmail(@Param("memberEmail") String memberEmail);
	@Query("SELECT m FROM Member m JOIN Project p ON p.creator=m WHERE p.projectName=:projectName")
	List<Project> findMembersWithProjects(@Param("projectName") String projectName);
}
