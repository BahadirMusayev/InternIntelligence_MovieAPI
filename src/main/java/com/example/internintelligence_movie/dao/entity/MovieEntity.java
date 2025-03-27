package com.example.internintelligence_movie.dao.entity;

import com.example.internintelligence_movie.dao.entity.enums.GenreType;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
    private Integer releaseYear;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<GenreType> genres;
    private Double IMDbRating;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "director_id", referencedColumnName = "id")
    @JsonBackReference
    private DirectorEntity director;

    public MovieEntity(){
    }
}
