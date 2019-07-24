package wcci.moviesrestfulapi;

import org.springframework.beans.factory.annotation.Autowired;

public class MovieController {
	
	
	@Autowired
	private MovieRepository movieRepo;

	public Iterable<Movie> findAllMovies() {
		return movieRepo.findAll();
	}

	public Movie findOneMovie(long id) {
		return movieRepo.findById(id).get();
	}

}
