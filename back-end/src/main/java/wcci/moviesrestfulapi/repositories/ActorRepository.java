package wcci.moviesrestfulapi.repositories;

import org.springframework.data.repository.CrudRepository;

import wcci.moviesrestfulapi.models.Actor;

public interface ActorRepository extends CrudRepository<Actor, Long> {

}
