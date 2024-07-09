package com.ishaan.UserManagementProject.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


import lombok.Data;

@Data
@Entity
public class State {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(unique = true)
	private String stateName;
	
//	@OneToMany(mappedBy="state")
//	@JsonManagedReference
//	@JsonIgnore
//	List<City> cities=new ArrayList<>();
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="countryId")
	private Country country;
	
	

	
	@Override
    public String toString() {
        return "State{" +
                "id=" + id +
                ", stateName='" + stateName + '\'' +
                ", country=" + (country != null ? country.getId() : null) + // Adjust as per your entity structure
                '}';
    }
}
