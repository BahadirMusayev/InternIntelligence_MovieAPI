package com.example.internintelligence_movie.controller;

import com.example.internintelligence_movie.dao.entity.enums.GenreType;
import com.example.internintelligence_movie.model.MovieDtoInput;
import com.example.internintelligence_movie.model.MovieDtoOutput;
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

    @PostMapping("/create")
    public void addMovie(@RequestBody MovieDtoInput movieDtoInput,
                         @RequestParam("genre") List<GenreType> genre){
        movieService.addMovie(movieDtoInput, genre);
    }

    @GetMapping("/read")
    public List<MovieDtoOutput> getMovies(@RequestParam("title") String title){
        return movieService.getMovies(title);
    }
}
