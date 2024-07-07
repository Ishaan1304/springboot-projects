package com.ishaan.UserManagementProject.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class City {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String cityName;
	
	@ManyToOne
	@JoinColumn(name="stateId")
	@JsonBackReference
	private State state;

	@Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", cityName='" + cityName + '\'' +
                ", state=" + (state != null ? state.getId() : null) + // Adjust as per your entity structure
                '}';
    }
}
