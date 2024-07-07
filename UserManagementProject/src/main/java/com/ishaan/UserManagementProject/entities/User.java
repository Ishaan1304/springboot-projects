package com.ishaan.UserManagementProject.entities;




import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
	private String firstName;
	private String lastName;
	@Column(unique = true)
	private String username;
	private String password;	
	private int age;
	private String gender;
	private double salary;

	
	@OneToMany(mappedBy="user")
	@JsonManagedReference
	List<Address> address=new ArrayList<>();
	
}




/*
 * import com.fasterxml.jackson.annotation.JsonManagedReference; import
 * javax.persistence.*; import java.util.HashSet; import java.util.Set;
 * 
 * @Entity public class User {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
 * 
 * private String username; private String email;
 * 
 * // One-to-many relationship with Address
 * 
 * @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
 * 
 * @JsonManagedReference // This annotation manages the serialization of the
 * child side (Address) private Set<Address> addresses = new HashSet<>();
 * 
 * // Constructors, getters, and setters }
 */