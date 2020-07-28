package com.soares.microservices.user.api.service;

import java.util.ArrayList;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.soares.microservices.user.api.model.dto.UserDTO;
import com.soares.microservices.user.api.model.entity.UserEntity;
import com.soares.microservices.user.api.repository.IUserJpaRepository;

/**
 * Implementation for {@link IUserService}
 * 
 * @author Marcelo Soares <marceloh.web@gmail.com>
 *
 */
@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	IUserJpaRepository repository;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Override
	public UserDTO insert(UserDTO user) {
		
		user.setId(UUID.randomUUID().toString());
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		UserEntity userEntity = modelMapper.map(user, UserEntity.class);
		userEntity.setEncryptedPassword(encoder.encode(user.getPassword()));
		
		repository.save(userEntity);
		
		UserDTO returnValue = modelMapper.map(userEntity, UserDTO.class);
		
		return returnValue;
		
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = repository.findByEmail(username);
		if(userEntity == null) 
			throw new UsernameNotFoundException(username);
		return new User(username, userEntity.getEncryptedPassword(), true, true, true, true, new ArrayList<GrantedAuthority>());
	}

	@Override
	public UserDTO findByEmail(String email) {
		UserEntity userEntity = repository.findByEmail(email);
		
		if(userEntity == null) 
			return null;
		
		return new ModelMapper().map(userEntity, UserDTO.class);
	}

	@Override
	public UserDTO findById(String id) {
		UserEntity userEntity = repository.findUserById(id);
		
		if(userEntity == null) 
			throw new UsernameNotFoundException(id);
		
		UserDTO userDto = new ModelMapper().map(userEntity, UserDTO.class);
		
		return userDto;
	}

}
