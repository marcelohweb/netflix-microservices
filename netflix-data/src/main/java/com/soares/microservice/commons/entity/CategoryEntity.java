package com.soares.microservice.commons.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Category Entity
 * 
 * @author Marcelo Soares <marceloh.web@gmail.com>
 *
 */
@Entity
@Table(name = "category")
public class CategoryEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Primary key
	 */
	@Id
	@Column(name = "id")
	private String id;
	
	/**
	 * Category
	 */
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	
	/**
	 * List of movies
	 */
	@JsonManagedReference
	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<MovieEntity> movies = new ArrayList<MovieEntity>();

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
	public List<MovieEntity> getMovies() {
		return movies;
	}

	/**
	 * @param movies the movies to set
	 */
	public void setMovies(List<MovieEntity> movies) {
		this.movies = movies;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
