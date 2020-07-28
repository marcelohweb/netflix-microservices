package com.soares.microservice.category.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soares.microservice.category.api.request.CategoryCreateRequestModel;
import com.soares.microservice.category.api.request.CategoryUpdateRequestModel;
import com.soares.microservice.category.api.service.ICategoryService;
import com.soares.microservice.commons.dto.CategoryDTO;

import javassist.NotFoundException;

/**
 * Category Controller
 * 
 * @author Marcelo Soares <marceloh.web@gmail.com>
 *
 */
@RestController
@RequestMapping(path = "/category")
public class CategoryController {

	@Autowired
	private ICategoryService service;

	/**
	 * Save a category
	 * 
	 * @param categoryRequest
	 * @return {@link ResponseEntity}
	 */
	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CategoryDTO> insert(@Valid @RequestBody CategoryCreateRequestModel categoryRequest) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		CategoryDTO categoryDTO = modelMapper.map(categoryRequest, CategoryDTO.class);
		
		categoryDTO = service.insert(categoryDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(categoryDTO);
	}

	/**
	 * Return a category by id
	 * 
	 * @param categoryId
	 * @return {@link ResponseEntity}
	 * @throws NotFoundException 
	 */
	@GetMapping(value = "/{categoryId}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CategoryDTO> getById(@PathVariable("categoryId") String categoryId) throws NotFoundException {
		CategoryDTO categoryDTO = service.findById(categoryId);
		return (categoryDTO != null) ? ResponseEntity.status(HttpStatus.OK).body(categoryDTO) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	/**
	 * Return all categories
	 * 
	 * @param categoryId
	 * @return {@link ResponseEntity}
	 */
	@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<CategoryDTO>> getAll() {
		List<CategoryDTO> categories = service.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(categories);
	}

	/**
	 * Update a category
	 * @return
	 * @throws NotFoundException 
	 */
	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<CategoryDTO> update(@Valid @RequestBody CategoryUpdateRequestModel categoryRequest) {
		if(service.findById(categoryRequest.getId()) == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		CategoryDTO categoryDTO = modelMapper.map(categoryRequest, CategoryDTO.class);
		
		categoryDTO = service.update(categoryDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(categoryDTO);
	}

	/**
	 * Delete a category
	 * @return
	 * @throws NotFoundException 
	 */
	@DeleteMapping(path = "/{categoryId}")
	public ResponseEntity<Void> delete(@PathVariable String categoryId) {
		if(service.findById(categoryId) == null)
			return ResponseEntity.notFound().build();
		
		service.delete(categoryId);
		return ResponseEntity.ok().build();
	}

}
