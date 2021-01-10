package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public String getUserName(String name) {
		return "hello "+name+" from service layer!";
	}

}
