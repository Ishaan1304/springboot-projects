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
	
	public  User addUser(User user)
	{
		User result=this.userDAO.save(user);
		return result;
	}
	
	public  List<User> getAll()
	{
		List<User> ls = userDAO.findAll();
		return ls;
	}
	
}
