package com.example.internintelligence_movie.dao.repository;

import com.example.internintelligence_movie.dao.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {
    MovieEntity findByTitleIgnoreCaseAndReleaseYear(String name, Integer releaseYear);
}
