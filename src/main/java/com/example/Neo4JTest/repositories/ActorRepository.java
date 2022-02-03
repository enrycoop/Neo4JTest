package com.example.Neo4JTest.repositories;

import com.example.Neo4JTest.models.Actor;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ActorRepository extends Neo4jRepository<Actor,Long> {
}
