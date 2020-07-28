package com.soares.microservices.user.api.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soares.microservices.user.api.model.dto.UserDTO;
import com.soares.microservices.user.api.model.request.UserCreateRequestModel;
import com.soares.microservices.user.api.service.IUserService;

/**
 * User controller
 * 
 * @author Marcelo Soares <marceloh.web@gmail.com>
 *
 */
@RestController
@RequestMapping(path = "/users")
public class UserController {

	@Autowired
	private IUserService service;

	/**
	 * Create user
	 * 
	 * @param userRequest
	 * @return {@link ResponseEntity}
	 */
	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserDTO> insert(@Valid @RequestBody UserCreateRequestModel userRequest) {
		if(service.findByEmail(userRequest.getEmail()) != null) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
		}
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		UserDTO userDTO = modelMapper.map(userRequest, UserDTO.class);
		userDTO = service.insert(userDTO);

		return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
	}

	/**
	 * Get user by id
	 * 
	 * @param id
	 * @return {@link ResponseEntity}
	 */
	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserDTO> getById(@PathVariable("id") String id) {
		UserDTO userDto = service.findById(id);
		return (userDto != null) ? ResponseEntity.status(HttpStatus.OK).body(userDto) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

}
