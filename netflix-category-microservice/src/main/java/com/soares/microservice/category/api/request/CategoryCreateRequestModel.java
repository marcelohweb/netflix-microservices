package com.soares.microservice.category.api.request;

import javax.validation.constraints.NotNull;

/**
 * This class represents a category insert request
 * 
 * @author Marcelo Soares <marceloh.web@gmail.com>
 *
 */
public class CategoryCreateRequestModel {
	
	/**
	 * Category name
	 */
	@NotNull(message = "name cannot be null")
	private String name;

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
	
}
