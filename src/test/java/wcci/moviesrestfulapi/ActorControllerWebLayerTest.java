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
		actor = new Actor("name");
		mapper = new ObjectMapper();
	}

	@Test
	public void shouldReturnAllActors() throws Exception {
		when(actorRepo.findAll()).thenReturn(Collections.singletonList(actor));
		mockMvc.perform(get("/api/actors")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8")).andExpect(content().json("[{}]"))
				.andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(actor)), true));
	}

	@Test
	public void shouldReturnOneActor() throws Exception {
		when(actorRepo.findById(1L)).thenReturn(Optional.of(actor));
		mockMvc.perform(get("/api/actors/1")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8")).andExpect(content().json("{}"))
				.andExpect(content().json(mapper.writeValueAsString(actor), true));
	}
}