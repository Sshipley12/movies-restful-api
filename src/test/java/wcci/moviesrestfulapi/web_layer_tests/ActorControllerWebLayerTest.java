package wcci.moviesrestfulapi.web_layer_tests;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import wcci.moviesrestfulapi.controllers.ActorController;
import wcci.moviesrestfulapi.models.Actor;
import wcci.moviesrestfulapi.repositories.ActorRepository;

@WebMvcTest(ActorController.class)
@RunWith(SpringRunner.class)
public class ActorControllerWebLayerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private ActorRepository actorRepo;
	
	private Actor actor;
	private ObjectMapper mapper;

	@Before
	public void setup() {
		actor = new Actor("name", "imageUrl");
		mapper = new ObjectMapper();
	}

	@Test
	public void shouldReturnAllActors() throws Exception {
		when(actorRepo.findAll()).thenReturn(Collections.singletonList(actor));
		mockMvc.perform(get("/api/actors"))
			.andExpect(status().isOk())
			.andExpect(content().contentType("application/json;charset=UTF-8"))
			.andExpect(content().json("[{}]"))
			.andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(actor)), true));
	}

	@Test
	public void shouldReturnOneActor() throws Exception {
		when(actorRepo.findById(1L)).thenReturn(Optional.of(actor));
		mockMvc.perform(get("/api/actors/1"))
			.andExpect(status().isOk())
			.andExpect(content().contentType("application/json;charset=UTF-8"))
			.andExpect(content().json("{}"))
			.andExpect(content().json(mapper.writeValueAsString(actor), true));
	}

	@Test
	public void shouldAddAnActor() throws Exception {
		when(actorRepo.save(any(Actor.class))).thenReturn(actor);
		when(actorRepo.findAll()).thenReturn(Collections.singletonList(actor));
		mockMvc.perform(post("/api/actors")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsString(actor)))
                .andExpect(status().isOk())
				.andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(actor))));
	}
}
