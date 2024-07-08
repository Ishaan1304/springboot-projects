package com.ishaan.UserManagementProject.entities;




import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class User 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	private String firstName;
	private String lastName;
	@Column(unique = true)
	private String username;
	private String password;	
	private int age;
	private String gender;
	private double salary;

	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	List<Address> address=new ArrayList<>();	
}

