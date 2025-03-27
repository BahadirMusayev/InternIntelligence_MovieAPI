package com.example.internintelligence_movie.mapper;

import com.example.internintelligence_movie.dao.entity.MovieEntity;
import com.example.internintelligence_movie.model.MovieDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    @Mapping(target = "title", source = "title")
    @Mapping(target = "releaseYear", source = "releaseYear")
    @Mapping(target = "IMDbRating", source = "IMDbRating")
    @Mapping(target = "director.name", source = "director")
    MovieEntity mapDtoToEntity(MovieDto movieDto);
}
