package com.ishaan.UserManagementProject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ishaan.UserManagementProject.dao.CityDAO;

import com.ishaan.UserManagementProject.entities.City;

@Service
public class CityService {
	@Autowired
	CityDAO cityDAO;
	
	public City addCity(City city)
	{
		City result=this.cityDAO.save(city);
		return result;
	}
	
	public List<City> getCitys()
	{
		List<City> list=null;
		try
		{
			list=this.cityDAO.findAll();
			return list;
		}catch(Exception e)
		{
			e.getMessage();
			return list;
		}
		
	}
	
	public City getCityById(int id)
	{
		City result=null;
		try
		{
			result=this.cityDAO.findById(id);
			return result;
		}catch(Exception e)
		{
			e.getMessage();
			return result;
		}
		
	}
	
	public City updateCity(City city,int id)
	{
		City result=null;
		try
		{
			city.setId(id);
			result=this.cityDAO.save(city);
			return result;
		}catch(Exception e)
		{
			e.getMessage();
			return result;
		}
		
	}
	
	public City deleteCity(int id)
	{
		City result=null;
		try
		{
			result=this.cityDAO.deleteById(id);
			return result;
		}catch(Exception e)
		{
			e.getMessage();
			return result;
		}
		
	}

	
	
}
