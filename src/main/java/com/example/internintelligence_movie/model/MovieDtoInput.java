package com.example.internintelligence_movie.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MovieDtoInput {
    private String title;
    private Integer releaseYear;
    private Double IMDbRating;
    private String director;
}
