package com.movie.controller;

import com.movie.model.Movie;
import com.movie.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
    @GetMapping("/")
    public String home() {
        return "Welcome to Movie Application";
    }

    @GetMapping("/movieList")
    public List<Movie> getAllMovieDetails() {
        return movieService.getAllMovies();
    }

    @GetMapping("/movieById/{movieId}")
    public Movie getMovieById(@PathVariable("movieId") int movieId) {
        Optional<Movie> movie = movieService.getMovieById(String.valueOf(movieId));

        return movie.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build()).getBody();
    }

    @PostMapping(value = {"/save"})
    public Movie saveMovie(@RequestBody Movie movie) {
        return movieService.saveMovie(movie);
    }

    @PostMapping(value = {"/saveAll"})
    public List<Movie> saveAllMovies(@RequestBody List<Movie> movies) {
        return movieService.saveAllMovies(movies);
    }

    @DeleteMapping("/delete/{movieId}")
    public void deleteMovie(@PathVariable("movieId") int movieId) {
        movieService.deleteMovie(String.valueOf(movieId));
    }
    @PostMapping("/deleteAll")
    public void deleteAllMovies() {
        movieService.deleteAllMovies();
    }
}
