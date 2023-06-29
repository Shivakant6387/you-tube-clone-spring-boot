package com.example.shiva.youtubeclonespringboot.exception;

public class FilmNotFoundException extends RuntimeException{
    public FilmNotFoundException(String message) {
        super(message);
    }
}
