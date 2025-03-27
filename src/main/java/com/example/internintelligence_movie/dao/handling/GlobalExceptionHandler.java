package com.example.internintelligence_movie.dao.handling;

import com.example.internintelligence_movie.dao.exception.FoundException;
import com.example.internintelligence_movie.model.ExceptionDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.FOUND)
    @ExceptionHandler(FoundException.class)
    public ExceptionDto foundHandler(RuntimeException exception){
        log.info("302 - Found !");
        return new ExceptionDto(exception.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public ExceptionDto handleException(RuntimeException exception) {
        log.info("500 - Internal Server Error !");
        return new ExceptionDto(exception.getMessage());
    }
}
