package com.evenClean.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationResourceAdvice {

    @ExceptionHandler(DuplicatedException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ApiError handleDuplicatedException(DuplicatedException exception){
        return new ApiError(exception.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError handleNotFoundException(NotFoundException exception){
        return new ApiError(exception.getMessage());
    }

}
