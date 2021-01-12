package com.example.demo.service.impl;

import java.util.List;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.File;
import com.example.demo.models.User;
import com.example.demo.repository.FileRepository;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	static Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepo repo;
	
	@Autowired
	private FileRepository fileRepo;

	@Override
	public String getUserName(String name) {
		return "hello there" + name + " from service layer!";
	}

	@Override
	public User save(String firstName, String lastName, String city, String mail) {
		LOGGER.info("in save repo class, saving initiated");
		return repo.save(new User(firstName, lastName, mail, city));
	}

	@Override
	public User findBbyID(Long id) {
		LOGGER.debug("searching one by id {}", id);
		return repo.findByUserId(id);
	}

	@Override
	public List<User> findAllUsers() {
		return repo.findAll();
	}

	@Override
	public File saveFile(User u, String fileType, byte[] fileData, String fileName) {
		LOGGER.info("saving file with user");
	return fileRepo.save(new File(fileName,fileData,fileType, u));	
	}

	@Override
	public User findByNames(String firstName, String lastName) {
	return repo.findByNames(firstName,lastName);
	}

}
