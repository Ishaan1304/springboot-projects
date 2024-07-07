package com.ishaan.UserManagementProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ishaan.UserManagementProject.entities.User;

public interface UserDAO extends JpaRepository<User,Integer> {


}
