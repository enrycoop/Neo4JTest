package com.example.Neo4JTest.controllers;

import com.example.Neo4JTest.models.Movie;
import com.example.Neo4JTest.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/movies")
public class MovieController {

    @Autowired
    private final MovieService movieService;

    @GetMapping
    public List<Movie> getMovies(){
        return movieService.fetchMovies();
    }

    @GetMapping(path = "{title}")
    public Movie getMovie(@PathVariable("title") String title) {
        return movieService.fetchMovie(title);
    }
}
