package com.ishaan.UserManagementProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ishaan.UserManagementProject.entities.User;
import com.ishaan.UserManagementProject.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user)
	{
		User result=this.userService.addUser(user);
		return result;
	}
	
	@GetMapping("/getAll")
	public List<User> getAll(){
		List<User> result = userService.getAll();
		return result;
	}
}
