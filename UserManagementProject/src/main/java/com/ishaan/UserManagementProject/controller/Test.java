package com.ishaan.UserManagementProject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class Test {
	
	@GetMapping("/test1")
	public String test()
	{
		return "test";
	}
}
