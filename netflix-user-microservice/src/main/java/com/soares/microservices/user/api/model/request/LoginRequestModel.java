package com.soares.microservices.user.api.model.request;

/**
 * Login request
 * 
 * @author Marcelo Soares <marceloh.web@gmail.com>
 *
 */
public class LoginRequestModel {

	/**
	 * User email
	 */
	private String email;
	
	/**
	 * User password
	 */
	private String password;

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
