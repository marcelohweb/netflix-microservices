package com.soares.microservice.category.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.soares.microservice.commons.dto.CategoryDTO;

import javassist.NotFoundException;

/**
 * Category service interface
 * 
 * @author Marcelo Soares <marceloh.web@gmail.com>
 *
 */
@Service
public interface ICategoryService {

	/**
	 * Save a category
	 * @param category
	 * @return
	 */
	public CategoryDTO insert(CategoryDTO category);
	
	/**
	 * Update a category
	 * @param category
	 * @return
	 */
	public CategoryDTO update(CategoryDTO category);

	/**
	 * Get all rows
	 * @return
	 */
	public List<CategoryDTO> getAll();
	
	/**
	 * Get an movie by id
	 * @return
	 */
	public CategoryDTO findById(String id);
	
	/**
	 * Delete a category
	 * @param id
	 */
	public void delete(String id);
	
}
