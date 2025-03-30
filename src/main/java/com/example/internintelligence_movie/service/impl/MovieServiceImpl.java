package com.example.internintelligence_movie.service.impl;

import com.example.internintelligence_movie.dao.entity.enums.GenreType;
import com.example.internintelligence_movie.model.MovieDtoInput;
import com.example.internintelligence_movie.model.MovieDtoOutput;
import com.example.internintelligence_movie.model.UpdateDto;

import java.util.List;
import java.util.Set;

public interface MovieServiceImpl {
    void add(MovieDtoInput movieDtoInput, Set<GenreType> genre);
    List<MovieDtoOutput> get(String title);
    void updateTitle(UpdateDto updateDto, String newTitle);
    void updateReleaseYear(UpdateDto updateDto, Integer newReleaseYear);
    void updateIMDbRating(UpdateDto updateDto, Double newIMDbRating);
    void updateDirector(UpdateDto updateDto, String newDirector);
    void delete(UpdateDto updateDto);
}
