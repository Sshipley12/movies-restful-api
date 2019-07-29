package wcci.moviesrestfulapi.models;

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
	private String name;
	private String imageUrl;
	private String age;
	@OneToMany(mappedBy = "actor")
	private Set<Movie> movies;

	public Actor(String name, String imageUrl, String age) {
		this.name = name;
		this.imageUrl = imageUrl;
		this.age = age;
		this.movies = new HashSet<>();
	}

	protected Actor() {

	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public String getAge() {
		return age;
	}

	public Set<Movie> getMovies() {
		return movies;
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
