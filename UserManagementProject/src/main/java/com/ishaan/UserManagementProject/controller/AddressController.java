package com.ishaan.UserManagementProject.controller;

import java.util.List;

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

import com.ishaan.UserManagementProject.entities.Address;

import com.ishaan.UserManagementProject.services.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@PostMapping("/addAddress")
	public ResponseEntity<Address> addAddress(@RequestBody Address address)
	{
		Address result=null;
		try
		{
			result=addressService.addAddress(address);
			System.out.println(result);
			return  new ResponseEntity<Address>(result, HttpStatus.CREATED);
		}catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping("/getAddressess")
	public ResponseEntity<List<Address>> getAddressess()
	{
		try
		{
			List<Address> result=this.addressService.getAddressess();
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
	
	@GetMapping("/getAddress/{id}")
	public ResponseEntity<Address> getAddress(@PathVariable int id)
	{
		try
		{
			Address result=this.addressService.getAddressById(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
		}catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/updateAddress/{id}")
	public ResponseEntity<Address> updateAddress(@RequestBody Address address,@PathVariable("id") int id)
	{
		try
		{
			Address result=this.addressService.updateAddress(address,id);
			System.out.println(result);
			return ResponseEntity.ok().body(result);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/deleteAddress/{id}")
	public ResponseEntity<Address> deleteAddress(@PathVariable("id") int id)
	{
		try
		{
			Address result=this.addressService.deleteAddress(id);
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
