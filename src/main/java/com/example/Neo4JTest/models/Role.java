package com.example.Neo4JTest.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RelationshipProperties
public class Role {

    @RelationshipId
    private Long id;

    private List<String> roles;

    @TargetNode
    private Actor actors;
}
