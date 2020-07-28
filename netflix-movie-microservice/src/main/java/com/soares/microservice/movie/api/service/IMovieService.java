package com.soares.microservice.movie.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.soares.microservice.commons.dto.MovieDTO;

/**
 * Movie service interface
 * 
 * @author Marcelo Soares <marceloh.web@gmail.com>
 *
 */
@Service
public interface IMovieService {

	/**
	 * Save a movie
	 * @param movie
	 * @return
	 */
	MovieDTO insert(MovieDTO movie);
	
	/**
	 * Update a movie
	 * @param movie
	 * @return
	 */
	MovieDTO update(MovieDTO movie);

	/**
	 * Get all rows
	 * @return
	 */
	public List<MovieDTO> getAll();
	
	/**
	 * Get a movie by id
	 * @return
	 */
	public MovieDTO findById(String id);
	
	/**
	 * Delete a movie
	 * @param id
	 */
	public void delete(String id);

}
