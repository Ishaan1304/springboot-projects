package com.jpa.test;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
@Controller
public class TestController {
	@RequestMapping("/test")
	@ResponseBody
	public String test()
	{
		int a=67;
		int b=89;
		int c=100;
		return "this is just testing  sum of a and b is "+(a+b+c);
	}
	
}
