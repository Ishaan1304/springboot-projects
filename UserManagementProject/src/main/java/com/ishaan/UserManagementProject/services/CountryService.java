package com.ishaan.UserManagementProject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ishaan.UserManagementProject.dao.CountryDAO;
import com.ishaan.UserManagementProject.entities.Country;

@Service
public class CountryService {
	
	@Autowired
	private CountryDAO countryDAO;
	
	public Country getCountryById(int id)
	{
		Country country=null;
		try
		{
			country=this.countryDAO.findById(id);
			return country;
		}catch(Exception e)
		{
			e.getMessage();
			return country;
		}
	}
	
	public List<Country> getCountries()
	{
		List<Country> list=null;
		try
		{
			list=this.countryDAO.findAll();
			return list;
		}catch(Exception e)
		{
			e.getMessage();
			return list;
		}
	}
	
	public Country addCountry(Country country)
	{
		Country result=null;
		try
		{
			result=this.countryDAO.save(country);
			return result;
		}catch(Exception e)
		{
			e.getMessage();
			return result;
		}
		
	}
	
	public Country updateCountry(Country country,int id)
	{
		Country result=null;
		try
		{
			country.setId(id);
			result=this.countryDAO.save(country);
			return result;
		}catch(Exception e)
		{
			e.getMessage();
			return result;
		}
		
	}
	
	public Country deleteCountry(int id)
	{
		Country result=null;
		try
		{
			result=this.countryDAO.deleteById(id);
			return result;
		}catch(Exception e)
		{
			e.getMessage();
			return result;
		}
		
	}
	
}
