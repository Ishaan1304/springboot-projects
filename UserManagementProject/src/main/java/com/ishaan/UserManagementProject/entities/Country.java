package com.ishaan.UserManagementProject.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Country {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	@Column(unique = true)
	String countryName;
	
	@OneToMany(mappedBy="country")
	@JsonManagedReference
	@JsonIgnore
	List<State> states=new ArrayList<>();
}
