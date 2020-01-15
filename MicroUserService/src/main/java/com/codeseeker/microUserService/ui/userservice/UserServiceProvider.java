package com.codeseeker.microUserService.ui.userservice;

import org.springframework.stereotype.Service;
import com.codeseeker.microUserService.ui.shared.UserDTO;

@Service
public interface UserServiceProvider
{
	UserDTO createUser(UserDTO userDto);
	
}
