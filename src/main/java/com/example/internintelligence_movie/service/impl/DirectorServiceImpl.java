package com.example.internintelligence_movie.service.impl;

import com.example.internintelligence_movie.model.MovieDtoOutput;

import java.util.List;

public interface DirectorServiceImpl {
    List<MovieDtoOutput> get(String name);
}
