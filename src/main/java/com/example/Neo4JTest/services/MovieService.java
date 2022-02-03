package com.example.Neo4JTest.services;

import com.example.Neo4JTest.models.Movie;
import com.example.Neo4JTest.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    @Autowired
    private final MovieRepository movieRepository;

    public List<Movie> fetchMovies(){
        return movieRepository.findAll();
    }

    public Movie fetchMovie(String title){
        return movieRepository.getMovieByTitle(title).get();
    }

}
