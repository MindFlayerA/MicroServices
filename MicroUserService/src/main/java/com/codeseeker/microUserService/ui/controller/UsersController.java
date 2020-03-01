package com.codeseeker.microUserService.ui.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeseeker.microUserService.ui.Entities.UserEntity;
import com.codeseeker.microUserService.ui.Users.UserRequestModel;
import com.codeseeker.microUserService.ui.Users.UserResponseModel;
import com.codeseeker.microUserService.ui.shared.UserDTO;
import com.codeseeker.microUserService.ui.userservice.UserServiceProvider;

@RestController
@RequestMapping("/users")
public class UsersController {
	@Autowired
	protected UserServiceProvider service;
	
	@Autowired 
	private Environment env;

	@GetMapping("/status/check")
	public String status() {
		return "working on port: "+ env.getProperty("local.server.port")+"with token secret: "+ env.getProperty("token.secret");
	}

	@GetMapping("/")
	public List<UserEntity> findall() {
		return service.findall();
	}

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
				 produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
				)
	public UserResponseModel createUser(@Valid @RequestBody UserRequestModel u) {
		UserDTO userDto = new ModelMapper().map(u, UserDTO.class);
		return service.createUser(userDto);

	}
}
