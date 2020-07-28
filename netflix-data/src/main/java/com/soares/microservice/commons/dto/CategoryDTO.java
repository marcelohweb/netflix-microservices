package com.soares.microservice.commons.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Data Transfer Object for Category
 * 
 * @author Marcelo Soares <marceloh.web@gmail.com>
 *
 */
public class CategoryDTO {

	/**
	 * Primary key
	 */
	private String id;
	
	/**
	 * Category name
	 */
	private String name;
	
	/**
	 * List of movies
	 */
	private List<MovieDTO> movies = new ArrayList<MovieDTO>();

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the movies
	 */
	public List<MovieDTO> getMovies() {
		return movies;
	}

	/**
	 * @param movies the movies to set
	 */
	public void setMovies(List<MovieDTO> movies) {
		this.movies = movies;
	}
	
}
