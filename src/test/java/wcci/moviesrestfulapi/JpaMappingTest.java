package wcci.moviesrestfulapi;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.greaterThan;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import wcci.moviesrestfulapi.models.Actor;
import wcci.moviesrestfulapi.models.Movie;
import wcci.moviesrestfulapi.models.Scene;
import wcci.moviesrestfulapi.repositories.ActorRepository;
import wcci.moviesrestfulapi.repositories.MovieRepository;
import wcci.moviesrestfulapi.repositories.SceneRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaMappingTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private ActorRepository actorRepo;
	
	@Autowired
	private SceneRepository sceneRepo;

	@Autowired
	private MovieRepository movieRepo;

	private Actor actor;
	private Movie movie1;
	private Movie movie2;
	private Scene scene1;
	private Scene scene2;

	@Before
	public void setUp() {
		actor = new Actor("name", "imageUrl");
		actorRepo.save(actor);
		movie1 = new Movie(actor, "movie title 1", "imageUrl");
		movieRepo.save(movie1);
		movie2 = new Movie(actor, "movie title 2", "imageUrl");
		movieRepo.save(movie2);
		scene1 = new Scene(movie1, "scene1");
		sceneRepo.save(scene1);
		scene2 = new Scene(movie1, "scene2");
		sceneRepo.save(scene2);
		entityManager.flush();
		entityManager.clear();
	}

	@Test
	public void shouldStartJpaTestFrameWork() {

	}

	@Test
	public void shouldSaveAndLoadAnActor() {
		Actor underTest = actorRepo.findById(actor.getId()).get();
		String name = underTest.getName();
		assertThat(name, is("name"));
	}
	
	@Test
	public void shouldGenerateActorId() {
		long id = actor.getId();
		assertThat(id, is(greaterThan(0L)));
	}

	@Test
	public void shouldSaveAndLoadScene() {
		Scene underTest = sceneRepo.findById(scene1.getId()).get();
		String scene = underTest.getName();
		assertThat(scene, is("scene1"));
	}
	
	@Test
	public void shouldGenerateSceneId() {
		long id = scene1.getId();
		assertThat(id, is(greaterThan(0L)));
	}
	
	@Test
	public void shouldSaveAndLoadAMovie() {
		Movie underTest = movieRepo.findById(movie1.getId()).get();
		assertThat(underTest.getTitle(), is("movie title 1"));
	}
	
	@Test
	public void shouldGenerateMovieId() {
		long id = movie1.getId();
		assertThat(id, is(greaterThan(0L)));
	}
	
	@Test
	public void shouldEstablishActorToMovieRelationship() {
		long id = actor.getId();
		Actor foundActor = actorRepo.findById(id).get();
		assertThat(foundActor.getMovies(), containsInAnyOrder(movie1, movie2));
	}
	
	@Test
	public void shouldEstablishMovieToSceneRelationship() {
		long id = movie1.getId();
		Movie foundMovie = movieRepo.findById(id).get();
		assertThat(foundMovie.getScenes(), containsInAnyOrder(scene1, scene2));
	}
	
}
