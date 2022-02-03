package com.example.Neo4JTest.repositories;

import com.example.Neo4JTest.models.Actor;
import com.example.Neo4JTest.models.Movie;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends Neo4jRepository<Movie,Long> {
    public Optional<Movie> getMovieByTitle(String title);

    @Query("MATCH (m:Movie)-[RATED_BY]->(u:User) WHERE( u.first_name =~ $userName ) RETURN m")
    public List<Movie> findMovieRatedByUsername(String userName);
}
