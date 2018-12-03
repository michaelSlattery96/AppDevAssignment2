package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Pledge;

public interface PledgeDao extends JpaRepository<Pledge, Integer> {

}
