package com.ishaan.UserManagementProject.services;

import java.util.List;

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
		Address result=null;
		try
		{
			result=this.addressDAO.save(address);
			return result;
		}catch(Exception e)
		{
			e.getMessage();
			return result;
		}
	}
	
	public List<Address> getAddressess()
	{
		List<Address> result=null;
		try
		{
			result=this.addressDAO.findAll();
			return result;
		}catch(Exception e)
		{
			e.getMessage();
			return result;
		}
		
	}
	
	public Address getAddressById(int id)
	{
		Address result=null;
		try
		{
			result=this.addressDAO.findById(id);
			return result;
		}catch(Exception e)
		{
			e.getMessage();
			return result;
		}
	}
	
	
	public Address updateAddress(Address address,int id)
	{
		Address result=null;
		try
		{
			address.setId(id);
			result=this.addressDAO.save(address);
			return result;
		}catch(Exception e)
		{
			e.getMessage();
			return result;
		}
	}
	
	public Address deleteAddress(int id)
	{
		Address result=null;
		try
		{
			result=this.addressDAO.deleteById(id);;
			return result;
		}catch(Exception e)
		{
			e.getMessage();
			return result;
		}
	}
	
}
