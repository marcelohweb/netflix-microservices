package com.soares.microservice.movie.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soares.microservice.commons.dto.CategoryDTO;
import com.soares.microservice.commons.dto.MovieDTO;
import com.soares.microservice.movie.api.request.MovieCreateRequestModel;
import com.soares.microservice.movie.api.request.MovieUpdateRequestModel;
import com.soares.microservice.movie.api.service.IMovieService;

/**
 * Movie Controller
 * 
 * @author Marcelo Soares <marceloh.web@gmail.com>
 *
 */
@RestController
@RequestMapping(path = "/movie")
public class MovieController {

	@Autowired
	private IMovieService service;

	/**
	 * Save a movie
	 * 
	 * @param movieRequest
	 * @return {@link ResponseEntity}
	 */
	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<MovieDTO> insert(@Valid @RequestBody MovieCreateRequestModel movieRequest) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		MovieDTO movieDTO = modelMapper.map(movieRequest, MovieDTO.class);
		
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setId(movieRequest.getCategoryId());
		movieDTO.setCategory(categoryDTO);
		
		movieDTO = service.insert(movieDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(movieDTO);
	}

	/**
	 * Return a movie by id
	 * 
	 * @param movieId
	 * @return {@link ResponseEntity}
	 */
	@GetMapping(value = "/{movieId}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<MovieDTO> getById(@PathVariable("movieId") String movieId) {
		MovieDTO movieDTO = service.findById(movieId);
		return (movieDTO != null) ? ResponseEntity.status(HttpStatus.OK).body(movieDTO) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	/**
	 * Return a movie by id
	 * 
	 * @param movieId
	 * @return {@link ResponseEntity}
	 */
	@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<MovieDTO>> getAll() {
		List<MovieDTO> movies = service.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(movies);
	}

	/**
	 * Update a movie
	 * 
	 * @return {@link ResponseEntity}
	 */
	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<MovieDTO> update(@Valid @RequestBody MovieUpdateRequestModel movieRequest) {
		if(service.findById(movieRequest.getId()) == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		MovieDTO movieDTO = modelMapper.map(movieRequest, MovieDTO.class);
		
		movieDTO = service.update(movieDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(movieDTO);
	}

	/**
	 * Delete a movie
	 * 
	 * @return {@link ResponseEntity}
	 */
	@DeleteMapping(path = "/{movieId}")
	public ResponseEntity<Void> delete(@PathVariable String movieId) {
		if(service.findById(movieId) == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		
		service.delete(movieId);
		return ResponseEntity.ok().build();
	}

}
