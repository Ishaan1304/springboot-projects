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

import com.ishaan.UserManagementProject.entities.Country;
import com.ishaan.UserManagementProject.services.CountryService;

@RestController
@RequestMapping("/country")
public class CountryController {
	
	@Autowired 
	private CountryService countryService;
	
	@PostMapping("/addCountry")
	public ResponseEntity<Country> addCountry(@RequestBody Country country)
	{
		Country result=null;
		try
		{
			result=this.countryService.addCountry(country);
			System.out.println(result);
			return  ResponseEntity.of(Optional.of(result));
		}catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping("/getCountries")
	public ResponseEntity<List<Country>> getCountries()
	{
		try
		{
			List<Country> result=this.countryService.getCountries();
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
	
	@GetMapping("/getCountry/{id}")
	public ResponseEntity<Country> getCountry(@PathVariable int id)
	{
		try
		{
			Country result=this.countryService.getCountryById(id);
			return ResponseEntity.status(HttpStatus.CREATED).body(result);
		}catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	
	@PutMapping("/updateCountry/{id}")
	public ResponseEntity<Country> updateCountry(@RequestBody Country country,@PathVariable("id") int id)
	{
		try
		{
			Country result=this.countryService.updateCountry(country,id);
			System.out.println(country);
			return ResponseEntity.ok().body(result);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	@DeleteMapping("/deleteCountry/{id}")
	public ResponseEntity<Country> deleteCountry(@PathVariable("id") int id)
	{
		try
		{
			System.out.println("-------------");
			Country result=this.countryService.deleteCountry(id);
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
