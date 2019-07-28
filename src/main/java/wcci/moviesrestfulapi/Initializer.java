package wcci.moviesrestfulapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import wcci.moviesrestfulapi.models.Actor;
import wcci.moviesrestfulapi.models.Movie;
import wcci.moviesrestfulapi.models.Scene;
import wcci.moviesrestfulapi.repositories.ActorRepository;
import wcci.moviesrestfulapi.repositories.MovieRepository;
import wcci.moviesrestfulapi.repositories.SceneRepository;

@Service
public class Initializer implements CommandLineRunner {
	
	@Autowired
	private ActorRepository actorRepo;
	@Autowired
	private MovieRepository movieRepo;
	@Autowired
	private SceneRepository sceneRepo;
	
	Actor chris;
	Actor bradley;
	Actor leo;
	Actor will;
	Actor margot;
	Actor jennifer;
	Actor scarlett;
	
	Movie thor1;
	Movie thor2;
	Movie thor3;
	Movie hangover1;
	Movie hangover2;
	Movie hangover3;
	Movie star;
	Movie titanic;
	Movie robot;
	Movie tarzan;
	Movie suicideSquad;
	Movie peterRabbit;
	Movie hungerGames1;
	Movie hungerGames2;
	Movie avengers1;
	
	@Override
    public void run(String... args) throws Exception {
		populateActors();
		populateMovies();
		populateScenes();
	}

	private void populateActors() {
		chris = new Actor("Chris Hemsworth", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4c/Chris_Hemsworth_by_Gage_Skidmore.jpg/330px-Chris_Hemsworth_by_Gage_Skidmore.jpg", "35");
		bradley = new Actor("Bradley Cooper", "https://upload.wikimedia.org/wikipedia/commons/thumb/b/bd/Glasto17-44_%2835547413626%29_Cropped.jpg/330px-Glasto17-44_%2835547413626%29_Cropped.jpg", "44");
		leo = new Actor("Leonardo DiCaprio", "https://www.indiewire.com/wp-content/uploads/2019/07/Screen-Shot-2019-07-24-at-12.18.54-PM.png?w=780", "44");
		will = new Actor("Will Smith", "https://upload.wikimedia.org/wikipedia/commons/thumb/6/67/Will_Smith_by_Gage_Skidmore_2.jpg/330px-Will_Smith_by_Gage_Skidmore_2.jpg", "50");
		margot = new Actor("Margot Robbie", "https://upload.wikimedia.org/wikipedia/commons/thumb/9/98/Margot_Robbie_at_Somerset_House_in_2013_%28cropped%29.jpg/330px-Margot_Robbie_at_Somerset_House_in_2013_%28cropped%29.jpg", "29");
		jennifer = new Actor("Jennifer Lawrence", "https://upload.wikimedia.org/wikipedia/commons/4/4f/Jennifer_Lawrence_at_the_83rd_Academy_Awards_crop.jpg", "28");
		scarlett = new Actor("Scarlett Johansson", "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1b/Scarlett_Johansson_SDCC_2013_by_Gage_Skidmore_1.jpg/330px-Scarlett_Johansson_SDCC_2013_by_Gage_Skidmore_1.jpg", "34");
		
		actorRepo.save(chris);
		actorRepo.save(bradley);
		actorRepo.save(leo);
		actorRepo.save(will);
		actorRepo.save(margot);
		actorRepo.save(jennifer);
		actorRepo.save(scarlett);
	}

	private void populateMovies() {
		thor1 = new Movie(chris, "Thor", "https://upload.wikimedia.org/wikipedia/en/f/fc/Thor_poster.jpg", "Thor is a 2011 American superhero film");
		thor2 = new Movie(chris, "Thor: The Dark World", "https://upload.wikimedia.org/wikipedia/en/7/7e/Thor_-_The_Dark_World_poster.jpg", "Thor: The Dark World is a 2013 American superhero film");
		thor3 = new Movie(chris, "Thor: Ragnarok", "https://upload.wikimedia.org/wikipedia/en/7/7d/Thor_Ragnarok_poster.jpg", "Thor: Ragnarok is a 2017 American superhero film");
		hangover1 = new Movie(bradley, "The Hangover", "https://upload.wikimedia.org/wikipedia/en/b/b9/Hangoverposter09.jpg", "The Hangover is a 2009 American comedy film");
		hangover2 = new Movie(bradley, "The Hangover II", "https://upload.wikimedia.org/wikipedia/en/9/9d/HangoverPart2MP2011.jpg", "The Hangover Part II is a 2011 American comedy film");
		hangover3 = new Movie(bradley, "The Hangover III","https://upload.wikimedia.org/wikipedia/en/1/15/The_Hangover_Part_3.JPG", "The Hangover Part III is a 2013 American comedy film");
		star = new Movie(bradley, "A Star Is Born", "https://upload.wikimedia.org/wikipedia/en/3/39/A_Star_is_Born.png", "A Star Is Born is a 2018 American romantic drama film");
		titanic = new Movie(leo, "Titanic", "https://upload.wikimedia.org/wikipedia/en/1/19/Titanic_%28Official_Film_Poster%29.png", "Titanic is a 1997 American epic romance and disaster film");
		robot = new Movie(will, "I, Robot", "https://upload.wikimedia.org/wikipedia/en/3/3b/Movie_poster_i_robot.jpg", "I, Robot is a 2004 American science fiction action film");
		tarzan = new Movie(margot, "The Legend of Tarzan", "https://upload.wikimedia.org/wikipedia/en/e/e5/The_Legend_of_Tarzan_poster.jpg", "The Legend of Tarzan is a 2016 adventure film");
		suicideSquad = new Movie(margot, "Suicide Squad", "https://upload.wikimedia.org/wikipedia/en/5/50/Suicide_Squad_%28film%29_Poster.png", "Suicide Squad is a 2016 American superhero film");
		peterRabbit = new Movie(margot, "Peter Rabbit", "https://upload.wikimedia.org/wikipedia/en/3/3d/Peter-rabbit-teaser.jpg", "Peter Rabbit is a 2018 American live-action/computer-animated comedy film");
		hungerGames1 = new Movie(jennifer, "The Hunger Games", "https://upload.wikimedia.org/wikipedia/en/4/42/HungerGamesPoster.jpg", "The Hunger Games is a 2012 American dystopian science fiction-adventure film");
		hungerGames2 = new Movie(jennifer, "The Hunger Games: Catching Fire", "https://upload.wikimedia.org/wikipedia/en/1/12/Catching-Fire_poster.jpg", "The Hunger Games: Catching Fire is a 2013 American dystopian science fiction adventure film"); 
		avengers1 = new Movie(scarlett, "The Avengers", "https://upload.wikimedia.org/wikipedia/en/f/f9/TheAvengers2012Poster.jpg", "The Avengers is a 2012 American superhero film");
		
		movieRepo.save(thor1);
		movieRepo.save(thor2);
		movieRepo.save(thor3);
		movieRepo.save(hangover1);
		movieRepo.save(hangover2);
		movieRepo.save(hangover3);
		movieRepo.save(star);
		movieRepo.save(titanic);
		movieRepo.save(robot);
		movieRepo.save(tarzan);
		movieRepo.save(suicideSquad);
		movieRepo.save(peterRabbit);
		movieRepo.save(hungerGames1);
		movieRepo.save(hungerGames2);
		movieRepo.save(avengers1);
	}

	private void populateScenes() {
		Scene thor1Scene1 = new Scene(thor1, "scene1", "https://www.youtube.com/watch?v=JOddp-nlNvQ");
		Scene thor1Scene2 = new Scene(thor1, "scene2", "https://www.youtube.com/watch?v=JOddp-nlNvQ");
		Scene thor1Scene3 = new Scene(thor1, "scene3", "https://www.youtube.com/watch?v=JOddp-nlNvQ");
		Scene thor2Scene1 = new Scene(thor2, "scene1", "https://www.youtube.com/watch?v=npvJ9FTgZbM");
		Scene thor2Scene2 = new Scene(thor2, "scene2", "https://www.youtube.com/watch?v=npvJ9FTgZbM");
		Scene thor2Scene3 = new Scene(thor2, "scene3", "https://www.youtube.com/watch?v=npvJ9FTgZbM");
		Scene thor3Scene1 = new Scene(thor3, "scene1", "https://www.youtube.com/watch?v=ue80QwXMRHg");
		Scene thor3Scene2 = new Scene(thor3, "scene2", "https://www.youtube.com/watch?v=ue80QwXMRHg");
		Scene thor3Scene3 = new Scene(thor3, "scene3", "https://www.youtube.com/watch?v=ue80QwXMRHg");
		Scene hangover1Scene1 = new Scene(hangover1, "scene1", "https://www.youtube.com/watch?v=tlize92ffnY");
		Scene hangover1Scene2 = new Scene(hangover1, "scene2", "https://www.youtube.com/watch?v=tlize92ffnY");
		Scene hangover1Scene3 = new Scene(hangover1, "scene3", "https://www.youtube.com/watch?v=tlize92ffnY");
		Scene hangover2Scene1 = new Scene(hangover2, "scene1", "https://www.youtube.com/watch?v=ohF5ZO_zOYU");
		Scene hangover2Scene2 = new Scene(hangover2, "scene2", "https://www.youtube.com/watch?v=ohF5ZO_zOYU");
		Scene hangover2Scene3 = new Scene(hangover2, "scene3", "https://www.youtube.com/watch?v=ohF5ZO_zOYU");
		Scene hangover3Scene1 = new Scene(hangover3, "scene1", "https://www.youtube.com/watch?v=96TelFMZwHc");
		Scene hangover3Scene2 = new Scene(hangover3, "scene2", "https://www.youtube.com/watch?v=96TelFMZwHc");
		Scene hangover3Scene3 = new Scene(hangover3, "scene3", "https://www.youtube.com/watch?v=96TelFMZwHc");
		Scene starScene1 = new Scene(star, "scene1", "https://www.youtube.com/watch?v=nSbzyEJ8X9E");
		Scene starScene2 = new Scene(star, "scene2", "https://www.youtube.com/watch?v=nSbzyEJ8X9E");
		Scene starScene3 = new Scene(star, "scene3", "https://www.youtube.com/watch?v=nSbzyEJ8X9E");
		Scene titanicScene1 = new Scene(titanic, "scene1", "https://www.youtube.com/watch?v=zCy5WQ9S4c0");
		Scene titanicScene2 = new Scene(titanic, "scene2", "https://www.youtube.com/watch?v=zCy5WQ9S4c0");
		Scene titanicScene3 = new Scene(titanic, "scene3", "https://www.youtube.com/watch?v=zCy5WQ9S4c0");
		Scene robotScene1 = new Scene(robot, "scene1", "https://www.youtube.com/watch?v=rL6RRIOZyCM");
		Scene robotScene2 = new Scene(robot, "scene2", "https://www.youtube.com/watch?v=rL6RRIOZyCM");
		Scene robotScene3 = new Scene(robot, "scene3", "https://www.youtube.com/watch?v=rL6RRIOZyCM");
		Scene tarzanScene1 = new Scene(tarzan, "scene1", "https://www.youtube.com/watch?v=Aj7ty6sViiU");
		Scene tarzanScene2 = new Scene(tarzan, "scene2", "https://www.youtube.com/watch?v=Aj7ty6sViiU");
		Scene tarzanScene3 = new Scene(tarzan, "scene3", "https://www.youtube.com/watch?v=Aj7ty6sViiU");
		Scene suicideSquadScene1 = new Scene(suicideSquad, "scene1", "https://www.youtube.com/watch?v=CmRih_VtVAs");
		Scene suicideSquadScene2 = new Scene(suicideSquad, "scene2", "https://www.youtube.com/watch?v=CmRih_VtVAs");
		Scene suicideSquadScene3 = new Scene(suicideSquad, "scene3", "https://www.youtube.com/watch?v=CmRih_VtVAs");
		Scene peterRabbitScene1 = new Scene(peterRabbit, "scene1", "https://www.youtube.com/watch?v=7Pa_Weidt08");
		Scene hungerGames1Scene1 = new Scene(hungerGames1, "scene1", "https://www.youtube.com/watch?v=mfmrPu43DF8");
		Scene hungerGames1Scene2 = new Scene(hungerGames1, "scene2", "https://www.youtube.com/watch?v=mfmrPu43DF8");
		Scene hungerGames2Scene1 = new Scene(hungerGames2, "scene1", "https://www.youtube.com/watch?v=EAzGXqJSDJ8");
		Scene hungerGames2Scene2 = new Scene(hungerGames2, "scene2", "https://www.youtube.com/watch?v=EAzGXqJSDJ8");
		Scene hungerGames2Scene3 = new Scene(hungerGames2, "scene3", "https://www.youtube.com/watch?v=EAzGXqJSDJ8");
		Scene avengers1Scene1 = new Scene(avengers1, "scene1", "https://www.youtube.com/watch?v=eOrNdBpGMv8");
		Scene avengers1Scene2 = new Scene(avengers1, "scene2", "https://www.youtube.com/watch?v=eOrNdBpGMv8");
		Scene avengers1Scene3 = new Scene(avengers1, "scene3", "https://www.youtube.com/watch?v=eOrNdBpGMv8");
		Scene avengers1Scene4 = new Scene(avengers1, "scene4", "https://www.youtube.com/watch?v=eOrNdBpGMv8");
		
		sceneRepo.save(thor1Scene1);
		sceneRepo.save(thor1Scene2);
		sceneRepo.save(thor1Scene3);
		sceneRepo.save(thor2Scene1);
		sceneRepo.save(thor2Scene2);
		sceneRepo.save(thor2Scene3);
		sceneRepo.save(thor3Scene1);
		sceneRepo.save(thor3Scene2);
		sceneRepo.save(thor3Scene3);
		sceneRepo.save(hangover1Scene1);
		sceneRepo.save(hangover1Scene2);
		sceneRepo.save(hangover1Scene3);
		sceneRepo.save(hangover2Scene1);
		sceneRepo.save(hangover2Scene2);
		sceneRepo.save(hangover2Scene3);
		sceneRepo.save(hangover3Scene1);
		sceneRepo.save(hangover3Scene2);
		sceneRepo.save(hangover3Scene3);
		sceneRepo.save(starScene1);
		sceneRepo.save(starScene2);
		sceneRepo.save(starScene3);
		sceneRepo.save(titanicScene1);
		sceneRepo.save(titanicScene2);
		sceneRepo.save(titanicScene3);
		sceneRepo.save(robotScene1);
		sceneRepo.save(robotScene2);
		sceneRepo.save(robotScene3);
		sceneRepo.save(tarzanScene1);
		sceneRepo.save(tarzanScene2);
		sceneRepo.save(tarzanScene3);
		sceneRepo.save(suicideSquadScene1);
		sceneRepo.save(suicideSquadScene2);
		sceneRepo.save(suicideSquadScene3);
		sceneRepo.save(peterRabbitScene1);
		sceneRepo.save(hungerGames1Scene1);
		sceneRepo.save(hungerGames1Scene2);
		sceneRepo.save(hungerGames2Scene1);
		sceneRepo.save(hungerGames2Scene2);
		sceneRepo.save(hungerGames2Scene3);
		sceneRepo.save(avengers1Scene1);
		sceneRepo.save(avengers1Scene2);
		sceneRepo.save(avengers1Scene3);
		sceneRepo.save(avengers1Scene4);
	}



}
