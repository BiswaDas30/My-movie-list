package com.movie.service;

import com.movie.model.Movie;
import com.movie.repository.MovieRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
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

    @Transactional
    public void resetMoviesTable() {
        movieRepository.truncateMovieTable();
    }

    public List<Movie> getMovieByAdvancedSearch(String movieName, String movieType, String movieLanguage, String movieRating, int movieYear) {
        return movieRepository.findByAdvancedSearch(
                movieName.isEmpty() ? null : movieName,
                movieType.isEmpty() ? null : movieType,
                movieLanguage.isEmpty() ? null : movieLanguage,
                movieRating.isEmpty() ? null : movieRating,
                movieYear == 0 ? null : movieYear
        );
    }
}
