package com.example.Neo4JTest.repositories;

import com.example.Neo4JTest.models.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends Neo4jRepository<User,Long> {

    public Optional<User> getUserByName(String name);
}
