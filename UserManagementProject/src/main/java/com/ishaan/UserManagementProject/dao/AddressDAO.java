package com.ishaan.UserManagementProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ishaan.UserManagementProject.entities.Address;

public interface AddressDAO extends JpaRepository<Address,Integer> {

}
