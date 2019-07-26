package wcci.moviesrestfulapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ActorController {

	@Autowired
	private ActorRepository actorRepo;

	@GetMapping("/actors")
	public Iterable<Actor> findAllActors() {

		return actorRepo.findAll();
	}

	public Actor findOneActor(Long id) {

		return actorRepo.findById(id).get();
	}

}
