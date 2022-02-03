package com.example.Neo4JTest.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Node
public class Movie {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String director;

    @ToString.Exclude
    @Relationship(type = "RATED_BY")
    //@JsonIgnoreProperties("ratedMovies") // per evitare la ricorsione infinita
    private List<User> usersWhoRated;

    @ToString.Exclude
    @Relationship(type = "ACT_IN", direction = Relationship.Direction.INCOMING)
    private List<Role> actors;
}
