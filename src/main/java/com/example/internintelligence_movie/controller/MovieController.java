package com.example.internintelligence_movie.controller;

import com.example.internintelligence_movie.dao.entity.enums.GenreType;
import com.example.internintelligence_movie.model.MovieDto;
import com.example.internintelligence_movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/movie")
public class MovieController {
    private final MovieService movieService;

    @PostMapping("/add")
    public void addMovie(@RequestBody MovieDto movieDto,
                         @RequestParam("genre") Set<GenreType> genre){
        movieService.addMovie(movieDto, genre);
    }
}
