package com.codeseeker.microUserService.ui.userservice;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.codeseeker.microUserService.ui.Entities.UserEntity;
import com.codeseeker.microUserService.ui.Users.UserResponseModel;
import com.codeseeker.microUserService.ui.shared.UserDTO;

@Service
public interface UserServiceProvider extends UserDetailsService {
	UserResponseModel createUser(UserDTO userDto);

	List<UserEntity> findall();

	UserResponseModel loadUserByEmail(String email);

}
