package com.movie.service;

import com.movie.model.Movie;
import com.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(String movieId) {
        return movieRepository.findById(movieId);
    }

    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> saveAllMovies(List<Movie> movies) {
        return movieRepository.saveAll(movies);
    }

    public void deleteMovie(String movieId) {
        movieRepository.deleteById(movieId);
    }

    public void deleteAllMovies() {
        movieRepository.deleteAll();
    }
}
