package wcci.moviesrestfulapi.repositories;

import org.springframework.data.repository.CrudRepository;

import wcci.moviesrestfulapi.models.Movie;

public interface MovieRepository extends CrudRepository<Movie, Long> {

}
