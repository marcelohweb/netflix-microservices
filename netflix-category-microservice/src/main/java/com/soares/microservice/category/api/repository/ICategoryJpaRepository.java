package com.soares.microservice.category.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.soares.microservice.commons.entity.CategoryEntity;

/**
 * Repository class for {@link CategoryEntity}
 * 
 * @author Marcelo Soares <marceloh.web@gmail.com>
 *
 */
@Repository("categoryJpaRepository")
public interface ICategoryJpaRepository extends CrudRepository<CategoryEntity, String> {

}
