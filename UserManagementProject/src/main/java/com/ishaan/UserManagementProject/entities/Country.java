package com.ishaan.UserManagementProject.entities;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Country {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	@Column(unique = true)
	String countryName;
	
//	@OneToMany(mappedBy="country")
//	@JsonManagedReference
//	@JsonIgnore
//	List<State> states=new ArrayList<>();
}
