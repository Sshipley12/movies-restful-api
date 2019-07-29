package wcci.moviesrestfulapi.web_layer_tests;

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

import wcci.moviesrestfulapi.controllers.MovieController;
import wcci.moviesrestfulapi.models.Actor;
import wcci.moviesrestfulapi.models.Movie;
import wcci.moviesrestfulapi.repositories.MovieRepository;

@WebMvcTest(MovieController.class)
@RunWith(SpringRunner.class)
public class MovieControllerWebLayerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private MovieRepository movieRepo;

	private Actor actor;

	private Movie movie;

	private ObjectMapper mapper;

	@Before
	public void setup() {
		actor = new Actor("actor name", "imageUrl", "age");
		movie = new Movie(actor, "movie name", "imageUrl", "description");
		mapper = new ObjectMapper();
	}

	@Test
	public void shouldReturnAllMovies() throws Exception {
		when(movieRepo.findAll()).thenReturn(Collections.singletonList(movie));
		mockMvc.perform(get("/api/movies")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8")).andExpect(content().json("[{}]"))
				.andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(movie)), true));

	}

	@Test
	public void shouldReturnOneMovie() throws Exception {
		when(movieRepo.findById(1L)).thenReturn(Optional.of(movie));
		mockMvc.perform(get("/api/movies/1")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8")).andExpect(content().json("{}"))
				.andExpect(content().json(mapper.writeValueAsString(movie), true));
	}

}
