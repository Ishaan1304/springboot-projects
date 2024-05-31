package com.jpa.test;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.jpa.test.dao.*;
import com.jpa.test.entities.*;

@SpringBootApplication
public class BootjpaexampleApplication {

	public static void main(String[] args) {
		
		ApplicationContext context=SpringApplication.run(BootjpaexampleApplication.class, args);
		UserRepository userRepository=context.getBean(UserRepository.class);
		
		User user1=new User();
		user1.setName("Ishaan Gangrade");
		user1.setCity("Ujjain");
		user1.setStatus("I am programmer");
		
		User user2=new User();
		user2.setName("Sameer Shah");
		user2.setCity("Indore");
		user2.setStatus("I am analyst");
		
		
		User user3=new User();
		user3.setName("Karan Sharma");
		user3.setCity("Dewas");
		user3.setStatus("I am tester");
		
		
		/*  Saving Single user
		User resultUser=userRepository.save(user1);
		System.out.println("Saved User "+resultUser);
		System.out.println("Done");
		*/
		// Saving Multiple User using List or IterableCollection
		/*
		List<User> users=List.of(user1,user2,user3);
		Iterable<User> result=userRepository.saveAll(users);
		result.forEach((item)->{
			System.out.println(item);
		});
		*/
		
		//Update the user
		/*
		Optional<User> optional= userRepository.findById(102);
		User user=optional.get();
		user.setName("Shanu Gangrade");
		User result=userRepository.save(user);
		System.out.println(result);
		*/
		
		
		//How to GET the data
		//findById(id) - Optional Containing your data
		/*
		Iterable<User> itr=userRepository.findAll();
		Iterator<User> iterator=itr.iterator();
		while(iterator.hasNext())
		{
			User user=iterator.next();
			System.out.println(user);
		}
		itr.forEach(user->{System.out.println(user);}) ;
		*/
		
		//Delete
		/*
		userRepository.deleteById(103);
		System.out.println("Deleted");
		
		 
		Iterable<User> allusers = userRepository.findAll();
		allusers.forEach(user->System.out.println(user));
		userRepository.deleteAll(allusers);
		*/
		
		
		//Custom finder methods
		/*
		List<User> users=userRepository.findByName("Ishaan Gangrade");
		for(User user:users)
		{
			System.out.println("Custom finder methods"+user);
		}
		*/
		/*
		List<User> users=userRepository.findByNameAndCity("Ishaan Gangrade","Ujjain");
		for(User user:users)
		{
			System.out.println("Custom finder methods "+user);
		}
		*/
		
		
		List<User> allUser = userRepository.getAllUser();
		for(User user:allUser)
		{
			System.out.println(user);
		}
		System.out.println("---------------------------");
		List<User> userByName = userRepository.getUserByName("Ishaan Gangrade","Ujjain");
		for(User user:userByName)
		{
			System.out.println(user);
		}
		System.out.println("---------------------------");
		List<User> usersNative = userRepository.getUsers();
		for(User user:usersNative)
		{
			System.out.println(user);
		}
		
		
	}
}
 