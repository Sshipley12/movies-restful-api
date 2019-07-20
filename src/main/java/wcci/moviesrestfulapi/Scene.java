package wcci.moviesrestfulapi;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;





@Entity
public class Scene {
	@Id
	@GeneratedValue
	private Long id;

	private String scene;
	
	public Scene() {
	}
	
	

	public Scene(String scene) {
		this.scene = scene;
	}

	public String getScene() {
		
		return scene;
	}

	public Long getId() {
		
		return id;
	}

}
