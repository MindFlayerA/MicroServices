package com.codeseeker.microUserService.ui.userservice.userserviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.codeseeker.microUserService.ui.DaoLayer.DaoLayer;
import com.codeseeker.microUserService.ui.Entities.UserEntity;
import com.codeseeker.microUserService.ui.Users.UserResponseModel;
import com.codeseeker.microUserService.ui.shared.UserDTO;
import com.codeseeker.microUserService.ui.userservice.UserServiceProvider;

@Service
public class UserServiceProviderImpl implements UserServiceProvider {

	protected DaoLayer repo;
	protected BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public UserServiceProviderImpl(DaoLayer repo, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.repo = repo;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	public UserResponseModel createUser(UserDTO userddto) {
		userddto.setEncryptedpassword(bCryptPasswordEncoder.encode(userddto.getPassword()));
		UserEntity entity = new ModelMapper().map(userddto, UserEntity.class);
		repo.save(entity);

		return new ModelMapper().map(entity, UserResponseModel.class);
	}

	@Override
	public List<UserEntity> findall() {
		return repo.findAll();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = repo.findByEmail(username);
		if (userEntity == null)
			throw new UsernameNotFoundException("Incorrect Username or Password.");
		return new User(userEntity.getEmail(), userEntity.getEncryptedpassword(), true, true, true, true,
				new ArrayList<>());
	}

	@Override
	public UserResponseModel loadUserByEmail(String email) {
		UserEntity userEntity = repo.findByEmail(email);
		if (userEntity == null)
			throw new UsernameNotFoundException("No account exists for email:" + email);
		UserResponseModel response = new UserResponseModel();
		response.setUserid(userEntity.getUserid());
		return response;
	}

}
