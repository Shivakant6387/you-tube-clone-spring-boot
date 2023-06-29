package com.example.shiva.youtubeclonespringboot.service;

import com.example.shiva.youtubeclonespringboot.entity.Film;
import com.example.shiva.youtubeclonespringboot.exception.FilmNotFoundException;
import com.example.shiva.youtubeclonespringboot.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {
    private FilmRepository filmRepository;

    @Autowired
    public FilmService(FilmRepository filmRepository){
        this.filmRepository = filmRepository;
    }

    public List<Film> getFilms(){
        return filmRepository.findAll();
    }

    public Film getFilm(Long id){
        return filmRepository.findById(id)
                .orElseThrow(()-> new FilmNotFoundException("Cant find."));
    }

    public List<Film> getFilmsByChannelId(Long id){
        return filmRepository.findAllByChannel_Id(id);
    }
}
