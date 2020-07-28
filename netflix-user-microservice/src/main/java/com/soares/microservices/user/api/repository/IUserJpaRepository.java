package com.soares.microservices.user.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.soares.microservices.user.api.model.entity.UserEntity;

/**
 * User repository
 * 
 * @author Marcelo Soares <marceloh.web@gmail.com>
 *
 */
public interface IUserJpaRepository extends MongoRepository<UserEntity, String> {

	/**
	 * Find user by email
	 * @param email
	 * @return {@link UserEntity}
	 */
	UserEntity findByEmail(String email);
	
	/**
	 * Find user by id
	 * @param id
	 * @return {@link UserEntity}
	 */
	UserEntity findUserById(String id);
	
}
