package com.training.ott.service;

import com.training.ott.model.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> getAllMovies();

    List<Movie> getMoviesByGenre(String genre);

    Movie getMovieById(Long id);

    Movie addMovie(Movie movie);

    Movie updateMovie(Long id, Movie movie);

    void deleteMovie(Long id);

}
