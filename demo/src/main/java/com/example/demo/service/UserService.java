package com.example.demo.service;

import java.util.List;

import com.example.demo.models.User;

public interface UserService {

	String getUserName(String name);
	User save(String firstName,String lastName, String city, String mail);
	User findBbyID(Long id);
	List<User> findAllUsers();
}
