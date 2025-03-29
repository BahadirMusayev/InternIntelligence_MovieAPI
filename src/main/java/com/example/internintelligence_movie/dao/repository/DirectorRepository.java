package com.example.internintelligence_movie.dao.repository;

import com.example.internintelligence_movie.dao.entity.DirectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<DirectorEntity, Integer> {
    DirectorEntity findByNameIgnoreCase(String name);
}
