package com.soares.microservice.category.api.request;

import javax.validation.constraints.NotNull;

/**
 * This class represents a category update request
 * 
 * @author Marcelo Soares <marceloh.web@gmail.com>
 *
 */
public class CategoryUpdateRequestModel extends CategoryCreateRequestModel {
	
	/**
	 * Primary key
	 */
	@NotNull(message = "id cannot be null")
	private String id;

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

}
