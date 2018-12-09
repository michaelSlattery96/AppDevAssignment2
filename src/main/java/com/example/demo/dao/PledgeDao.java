package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.domain.Pledge;
import com.example.demo.domain.Project;

public interface PledgeDao extends JpaRepository<Pledge, Integer> {

}
