package com.example.internintelligence_movie.model.output;


import com.example.internintelligence_movie.dao.entity.enums.GenreType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MovieDtoOutput {
    private String title;
    private Integer releaseYear;
    private Double IMDbRating;
    private String director;
    private Set<GenreType> genres;
}
