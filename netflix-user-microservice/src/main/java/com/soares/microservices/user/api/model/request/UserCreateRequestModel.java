package com.soares.microservices.user.api.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * This class represents an user insert request
 * 
 * @author Marcelo Soares <marceloh.web@gmail.com>
 *
 */
public class UserCreateRequestModel {
	
	/**
	 * First name
	 */
	@NotNull(message = "First name cannot be null")
	private String firstName;
	
	/**
	 * Last name
	 */
	@NotNull(message = "Last name cannot be null")
	private String lastName;
	
	/**
	 * Email
	 */
	@NotNull(message = "Email cannot be null")
	@Email(message = "Invalid email")
	private String email;

	/**
	 * Password
	 */
	@NotNull(message = "Password cannot be null")
	@Size(min = 8, max = 16, message = "Password must be equal or grater than 8 characters and less or equal 16 characters")
	private String password;
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
}
