package com.ishaan.UserManagementProject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ishaan.UserManagementProject.dao.AddressDAO;
import com.ishaan.UserManagementProject.entities.Address;

@Service
public class AddressService {
	
	@Autowired
	private AddressDAO addressDAO;
	
	public Address addAddress(Address address)
	{
		Address result=this.addressDAO.save(address);
		return result;
	}
	
	
}
