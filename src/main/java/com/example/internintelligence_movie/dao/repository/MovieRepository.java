package com.example.internintelligence_movie.dao.repository;

import com.example.internintelligence_movie.dao.entity.DirectorEntity;
import com.example.internintelligence_movie.dao.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {
    MovieEntity findByTitleIgnoreCaseAndReleaseYearAndDirector_Name(String title, Integer releaseYear, String director);
    List<MovieEntity> findByTitleIgnoreCase(String title);
}
