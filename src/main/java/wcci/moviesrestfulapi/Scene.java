package wcci.moviesrestfulapi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Scene {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	private Movie movie;

	private String name;

	public Scene(Movie movie, String name) {
		this.movie = movie;
		this.name = name;
	}

	public Scene() {

	}


	public Long getId() {
		return id;
	}

	public Movie getMovie() {
		return movie;
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
		Scene other = (Scene) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
