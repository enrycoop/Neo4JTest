#!/bin/bash

docker run \
    -p 7474:7474 -p 7687:7687 \
    --name n4j \
    -d \
    neo4j