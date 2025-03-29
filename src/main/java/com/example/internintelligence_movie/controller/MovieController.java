package com.example.internintelligence_movie.controller;

import com.example.internintelligence_movie.dao.entity.enums.GenreType;
import com.example.internintelligence_movie.model.EditDto;
import com.example.internintelligence_movie.model.MovieDtoInput;
import com.example.internintelligence_movie.model.MovieDtoOutput;
import com.example.internintelligence_movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/movie")
public class MovieController {
    private final MovieService movieService;

    @PostMapping("/create")
    public void add(@RequestBody MovieDtoInput movieDtoInput,
                         @RequestParam("genre") List<GenreType> genre){
        movieService.add(movieDtoInput, genre);
    }

    @GetMapping("/read")
    public List<MovieDtoOutput> get(@RequestParam("title") String title){
        return movieService.get(title);
    }

    @PatchMapping("/update/title")
    public void updateTitle(@RequestBody EditDto editDto,
                               @RequestParam("newTitle") String newTitle){
        movieService.updateTitle(editDto, newTitle);
    }

    @PatchMapping("/update/release/year")
    public void updateReleaseYear(@RequestBody EditDto editDto,
                                     @RequestParam("newReleaseYear") Integer newReleaseYear){
        movieService.updateReleaseYear(editDto, newReleaseYear);
    }

    @PatchMapping("/update/IMDb/rating")
    public void updateIMDbRating(@RequestBody EditDto editDto,
                                    @RequestParam("newIMDbRating") Double newIMDbRating){
        movieService.updateIMDbRating(editDto, newIMDbRating);
    }

    @PatchMapping("/update/director")
    public void updateDirector(@RequestBody EditDto editDto,
                                  @RequestParam("newDirector") String newDirector){
        movieService.updateDirector(editDto, newDirector);
    }
}
