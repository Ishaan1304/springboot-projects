package com.ishaan.UserManagementProject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<User> addUser(@RequestBody User user)
	{
		User result=null;
		try
		{
			result=this.userService.addUser(user);
			System.out.println(result);
			return  ResponseEntity.of(Optional.of(result));
		}catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping("/getUsers")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> result=null;
		try
		{
			result = userService.getAllUsers();
			if(result.size()<=0)
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
		}catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping("/getUser/{id}")
	public ResponseEntity<User> getUser(@PathVariable int id){
		User result=null;
		try
		{
			result=userService.getUserById(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
		}catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable int id)
	{
		User result=null;
		try
		{
			result=userService.updateUser(user,id);
			System.out.println(result);
			return ResponseEntity.ok().body(result);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable int id)
	{
		try
		{
			User result=userService.deleteUser(id);
			System.out.println(result);
			return ResponseEntity.ok().body(result);
		}catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
}
