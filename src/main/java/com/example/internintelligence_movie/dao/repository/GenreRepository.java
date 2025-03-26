package com.example.internintelligence_movie.dao.repository;

import com.example.internintelligence_movie.dao.entity.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<GenreEntity, Integer> {
}
