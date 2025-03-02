package com.movie.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer movieId;

    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    private Integer movieYear;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String movieName;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String movieType;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String movieLanguage;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate movieReleaseDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String movieDuration;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String movieRating;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String movieDescription;
}