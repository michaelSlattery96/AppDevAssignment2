package com.assignment2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment2.domain.Role;

public interface RoleDao extends JpaRepository<Role, Integer>{

}
