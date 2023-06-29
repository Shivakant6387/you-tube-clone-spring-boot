package com.example.shiva.youtubeclonespringboot.service;

import com.example.shiva.youtubeclonespringboot.entity.UserWatchedFilm;
import com.example.shiva.youtubeclonespringboot.repository.UserWatchedFilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserWatchedFilmService {
    private UserWatchedFilmRepository userWatchedFilmRepository;

    @Autowired
    public UserWatchedFilmService(UserWatchedFilmRepository userWatchedFilmRepository) {
        this.userWatchedFilmRepository = userWatchedFilmRepository;
    }

    public List<UserWatchedFilm> getWatchedFilms(){
        return userWatchedFilmRepository.findAll();
    }


    public List<UserWatchedFilm> getWatchedFilmsByUserId(Long id){
        return userWatchedFilmRepository.findAllByUser_Id(id);
    }

    public UserWatchedFilm postWatchedFilm(UserWatchedFilm userWatchedFilm){
        return userWatchedFilmRepository.save(userWatchedFilm);
    }


    public void deleteWatchedFilmsByUserId(Long id){
        userWatchedFilmRepository.deleteById(id);
    }
}
