package wcci.moviesrestfulapi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Actor {
	
	@Id
	@GeneratedValue
	private Long id;

	private String name;

	public Actor(String name) {
		this.name = name;
	}
	
	public Actor() {
		
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
