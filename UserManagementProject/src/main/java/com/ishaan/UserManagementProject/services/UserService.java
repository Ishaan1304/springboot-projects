package com.ishaan.UserManagementProject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ishaan.UserManagementProject.dao.UserDAO;
import com.ishaan.UserManagementProject.entities.User;

@Service
public class UserService {
	@Autowired
	private UserDAO userDAO;
	
	public User addUser(User user)
	{
		User result=null;
		try
		{
			result=this.userDAO.save(user);
			return result;
		}catch(Exception e)
		{
			e.getMessage();
			return result;
			
		}
	}
	
	public  List<User> getAllUsers()
	{
		List<User> result=null;
		try
		{
			result=this.userDAO.findAll();
			return result;
		}catch(Exception e)
		{
			e.getMessage();
			return result;
		}
	}
	
	public  User getUserById(int id)
	{
		User result =null;
		try
		{
			 result=this.userDAO.findById(id);
			 return result;
		}catch(Exception e)
		{
			e.getMessage();
			return result;
		}
	}
	
	public  User updateUser(User user,int id)
	{
		User result=null;
		try
		{
			user.setId(id);
			result = this.userDAO.save(user);
			return result;
		}catch(Exception e)
		{
			e.getMessage();
			return result;
		}
	}
	
	public  User deleteUser(int id)
	{
		User result=null;
		try
		{
			result = this.userDAO.deleteById(id);
			return result;
		}catch(Exception e)
		{
			e.getMessage();
			return result;
		}
		
	}
	
}
