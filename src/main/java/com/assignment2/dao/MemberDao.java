package com.assignment2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment2.domain.Member;

public interface MemberDao extends JpaRepository<Member, Integer> {

	Member findMemberByName(String memberName);
}
