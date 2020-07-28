package com.soares.microservices.user.api.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.soares.microservices.user.api.model.dto.UserDTO;
import com.soares.microservices.user.api.model.request.LoginRequestModel;
import com.soares.microservices.user.api.service.IUserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * Authentication filter
 * 
 * @author Marcelo Soares <marceloh.web@gmail.com>
 *
 */
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	IUserService userService;
	
	private Environment env;
	
	public AuthenticationFilter(@Autowired IUserService userService, Environment env, AuthenticationManager authenticationManager) {

		this.userService = userService;
		this.env = env;
		super.setAuthenticationManager(authenticationManager);
		
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
			throws AuthenticationException {

		try {

			LoginRequestModel creds = new ObjectMapper().readValue(req.getInputStream(), LoginRequestModel.class);

			return getAuthenticationManager().authenticate(
					new UsernamePasswordAuthenticationToken(creds.getEmail(), creds.getPassword(), new ArrayList<>()));

		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		String userName = ((User) auth.getPrincipal()).getUsername();
		UserDTO userDetails = userService.findByEmail(userName);
		
		if(userDetails == null) 
			throw new UsernameNotFoundException(userName);
		
		String token = Jwts.builder()
				.setSubject(userDetails.getId())
				.setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(env.getProperty("token.expiration_time"))))
				.signWith(SignatureAlgorithm.HS512, env.getProperty("token.secret")).compact();
		
		res.addHeader("token", token);
		res.addHeader("userId", userDetails.getId());
	}

}
