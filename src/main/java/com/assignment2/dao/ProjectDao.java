package com.assignment2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment2.domain.Project;

public interface ProjectDao extends JpaRepository<Project, Integer> {

}
