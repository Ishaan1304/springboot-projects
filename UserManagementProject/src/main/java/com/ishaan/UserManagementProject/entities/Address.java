package com.ishaan.UserManagementProject.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    private int houseNumber;
    private String colonyName;
    
    //@ManyToOne(cascade = CascadeType.ALL)
    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
//    @JsonIgnore
    @JsonBackReference(value="user-address")
    private User user;
    
    @ManyToOne
    @JoinColumn(name="city_id", referencedColumnName = "id")
    private City city;
    
    @ManyToOne
    @JoinColumn(name="state_id", referencedColumnName = "id")
    @JsonBackReference(value="state-address")
    private State state;
    
    @ManyToOne
    @JoinColumn(name="country_id", referencedColumnName = "id")
    @JsonBackReference(value="country-address")
    private Country country;
    
    
}
