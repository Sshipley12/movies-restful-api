package wcci.moviesrestfulapi;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class MovieControllerTest {
	
	@InjectMocks
	private MovieController underTest;
	
	@Mock
	private MovieRepository movieRepo;
	
	@Mock
	private Movie movie1;
	
	@Mock
	private Movie movie2;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldReturnAListOfMovies() throws Exception {
		when(movieRepo.findAll()).thenReturn(Arrays.asList(movie1, movie2));
		assertThat(underTest.findAllMovies(), containsInAnyOrder(movie1, movie2));	
	}
	
	@Test
	public void shouldReturnOneMovie() throws Exception {
		when(movieRepo.findById(1L)).thenReturn(Optional.of(movie1));
		assertThat(underTest.findOneMovie(1L), is(movie1));
	}

}
