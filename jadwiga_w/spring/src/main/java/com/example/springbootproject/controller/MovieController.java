package com.example.springbootproject.controller;

import com.example.springbootproject.domain.Movie;
import com.example.springbootproject.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        return movieService.findAllMovies();
    }

    @GetMapping("/movies/{id}")
    public Movie getMovieById(@PathVariable("id") Long id) {
        return movieService.findMovieIfPresent(id);
    }

    @PostMapping("/movies")
    @ResponseStatus(HttpStatus.CREATED)
    public Movie addNewMovie(@RequestBody Movie movie) {
        return movieService.createNewMovie(movie);
    }

    @PutMapping("/movies/{id}")
    public Movie updateMovieData(@RequestBody Movie updatedMovie, @PathVariable Long id) {
        return movieService.updateMovieData(updatedMovie, id);
    }

    @DeleteMapping("/movies/{id}")
    public Movie deleteMovie(@PathVariable Long id) {
        return movieService.deleteMovieById(id);

    }
}
