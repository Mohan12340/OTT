package com.training.ott.controller;

import com.training.ott.model.Movie;
import com.training.ott.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping
    public List<Movie> getMovies() {
        return service.getAllMovies();
    }

    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable Long id) {
        return service.getMovieById(id);
    }

    @GetMapping("/genre/{genre}")
    public List<Movie> getMoviesByGenre(@PathVariable String genre) {
        return service.getMoviesByGenre(genre);
    }

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        return service.addMovie(movie);
    }

    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable Long id,
                             @RequestBody Movie movie) {
        return service.updateMovie(id, movie);
    }

    @DeleteMapping("/{id}")
    public String deleteMovie(@PathVariable Long id) {

        service.deleteMovie(id);

        return "Movie Deleted Successfully";
    }

}
