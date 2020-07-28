package com.soares.microservice.movie.api.request;

import javax.validation.constraints.NotNull;

/**
 * Movie request class for creation
 * 
 * @author Marcelo Soares <marceloh.web@gmail.com>
 *
 */
public class MovieCreateRequestModel {
	
	/**
	 * Movie name
	 */
	@NotNull(message = "title cannot be null")
	private String title;

	/**
	 * Category id
	 */
	@NotNull(message = "categoryId cannot be null")
	private String categoryId;

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
	 * @return the categoryId
	 */
	public String getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

}
