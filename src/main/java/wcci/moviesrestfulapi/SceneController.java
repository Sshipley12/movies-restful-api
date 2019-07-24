package wcci.moviesrestfulapi;

import org.springframework.beans.factory.annotation.Autowired;

public class SceneController {
	
	@Autowired
	private SceneRepository sceneRepo;

	public Iterable<Scene> findAllScenes() {
		return sceneRepo.findAll();
	}

	public Scene findOneScene(Long id) {
		return sceneRepo.findById(id).get();
	}

}
