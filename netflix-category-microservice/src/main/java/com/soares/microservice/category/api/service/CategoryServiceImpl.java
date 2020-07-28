package com.soares.microservice.category.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soares.microservice.category.api.repository.ICategoryJpaRepository;
import com.soares.microservice.commons.dto.CategoryDTO;
import com.soares.microservice.commons.entity.CategoryEntity;

/**
 * Category service interface implementation
 * 
 * @author Marcelo Soares <marceloh.web@gmail.com>
 *
 */
@Service("categoryService")
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private ICategoryJpaRepository repository;

	@Override
	public CategoryDTO insert(CategoryDTO category) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		CategoryEntity categoryEntity = modelMapper.map(category, CategoryEntity.class);
		categoryEntity.setId(UUID.randomUUID().toString());
		
		categoryEntity = repository.save(categoryEntity);
		category = modelMapper.map(categoryEntity, CategoryDTO.class);
		
		return category;
	}
	
	@Override
	public CategoryDTO update(CategoryDTO category) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		CategoryEntity categoryEntity = modelMapper.map(category, CategoryEntity.class);
		
		categoryEntity = repository.save(categoryEntity);
		category = modelMapper.map(categoryEntity, CategoryDTO.class);
		
		return category;
	}

	@Override
	public CategoryDTO findById(String id) {
		CategoryEntity category = repository.findById(id).orElse(null);
		
		if(category == null)
			return null;
		
		CategoryDTO categoryDTO = new ModelMapper().map(category, CategoryDTO.class);
		
		return categoryDTO;
	}
	
	@Override
	public List<CategoryDTO> getAll() {
		ArrayList<CategoryEntity> categories = (ArrayList<CategoryEntity>) repository.findAll();
		
		ModelMapper modelMapper = new ModelMapper();
		
		List<CategoryDTO> categoriesDTO = categories
				  .stream()
				  .map(category -> modelMapper.map(category, CategoryDTO.class))
				  .collect(Collectors.toList());
		
		return categoriesDTO;
	}

	@Override
	public void delete(String id) {
		repository.deleteById(id);
	}

}
