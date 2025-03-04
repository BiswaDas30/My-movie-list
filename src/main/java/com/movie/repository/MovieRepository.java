package com.movie.repository;


import com.movie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, String> {
    @Modifying
    @Transactional
    @Query(value = "TRUNCATE TABLE movie", nativeQuery = true)
    void truncateMovieTable();


    @Query("SELECT m FROM Movie m WHERE (:movieName IS NULL OR m.movieName = :movieName) " +
            "AND (:movieType IS NULL OR m.movieType = :movieType) " +
            "AND (:movieLanguage IS NULL OR m.movieLanguage = :movieLanguage) " +
            "AND (:movieRating IS NULL OR m.movieRating = :movieRating) " +
            "AND (:movieYear IS NULL OR m.movieYear = :movieYear)")
    List<Movie> findByAdvancedSearch(@Param("movieName") String movieName,
                                     @Param("movieType") String movieType,
                                     @Param("movieLanguage") String movieLanguage,
                                     @Param("movieRating") String movieRating,
                                     @Param("movieYear") Integer movieYear);


}
