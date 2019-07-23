package wcci.moviesrestfulapi;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.hamcrest.Matchers.contains;

public class ActorContollerTest {
	@InjectMocks
	private ActorController underTest;
	@Mock
	private ActorRepository actorRepo;
	@Mock
	private Actor mockActor;
	@Mock
	private Actor mockActor2;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldReturnListOfActors() {
		when(actorRepo.findAll()).thenReturn(Collections.singletonList(mockActor));
		assertThat(underTest.findAllActors(), contains(mockActor));
	}
    @Test
    public void shouldReturnOneActor() {
    	when(actorRepo.findById(1L)).thenReturn(Optional.of(mockActor));
    	assertThat(underTest.findOneActor(1L), is(mockActor));
    	
    }
}
