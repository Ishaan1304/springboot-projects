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

import com.ishaan.UserManagementProject.entities.State;
import com.ishaan.UserManagementProject.services.StateService;

@RestController
@RequestMapping("/state")
public class StateController {
	@Autowired
	private StateService stateService;
	
	@PostMapping("/addState")
	public ResponseEntity<State> addState(@RequestBody State state)
	{
		State result=null;
		try
		{
			result=this.stateService.addState(state);
			System.out.println(state);
			return  ResponseEntity.of(Optional.of(result));
		}catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@GetMapping("/getStates")
	public ResponseEntity<List<State>> getStates()
	{
		try
		{
			List<State> result=this.stateService.getStates();
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
	
	
	@GetMapping("/getState/{id}")
	public ResponseEntity<State> getState(@PathVariable int id)
	{
		try
		{
			State result=this.stateService.getStateById(id);
			System.out.println(result);
			return ResponseEntity.status(HttpStatus.CREATED).body(result);
		}catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	
	@PutMapping("/updateState/{id}")
	public ResponseEntity<State> updateState(@RequestBody State state,@PathVariable("id") int id)
	{
		try
		{
			State result=this.stateService.updateState(state,id);
			System.out.println(result);
			return ResponseEntity.ok().body(result);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	@DeleteMapping("/deleteState/{id}")
	public ResponseEntity<State> deleteState(@PathVariable("id") int id)
	{
		try
		{
			State result=this.stateService.deleteState(id);
			System.out.println(result);
			return ResponseEntity.ok().body(result);
		}catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
}
