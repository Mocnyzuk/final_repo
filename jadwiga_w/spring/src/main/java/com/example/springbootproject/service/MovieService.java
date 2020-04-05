package com.example.springbootproject.service;

import com.example.springbootproject.domain.Movie;
import com.example.springbootproject.repository.MovieRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    public Movie findMovieIfPresent(long id) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if (optionalMovie.isPresent()) {
            return optionalMovie.get();
        } else throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Movie with id %d not found", id));
    }

    public Movie createNewMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie updateMovieData(Movie updatingMovie, Long id) {
        findMovieIfPresent(id);
        updatingMovie.setId(id);
        movieRepository.save(updatingMovie);
        return updatingMovie;
    }

    public Movie deleteMovieById(Long id) {
        Movie movieById = findMovieIfPresent(id);
        movieRepository.delete(movieById);
        return movieById;
    }


}
