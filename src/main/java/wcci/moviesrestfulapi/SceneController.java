package wcci.moviesrestfulapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SceneController {
	
	@Autowired
	private SceneRepository sceneRepo;

	@GetMapping("/scenes")
	public Iterable<Scene> findAllScenes() {
		return sceneRepo.findAll();
	}

	@GetMapping("/scenes/{id}")
	public Scene findOneScene(@PathVariable Long id) {
		return sceneRepo.findById(id).get();
	}

}
