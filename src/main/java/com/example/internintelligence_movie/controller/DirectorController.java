package com.example.internintelligence_movie.controller;

import com.example.internintelligence_movie.model.MovieDtoOutput;
import com.example.internintelligence_movie.service.DirectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/director")
public class DirectorController {

    private final DirectorService directorService;

    @GetMapping("/get")
    public List<MovieDtoOutput> get(@RequestParam("name") String name){
        return directorService.get(name);
    }
}
