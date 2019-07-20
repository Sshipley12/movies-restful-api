package wcci.moviesrestfulapi;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaMappingTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private ActorRepository actorRepo;
	@Autowired
	private SceneRepository sceneRepo;
	
	private Actor actor;
	private Scene scene;
	
	
	
	@Before
	public void setUp() {
		actor = new Actor("name");
		actorRepo.save(actor);
		scene = new Scene("scene");
		sceneRepo.save(scene);
		entityManager.flush();
		entityManager.clear();
	}
	
	@Test
	public void shouldStartJpaTestFrameWork() {
		
	}
	
	@Test
	public void shouldSaveAndLoadActor() {
		Actor underTest = actorRepo.findById(actor.getId()).get();
		String name = underTest.getName();
		assertThat(name, is("name"));
	}
	@Test
	public void shouldSaveAndLoadScene() {
		Scene underTest = sceneRepo.findById(scene.getId()).get();
		String scene = underTest.getScene();
		assertThat(scene, is("scene"));
	}
}
