package com.ishaan.UserManagementProject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ishaan.UserManagementProject.dao.StateDAO;

import com.ishaan.UserManagementProject.entities.State;

@Service
public class StateService {
	@Autowired
	StateDAO stateDAO;
	
	public State addState(State state)
	{
		State result=this.stateDAO.save(state);
		return result;
	}
	
	public List<State> getStates()
	{
		List<State> list=null;
		try
		{
			list=this.stateDAO.findAll();
			return list;
		}catch(Exception e)
		{
			e.getMessage();
			return list;
		}
		
	}
	
	public State getStateById(int id)
	{
		State result=null;
		try
		{
			result=this.stateDAO.findById(id);
			return result;
		}catch(Exception e)
		{
			e.getMessage();
			return result;
		}
		
	}
	
	public State updateState(State state,int id)
	{
		State result=null;
		try
		{
			state.setId(id);
			result=this.stateDAO.save(state);
			return result;
		}catch(Exception e)
		{
			e.getMessage();
			return result;
		}
		
	}
	
	public State deleteState(int id)
	{
		State result=null;
		try
		{
			result=this.stateDAO.deleteById(id);
			return result;
		}catch(Exception e)
		{
			e.getMessage();
			return result;
		}
		
	}

	
	
}
