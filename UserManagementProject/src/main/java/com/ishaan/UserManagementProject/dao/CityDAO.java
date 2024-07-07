package com.ishaan.UserManagementProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ishaan.UserManagementProject.entities.City;



public interface CityDAO extends JpaRepository<City,Integer> {
	public City deleteById(int id);
	public City findById(int id);
}
