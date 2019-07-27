package wcci.moviesrestfulapi.controllers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import wcci.moviesrestfulapi.controllers.SceneController;
import wcci.moviesrestfulapi.models.Scene;
import wcci.moviesrestfulapi.repositories.SceneRepository;

public class SceneControllerTest {
	
	@InjectMocks
	private SceneController underTest;
	
	@Mock
	private SceneRepository songRepo;
	
	@Mock
	private Scene scene1;
	
	@Mock
	private Scene scene2;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldReturnListOfScenes() throws Exception {
		when(songRepo.findAll()).thenReturn(Arrays.asList(scene1, scene2));
		assertThat(underTest.findAllScenes(), containsInAnyOrder(scene1, scene2));
	}
	
	@Test
	public void shouldReturnOneScene() throws Exception {
		when(songRepo.findById(1L)).thenReturn(Optional.of(scene1));
		assertThat(underTest.findOneScene(1L), is(scene1));
	}

}
