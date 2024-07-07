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

import com.ishaan.UserManagementProject.entities.City;
import com.ishaan.UserManagementProject.services.CityService;

@RestController
@RequestMapping("/city")
public class CityController {
	@Autowired
	private CityService cityService;
	
	@PostMapping("/addCity")
	public ResponseEntity<City> addCity(@RequestBody City city)
	{
		City result=null;
		try
		{
			result=this.cityService.addCity(city);
			System.out.println(city);
			return  ResponseEntity.of(Optional.of(result));
		}catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@GetMapping("/getCities")
	public ResponseEntity<List<City>> getCitys()
	{
		try
		{
			List<City> result=this.cityService.getCitys();
			System.out.println(result);
			if(result.size()<=0)
			{
				 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return ResponseEntity.status(HttpStatus.CREATED).body(result);
		}catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	
	@GetMapping("/getCity/{id}")
	public ResponseEntity<City> getCity(@PathVariable int id)
	{
		try
		{
			City result=this.cityService.getCityById(id);
			System.out.println(result);
			return ResponseEntity.status(HttpStatus.CREATED).body(result);
		}catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	
	@PutMapping("/updateCity/{id}")
	public ResponseEntity<City> updateCity(@RequestBody City city,@PathVariable("id") int id)
	{
		try
		{
			City result=this.cityService.updateCity(city,id);
			System.out.println(result);
			return ResponseEntity.ok().body(result);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	@DeleteMapping("/deleteCity/{id}")
	public ResponseEntity<City> deleteCity(@PathVariable("id") int id)
	{
		try
		{
			City result=this.cityService.deleteCity(id);
			System.out.println(result);
			return ResponseEntity.ok().body(result);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
}
