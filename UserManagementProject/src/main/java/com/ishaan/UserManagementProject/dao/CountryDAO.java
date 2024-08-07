package com.ishaan.UserManagementProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ishaan.UserManagementProject.entities.Country;

public interface CountryDAO extends JpaRepository<Country,Integer> {
	public Country deleteById(int id);
	public Country findById(int id);
}
