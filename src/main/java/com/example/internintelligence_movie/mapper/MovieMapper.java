package com.example.internintelligence_movie.mapper;

import com.example.internintelligence_movie.dao.entity.MovieEntity;
import com.example.internintelligence_movie.model.input.MovieDtoInput;
import com.example.internintelligence_movie.model.output.MovieDtoOutput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    @Mapping(target = "title", source = "title")
    @Mapping(target = "releaseYear", source = "releaseYear")
    @Mapping(target = "IMDbRating", source = "IMDbRating")
    @Mapping(target = "director.name", source = "director")
    MovieEntity mapDtoInputToEntity(MovieDtoInput movieDtoInput);

    @Mapping(target = "title", source = "title")
    @Mapping(target = "releaseYear", source = "releaseYear")
    @Mapping(target = "IMDbRating", source = "IMDbRating")
    @Mapping(target = "director", source = "director.name")
    @Mapping(target = "genres", source = "genres")
    MovieDtoOutput mapEntityToDtoOutput(MovieEntity movieEntity);

    List<MovieDtoOutput> mapEntityToDtoOutputs(List<MovieEntity> movieEntities);
}
