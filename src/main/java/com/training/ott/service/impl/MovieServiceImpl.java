package com.training.ott.service.impl;

import com.training.ott.model.Movie;
import com.training.ott.repository.MovieRepository;
import com.training.ott.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository repository;

    public MovieServiceImpl(MovieRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Movie> getAllMovies() {
        return repository.findAll();
    }

    @Override
    public List<Movie> getMoviesByGenre(String genre) {
        return repository.findByGenreIgnoreCase(genre);
    }

    @Override
    public Movie getMovieById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public Movie addMovie(Movie movie) {
        return repository.save(movie);
    }

    @Override
    public Movie updateMovie(Long id, Movie movie) {

        Movie existing = repository.findById(id).orElseThrow();

        existing.setTitle(movie.getTitle());
        existing.setGenre(movie.getGenre());
        existing.setRequiredPlan(movie.getRequiredPlan());

        return repository.save(existing);
    }

    @Override
    public void deleteMovie(Long id) {
        repository.deleteById(id);
    }
}
