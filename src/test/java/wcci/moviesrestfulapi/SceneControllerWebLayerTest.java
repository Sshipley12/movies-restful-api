package wcci.moviesrestfulapi;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(SceneController.class)
@RunWith(SpringRunner.class)
public class SceneControllerWebLayerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private SceneRepository sceneRepo;

	private Actor actor;
	private Movie movie;
	private Scene scene;
	private ObjectMapper mapper;

	@Before
	public void setup() {
		actor = new Actor("actor name");
		movie = new Movie(actor, "movie name");
		scene = new Scene(movie, "scene name");
		mapper = new ObjectMapper();
	}

	@Test
	public void shouldReturnAllScenes() throws Exception {
		when(sceneRepo.findAll()).thenReturn(Collections.singletonList(scene));
		mockMvc.perform(get("/api/scenes")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8")).andExpect(content().json("[{}]"))
				.andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(scene)), true));
	}

	@Test
	public void shouldReturnOneScene() throws Exception {
		when(sceneRepo.findById(1L)).thenReturn(Optional.of(scene));
		mockMvc.perform(get("/api/scenes/1")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8")).andExpect(content().json("{}"))
				.andExpect(content().json(mapper.writeValueAsString(scene), true));
	}

}
