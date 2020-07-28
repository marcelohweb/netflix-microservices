package com.soares.microservice.commons.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Data Transfer Object for Movie
 * 
 * @author Marcelo Soares <marceloh.web@gmail.com>
 *
 */
public class MovieDTO {
	
	/**
	 * Primary key
	 */
	private String id;
	
	/**
	 * Movie title
	 */
	private String title;

	/**
	 * Category
	 */
	@JsonBackReference
	private CategoryDTO category;

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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the category
	 */
	public CategoryDTO getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(CategoryDTO category) {
		this.category = category;
	}

}
