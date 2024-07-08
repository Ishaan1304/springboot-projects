package com.ishaan.UserManagementProject.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
public class Address {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    private int houseNumber;
    private String colonyName;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id", referencedColumnName = "id")
    @JsonBackReference
    private User user;
    
    @ManyToOne
    @JoinColumn(name="city_id")
    private City city;
    
    @ManyToOne
    @JoinColumn(name="state_id")
    private State state;
    
    @ManyToOne
    @JoinColumn(name="country_id")
    private Country country;
    
    
}
