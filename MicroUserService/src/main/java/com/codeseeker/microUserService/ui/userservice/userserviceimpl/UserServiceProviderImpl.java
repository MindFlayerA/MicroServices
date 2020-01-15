package com.codeseeker.microUserService.ui.userservice.userserviceimpl;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.codeseeker.microUserService.ui.DaoLayer.DaoLayer;
import com.codeseeker.microUserService.ui.Entities.UserEntity;
import com.codeseeker.microUserService.ui.shared.UserDTO;
import com.codeseeker.microUserService.ui.userservice.UserServiceProvider;

@Repository
public class UserServiceProviderImpl implements UserServiceProvider 
{
	@Autowired
	protected DaoLayer repo;

	@Override
	public UserDTO createUser(UserDTO userddto) {
		UserEntity entity=new ModelMapper().map(userddto, UserEntity.class);
		entity.setEncryptedpassword(UUID.randomUUID().toString());
		repo.save(entity);
		return userddto;
	}

}
