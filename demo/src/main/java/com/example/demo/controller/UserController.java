package com.example.demo.controller;

import java.util.List;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {

	static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@PostMapping("/giveMe")
	private String getString(@RequestParam("name") String name) {
		return userService.getUserName(name);
	}

	@PostMapping("/save")
	private User saveUser(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lasatName,
			@RequestParam("city") String city, @RequestParam("mail") String mail) {

		return userService.save(firstName, lasatName, city, mail);
	}

	@PostMapping("/findOne")
	private User getById(@RequestParam("id") Long id) {
		LOGGER.debug("userController:> id received: {}", id);
		return userService.findBbyID(id);
	}

	@GetMapping("/findAll")
	private List<User> findAll() {
		return userService.findAllUsers();
	}
}
