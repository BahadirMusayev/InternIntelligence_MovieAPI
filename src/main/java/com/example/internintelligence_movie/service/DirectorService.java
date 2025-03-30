package com.example.internintelligence_movie.service;

import com.example.internintelligence_movie.dao.entity.DirectorEntity;
import com.example.internintelligence_movie.dao.entity.MovieEntity;
import com.example.internintelligence_movie.dao.exception.NotFoundException;
import com.example.internintelligence_movie.dao.repository.DirectorRepository;
import com.example.internintelligence_movie.mapper.MovieMapper;
import com.example.internintelligence_movie.model.MovieDtoOutput;
import com.example.internintelligence_movie.service.impl.DirectorServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class DirectorService implements DirectorServiceImpl {

    private final DirectorRepository directorRepository;
    private final MovieMapper movieMapper;

    @Override
    public List<MovieDtoOutput> get(String name) {
        log.info("Get Started... ");

        DirectorEntity directorEntity = directorRepository.
                findByNameIgnoreCase(name);

        if (directorEntity == null) {
            throw new NotFoundException("Director Not Found !");
        }

        List<MovieEntity> movieEntities = directorEntity.
                getMovies();
        return movieMapper.
                mapEntityToDtoOutputs(movieEntities);
    }
}
