package com.example.internintelligence_movie.service;

import com.example.internintelligence_movie.dao.entity.DirectorEntity;
import com.example.internintelligence_movie.dao.entity.MovieEntity;
import com.example.internintelligence_movie.dao.entity.enums.GenreType;
import com.example.internintelligence_movie.dao.exception.FoundException;
import com.example.internintelligence_movie.dao.exception.NotFoundException;
import com.example.internintelligence_movie.dao.repository.DirectorRepository;
import com.example.internintelligence_movie.dao.repository.MovieRepository;
import com.example.internintelligence_movie.mapper.MovieMapper;
import com.example.internintelligence_movie.model.UpdateDto;
import com.example.internintelligence_movie.model.MovieDtoInput;
import com.example.internintelligence_movie.model.MovieDtoOutput;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;
    private final DirectorRepository directorRepository;

    @Transactional
    public void add(MovieDtoInput movieDtoInput, Set<GenreType> genre) {
        log.info("Add Started... ");

        MovieEntity movieEntity = movieRepository.
                findByTitleIgnoreCaseAndReleaseYearAndDirector_Name(movieDtoInput.getTitle(),
                        movieDtoInput.getReleaseYear(), movieDtoInput.getDirector());

        if (movieEntity != null) {
            throw new FoundException("This Movie is Found !");
        }

        MovieEntity movie = movieMapper.mapDtoInputToEntity(movieDtoInput);
        movie.setGenres(genre);
        movieRepository.save(movie);

        log.info("Add Ended ");
    }

    public List<MovieDtoOutput> get(String title) {
        log.info("Get Started... ");

        List<MovieEntity> movieEntities = movieRepository.
                findByTitleIgnoreCase(title);
        return movieMapper.
                mapEntityToDtoOutputs(movieEntities);
    }

    public void updateTitle(UpdateDto updateDto, String newTitle) {
        log.info("Update Title Started... ");

        MovieEntity movieEntity = movieRepository.
                findByTitleIgnoreCaseAndReleaseYearAndDirector_Name(updateDto.getTitle(),
                        updateDto.getReleaseYear(), updateDto.getDirector());

        if (movieEntity == null) {
            throw new NotFoundException("This Movie is Not Found !");
        }

        movieEntity.setTitle(newTitle);
        movieRepository.save(movieEntity);

        log.info("Update Title Ended ");
    }

    public void updateReleaseYear(UpdateDto updateDto, Integer newReleaseYear) {
        log.info("Update Release Year Started... ");

        MovieEntity movieEntity = movieRepository.
                findByTitleIgnoreCaseAndReleaseYearAndDirector_Name(updateDto.getTitle(),
                        updateDto.getReleaseYear(), updateDto.getDirector());

        if (movieEntity == null) {
            throw new NotFoundException("This Movie is Not Found !");
        }

        movieEntity.setReleaseYear(newReleaseYear);
        movieRepository.save(movieEntity);

        log.info("Update Release Year Ended ");
    }

    public void updateIMDbRating(UpdateDto updateDto, Double newIMDbRating) {
        log.info("Update IMDb Rating Started... ");

        MovieEntity movieEntity = movieRepository.
                findByTitleIgnoreCaseAndReleaseYearAndDirector_Name(updateDto.getTitle(),
                        updateDto.getReleaseYear(), updateDto.getDirector());

        if (movieEntity == null) {
            throw new NotFoundException("This Movie is Not Found !");
        }

        movieEntity.setIMDbRating(newIMDbRating);
        movieRepository.save(movieEntity);

        log.info("Update IMDb Rating Ended ");
    }

    public void updateDirector(UpdateDto updateDto, String newDirector) {
        log.info("Update Director Started... ");

        MovieEntity movieEntity = movieRepository.
                findByTitleIgnoreCaseAndReleaseYearAndDirector_Name(updateDto.getTitle(),
                        updateDto.getReleaseYear(), updateDto.getDirector());

        if (movieEntity == null) {
            throw new NotFoundException("This Movie is Not Found !");
        }

        DirectorEntity directorEntity = movieEntity.getDirector();
        directorEntity.setName(newDirector);
        directorRepository.save(directorEntity);

        log.info("Update Director Ended ");
    }

    public void delete(UpdateDto updateDto) {
        log.info("Delete Started... ");

        MovieEntity movieEntity = movieRepository.
                findByTitleIgnoreCaseAndReleaseYearAndDirector_Name(updateDto.getTitle(),
                        updateDto.getReleaseYear(), updateDto.getDirector());

        if (movieEntity == null) {
            throw new NotFoundException("This Movie is Not Found !");
        }

        movieRepository.deleteById(movieEntity.getId());

        log.info("Delete Ended ");
    }
}
