package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.models.Documents;
import com.example.demo.models.File;
import com.example.demo.models.User;
import com.example.demo.service.DocumentService;
import com.example.demo.service.UserService;

@RestController
public class UserController {

	static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	@Autowired
	private DocumentService docService;
	
	@GetMapping("/getDocument/{docId}")
	private ResponseEntity<ByteArrayResource> getDocument(@PathVariable Long docId) {
		Documents doc = docService.getDoc(docId).get();
		LOGGER.info("doc details : name {},type {}, data {} ", doc.getDocName(), doc.getDocType(),
				new ByteArrayResource(doc.getData()));
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(doc.getDocType()))
				.header(org.springframework.http.HttpHeaders.CONTENT_DISPOSITION,
						"filename=\"" + doc.getDocName() + "\"")
				.body(new ByteArrayResource(doc.getData()));

	}

	@PostMapping("/updateFile")
	private String getFile(@RequestParam("file") MultipartFile file) throws IOException {
		Documents doc = docService.saveFile(file);
		return "file uploaded with id " + doc.getDocId() + "!";
	}

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

	@PostMapping("/fileSave")
	private File saveOne(@RequestParam("fName") String firstName, @RequestParam("lName") String lastName,
			@RequestParam("fileType") MultipartFile upload) throws IOException {
		User user = null;
		try {
			user = userService.findByNames(firstName, lastName);
			if (null == user) {
				throw new NullPointerException();
			}
		} catch (Exception e) {
			LOGGER.info("no user found {}", e);
			throw e;
		}
		LOGGER.info("user found: {}", user);
		File file = userService.saveFile(user, upload.getContentType(), upload.getBytes(),
				upload.getOriginalFilename());
		LOGGER.info("file {}", file);
		return file;
	}
}
