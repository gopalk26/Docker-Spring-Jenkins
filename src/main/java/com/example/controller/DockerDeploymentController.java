package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.service.Userservice;

@RequestMapping("/api")
@RestController
public class DockerDeploymentController {

	@Autowired
	private Userservice userService;

	@GetMapping("/deployeedocker")
	public ResponseEntity<Object> welcomeApi() {

		return new ResponseEntity<Object>("Depolyed Spring Appliaction in Docker Container!!!!!", HttpStatus.OK);

	}

	@PostMapping("/saveuser")
	public User saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	
	@GetMapping("/getUsers")
	public List<User> getUsers() {
		return userService.getUser();
	}
	

}
