package com.movie.controller;

import com.movie.model.Movie;
import com.movie.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movieList")
    public List<Movie> getAllMovieDetails() {
        return movieService.getAllMovies();
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
        movieService.resetMoviesTable();
    }

    @GetMapping("/advancedSearch")
    public List<Movie> getMovieByAdvancedSearch(@RequestParam("name") String movieName,
                                         @RequestParam("type") String movieType,
                                         @RequestParam("language") String movieLanguage,
                                         @RequestParam("rating") String movieRating,
                                         @RequestParam("year") int movieYear) {
        return movieService.getMovieByAdvancedSearch(movieName, movieType, movieLanguage, movieRating, movieYear);
    }
}
