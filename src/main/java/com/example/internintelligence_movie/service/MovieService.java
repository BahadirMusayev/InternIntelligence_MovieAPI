package com.example.internintelligence_movie.service;

import com.example.internintelligence_movie.dao.entity.MovieEntity;
import com.example.internintelligence_movie.dao.entity.enums.GenreType;
import com.example.internintelligence_movie.dao.exception.FoundException;
import com.example.internintelligence_movie.dao.repository.MovieRepository;
import com.example.internintelligence_movie.mapper.MovieMapper;
import com.example.internintelligence_movie.model.MovieDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    @Transactional
    public void addMovie(MovieDto movieDto, Set<GenreType> genre) {
        log.info("Add Movie Started... ");

        MovieEntity movieEntity = movieRepository.
                findByTitleIgnoreCaseAndReleaseYear(movieDto.getTitle(), movieDto.getReleaseYear());

        if (movieEntity != null) {
            throw new FoundException("This Movie is Found !");
        }

        MovieEntity movie = movieMapper.mapDtoToEntity(movieDto);
        movie.setGenre(genre);
        movieRepository.save(movie);

        log.info("Add Movie Ended ");
    }

    public MovieDto getMovie(){

    }
}
