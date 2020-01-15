package com.codeseeker.microUserService.ui.controller;


import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.codeseeker.microUserService.ui.Users.UserRequestModel;
import com.codeseeker.microUserService.ui.shared.UserDTO;
import com.codeseeker.microUserService.ui.userservice.UserServiceProvider;

@RestController
@RequestMapping("/users")
public class UsersController 
{
	@Autowired
	protected UserServiceProvider service;
	
	@GetMapping("/status/check")
	public String status()
	{
		return "working";
	}
	
	@PostMapping
	public UserDTO createUser(@Valid @RequestBody UserRequestModel u)
	{
		UserDTO userDto=new ModelMapper().map(u, UserDTO.class);
		return service.createUser(userDto);
	}
}
