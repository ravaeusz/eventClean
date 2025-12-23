package com.evenClean.infra.exceptions;

public class DuplicatedException extends RuntimeException {

    public DuplicatedException(String message) {
        super(message);
    }

}
