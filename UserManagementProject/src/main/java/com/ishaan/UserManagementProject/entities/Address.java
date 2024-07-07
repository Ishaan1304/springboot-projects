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
public class Address {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    private int houseNumber;
    private String colonyName;
    
    @ManyToOne
    @JoinColumn(name = "userId")
    @JsonBackReference
    private User user;
}
