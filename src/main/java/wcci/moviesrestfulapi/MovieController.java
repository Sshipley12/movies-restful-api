package wcci.moviesrestfulapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MovieController {

	@Autowired
	private MovieRepository movieRepo;

	@GetMapping("/movies")
	public Iterable<Movie> findAllMovies() {
		return movieRepo.findAll();
	}

	@GetMapping("/movies/{id}")
	public Movie findOneMovie(@PathVariable long id) {
		return movieRepo.findById(id).get();
	}

}
