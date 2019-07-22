package wcci.moviesrestfulapi;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Actor {

	@Id
	@GeneratedValue
	private Long id;
	
	@OneToMany(mappedBy = "actor")
	private Set<Movie> movies;

	private String name;

	public Actor(String name) {
		this.name = name;
		this.movies = new HashSet<>();
	}

	public Actor() {

	}

	public Long getId() {
		return id;
	}

	public Set<Movie> getMovies() {
		return movies;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actor other = (Actor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
