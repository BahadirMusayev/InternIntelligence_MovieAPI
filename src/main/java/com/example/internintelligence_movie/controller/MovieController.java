package com.example.internintelligence_movie.controller;

import com.example.internintelligence_movie.dao.entity.enums.GenreType;
import com.example.internintelligence_movie.model.UpdateDto;
import com.example.internintelligence_movie.model.input.MovieDtoInput;
import com.example.internintelligence_movie.model.output.MovieDtoOutput;
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
    public void add(@RequestBody MovieDtoInput movieDtoInput,
                    @RequestParam("genre") Set<GenreType> genre) {
        movieService.add(movieDtoInput, genre);
    }

    @GetMapping("/read")
    public List<MovieDtoOutput> get(@RequestParam("title") String title) {
        return movieService.get(title);
    }

    @PatchMapping("/update/title")
    public void updateTitle(@RequestBody UpdateDto updateDto,
                            @RequestParam("newTitle") String newTitle) {
        movieService.updateTitle(updateDto, newTitle);
    }

    @PatchMapping("/update/release/year")
    public void updateReleaseYear(@RequestBody UpdateDto updateDto,
                                  @RequestParam("newReleaseYear") Integer newReleaseYear) {
        movieService.updateReleaseYear(updateDto, newReleaseYear);
    }

    @PatchMapping("/update/IMDb/rating")
    public void updateIMDbRating(@RequestBody UpdateDto updateDto,
                                 @RequestParam("newIMDbRating") Double newIMDbRating) {
        movieService.updateIMDbRating(updateDto, newIMDbRating);
    }

    @PatchMapping("/update/director")
    public void updateDirector(@RequestBody UpdateDto updateDto,
                               @RequestParam("newDirector") String newDirector) {
        movieService.updateDirector(updateDto, newDirector);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody UpdateDto updateDto) {
        movieService.delete(updateDto);
    }
}
