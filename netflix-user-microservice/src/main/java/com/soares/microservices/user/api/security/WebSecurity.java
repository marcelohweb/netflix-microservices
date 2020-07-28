package com.soares.microservices.user.api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.soares.microservices.user.api.service.IUserService;

/**
 * Web security configuration
 * 
 * @author Marcelo Soares <marceloh.web@gmail.com>
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	private IUserService userService;
	
	private Environment env;
	
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	public WebSecurity(IUserService userService, Environment env, BCryptPasswordEncoder encoder) {
		
		this.userService = userService;
		this.env = env;
		this.encoder = encoder;
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/users/**").permitAll()
		.and().addFilter(getAuthenticationFilter());
		
		http.headers().frameOptions().disable();
		
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	private AuthenticationFilter getAuthenticationFilter() throws Exception {
		
		AuthenticationFilter authenticationFilter = new AuthenticationFilter(userService, env, authenticationManager());
		
		//For custom URL
		authenticationFilter.setFilterProcessesUrl(env.getProperty("login.url.path"));
		
		return authenticationFilter;
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(encoder);
	}
	
}
