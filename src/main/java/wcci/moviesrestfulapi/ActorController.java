package wcci.moviesrestfulapi;

import org.springframework.beans.factory.annotation.Autowired;

public class ActorController {

	@Autowired
	private ActorRepository actorRepo;
	
	public Iterable<Actor> findAllActors() {
		
		return actorRepo.findAll();
	}

	public Actor findOneActor(Long id) {
		
		return actorRepo.findById(id).get();
	}

	

}
