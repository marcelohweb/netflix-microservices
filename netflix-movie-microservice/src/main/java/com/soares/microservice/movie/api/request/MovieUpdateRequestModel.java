package com.soares.microservice.movie.api.request;

import javax.validation.constraints.NotNull;

/**
 * Movie request class for update
 * 
 * @author Marcelo Soares <marceloh.web@gmail.com>
 *
 */
public class MovieUpdateRequestModel extends MovieCreateRequestModel {
	
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
