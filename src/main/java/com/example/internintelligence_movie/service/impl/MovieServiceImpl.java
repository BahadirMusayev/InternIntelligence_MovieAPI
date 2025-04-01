package com.example.internintelligence_movie.service.impl;

import com.example.internintelligence_movie.dao.entity.enums.GenreType;
import com.example.internintelligence_movie.model.input.MovieDtoInput;
import com.example.internintelligence_movie.model.output.MovieDtoOutput;
import com.example.internintelligence_movie.model.CRUDDto;

import java.util.List;
import java.util.Set;

public interface MovieServiceImpl {
    void add(MovieDtoInput movieDtoInput, Set<GenreType> genre);
    List<MovieDtoOutput> get(String title);
    void updateTitle(CRUDDto CRUDDto, String newTitle);
    void updateReleaseYear(CRUDDto CRUDDto, Integer newReleaseYear);
    void updateIMDbRating(CRUDDto CRUDDto, Double newIMDbRating);
    void updateDirector(CRUDDto CRUDDto, String newDirector);
    void delete(CRUDDto CRUDDto);
}
