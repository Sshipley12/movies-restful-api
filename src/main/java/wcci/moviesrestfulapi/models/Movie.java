package wcci.moviesrestfulapi.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Movie {

	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String imageUrl;
	@ManyToOne
	@JsonIgnore
	private Actor actor;

	@OneToMany(mappedBy = "movie")
	private Set<Scene> scenes;

	public Movie(Actor actor, String title, String imageUrl) {
		this.actor = actor;
		this.title = title;
		this.imageUrl = imageUrl;
		this.scenes = new HashSet<>();
	}

	public Movie() {

	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public Actor getActor() {
		return actor;
	}

	public Set<Scene> getScenes() {
		return scenes;
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
		Movie other = (Movie) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
