package com.example.internintelligence_movie.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "movies")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String releaseYear;
    private Double IMDbRating;

    @ManyToMany(mappedBy = "movies", fetch = FetchType.EAGER, cascade = { CascadeType.MERGE, CascadeType.PERSIST})
    private Set<DirectorEntity> directors;

    @ManyToMany(mappedBy = "movies", fetch = FetchType.EAGER, cascade = { CascadeType.MERGE, CascadeType.PERSIST})
    private Set<GenreEntity> genres;

    public MovieEntity(){
    }
}
