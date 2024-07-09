package com.ishaan.UserManagementProject.entities;




import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
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

	
	@Embedded
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true )
	List<Address> address=new ArrayList<>();
	
	
	
	@PrePersist
    @PreUpdate
    private void prepareChildren() {
        for (Address add : address) {
            if (add.getUser() == null) {
                add.setUser(this);
            }
        }
    }



	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + ", age=" + age + ", gender=" + gender + ", salary=" + salary;
	}



	
	
	
}

