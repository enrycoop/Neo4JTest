package com.example.Neo4JTest;

import com.example.Neo4JTest.models.Actor;
import com.example.Neo4JTest.models.Movie;
import com.example.Neo4JTest.models.Role;
import com.example.Neo4JTest.models.User;
import com.example.Neo4JTest.repositories.ActorRepository;
import com.example.Neo4JTest.repositories.MovieRepository;
import com.example.Neo4JTest.repositories.UserRepository;
import com.example.Neo4JTest.services.MovieService;
import com.example.Neo4JTest.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Neo4JTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(Neo4JTestApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserRepository userRepository,
											   MovieRepository movieRepository,
											   ActorRepository actorRepository,
											   UserService userService){
		return args -> {

			userRepository.deleteAll();
			movieRepository.deleteAll();
			actorRepository.deleteAll();

			User u1 = User.builder().age(21).name("Ben").build();
			User u2 = User.builder().age(31).name("Jane").build();
			User u3 = User.builder().age(54).name("Dave").build();
			User u4 = User.builder().age(12).name("Christine").build();

			Actor a1 = Actor.builder().name("Leonardo DiCaprio").build();
			Actor a2 = Actor.builder().name("Joseph Gordon-Levitt").build();
			Actor a3 = Actor.builder().name("Anne Hathaway").build();
			Actor a4 = Actor.builder().name("Michael Caine").build();

			Role r1 = Role.builder()
					.roles(List.of("Cobb"))
					.actors(a1).build();
			Role r2 = Role.builder()
					.roles(List.of("Arthur"))
					.actors(a2).build();
			Role r3 = Role.builder()
					.roles(List.of("Amelia"))
					.actors(a3).build();

			Role r4 = Role.builder()
					.roles(List.of("Professor Brand"))
					.actors(a4).build();
			Role r5 = Role.builder()
					.roles(List.of("Miles"))
					.actors(a4).build();

			Movie m1 = Movie.builder()
					.director("Cristopher Nolan")
					.title("Inception")
					.usersWhoRated(List.of(u1,u2,u3))
					.actors(List.of(r1,r2,r5))
					.build();

			Movie m2 = Movie.builder()
					.director("Cristopher Nolan")
					.title("Interstellar")
					.usersWhoRated(List.of(u1,u3,u4))
					.actors(List.of(r3,r4))
					.build();

			userRepository.saveAll(List.of(u1,u2,u3,u4));
			actorRepository.saveAll(List.of(a1,a2,a3,a4));
			movieRepository.saveAll(List.of(m1,m2));

			movieRepository.findMovieRatedByUsername(u1.getName()).forEach(System.out::println);
			userService.updateUserName("Ben","Bennet");

		};
	}
}
