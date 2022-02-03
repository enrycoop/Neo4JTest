package com.example.Neo4JTest.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Node // Node Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @Property("first_name")
    private String name;
    private Integer age;


}
