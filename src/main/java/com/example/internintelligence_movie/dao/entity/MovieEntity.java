package com.example.internintelligence_movie.dao.entity;

import com.example.internintelligence_movie.dao.entity.enums.GenreType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "movies")
@Table(name = "movies", indexes = {
        @Index(name = "idx_movie_title", columnList = "title"),
        @Index(name = "idx_movie_releaseYear", columnList = "releaseYear"),
        @Index(name = "idx_barber_director_id", columnList = "director_id")})
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private Integer releaseYear;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "genres")
    private Set<GenreType> genres;
    private Double IMDbRating;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST})
    @JoinColumn(name = "director_id", referencedColumnName = "id")
    @JsonBackReference
    private DirectorEntity director;

    public MovieEntity(){
    }
}
