package com.soares.microservices.user.api.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.soares.microservices.user.api.model.dto.UserDTO;

/**
 * User service
 * 
 * @author Marcelo Soares <marceloh.web@gmail.com>
 *
 */
public interface IUserService extends UserDetailsService {

	/**
	 * Create user
	 * 
	 * @param user
	 * @return {@link UserDTO}
	 */
	UserDTO insert(UserDTO user);
	
	/**
	 * Return an user by email
	 * 
	 * @param email
	 * @return {@link UserDTO}
	 */
	UserDTO findByEmail(String email);
	
	/**
	 * Find an user by id
	 * 
	 * @param id
	 * @return {@link UserDTO}
	 */
	UserDTO findById(String id);
	
}
