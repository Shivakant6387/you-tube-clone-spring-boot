package com.example.shiva.youtubeclonespringboot.controller;

import com.example.shiva.youtubeclonespringboot.ApiInformation;
import com.example.shiva.youtubeclonespringboot.dto.UserWatchedFilmDTO;
import com.example.shiva.youtubeclonespringboot.mapper.UserWatchedFilmMapper;
import com.example.shiva.youtubeclonespringboot.service.UserWatchedFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserWatchedFilmController {
    @Autowired
    private UserWatchedFilmService userWatchedFilmService;
    @Autowired
    private UserWatchedFilmMapper userWatchedFilmMapper;



    @GetMapping("/watchedHistory")
    public List<UserWatchedFilmDTO> getWatchedFilms() {
        return userWatchedFilmMapper.toUserWatchedFilmDTO(userWatchedFilmService.getWatchedFilms());
    }


    @GetMapping("/users/{id}/watchedHistory")
    public List<UserWatchedFilmDTO> getWatchedFilmsByUserId(@PathVariable Long id) {
        return userWatchedFilmMapper.toUserWatchedFilmDTO(userWatchedFilmService.getWatchedFilmsByUserId(id));
    }


    @PostMapping("/watchedHistory")
    public UserWatchedFilmDTO postWatchedFilm(@RequestBody UserWatchedFilmDTO userWatchedFilmDTO){
        return userWatchedFilmMapper.toUserWatchedFilmDTO(userWatchedFilmService.postWatchedFilm(userWatchedFilmMapper.toUserWatchedFilmEntity(userWatchedFilmDTO)));
    }


    @DeleteMapping("/users/{id}/watchedHistory")
    public ApiInformation deleteWatchedFilmsByUserId(@PathVariable Long id){
        userWatchedFilmService.deleteWatchedFilmsByUserId(id);
        return new ApiInformation("Deleted all watched history.", HttpStatus.OK.value());
    }
}
