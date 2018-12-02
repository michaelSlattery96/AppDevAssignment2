package com.assignment2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment2.domain.Pledge;

public interface PledgeDao extends JpaRepository<Pledge, Integer> {

}
