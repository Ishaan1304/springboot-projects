package com.ishaan.UserManagementProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ishaan.UserManagementProject.entities.State;

public interface StateDAO extends JpaRepository<State,Integer> {
	public State deleteById(int id);
	public State findById(int id);
}
