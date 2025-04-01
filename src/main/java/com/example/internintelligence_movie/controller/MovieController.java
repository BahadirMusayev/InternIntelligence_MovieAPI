package com.example.internintelligence_movie.controller;

import com.example.internintelligence_movie.dao.entity.enums.GenreType;
import com.example.internintelligence_movie.model.CRUDDto;
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
    public void updateTitle(@RequestBody CRUDDto CRUDDto,
                            @RequestParam("newTitle") String newTitle) {
        movieService.updateTitle(CRUDDto, newTitle);
    }

    @PatchMapping("/update/release/year")
    public void updateReleaseYear(@RequestBody CRUDDto CRUDDto,
                                  @RequestParam("newReleaseYear") Integer newReleaseYear) {
        movieService.updateReleaseYear(CRUDDto, newReleaseYear);
    }

    @PatchMapping("/update/IMDb/rating")
    public void updateIMDbRating(@RequestBody CRUDDto CRUDDto,
                                 @RequestParam("newIMDbRating") Double newIMDbRating) {
        movieService.updateIMDbRating(CRUDDto, newIMDbRating);
    }

    @PatchMapping("/update/director")
    public void updateDirector(@RequestBody CRUDDto CRUDDto,
                               @RequestParam("newDirector") String newDirector) {
        movieService.updateDirector(CRUDDto, newDirector);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody CRUDDto CRUDDto) {
        movieService.delete(CRUDDto);
    }
}
