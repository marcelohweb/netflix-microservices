package com.soares.microservice.movie.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.soares.microservice.commons.entity.MovieEntity;

/**
 * Repository class for {@link MovieEntity}
 * 
 * @author Marcelo Soares <marceloh.web@gmail.com>
 *
 */
public interface IMovieJpaRepository extends CrudRepository<MovieEntity, String> {

}
