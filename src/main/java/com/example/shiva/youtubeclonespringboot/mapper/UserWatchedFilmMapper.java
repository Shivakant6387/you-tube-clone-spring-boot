package com.example.shiva.youtubeclonespringboot.mapper;

import com.example.shiva.youtubeclonespringboot.dto.UserWatchedFilmDTO;
import com.example.shiva.youtubeclonespringboot.entity.Film;
import com.example.shiva.youtubeclonespringboot.entity.User;
import com.example.shiva.youtubeclonespringboot.entity.UserWatchedFilm;
import com.example.shiva.youtubeclonespringboot.exception.FilmNotFoundException;
import com.example.shiva.youtubeclonespringboot.exception.UserNotFoundException;
import com.example.shiva.youtubeclonespringboot.repository.FilmRepository;
import com.example.shiva.youtubeclonespringboot.repository.UserRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class UserWatchedFilmMapper {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FilmRepository filmRepository;
    @Mappings({
            @Mapping(target = "filmId", source = "film.id"),
            @Mapping(target = "userId", source = "user.id")
    })
    public abstract UserWatchedFilmDTO toUserWatchedFilmDTO(UserWatchedFilm userWatchedFilm);

    public abstract List<UserWatchedFilmDTO> toUserWatchedFilmDTO(Collection<UserWatchedFilm> watchedFilms);


    public UserWatchedFilm toUserWatchedFilmEntity(UserWatchedFilmDTO userWatchedFilmDTO) {
        UserWatchedFilm userWatchedFilm = new UserWatchedFilm();
        Film film = filmRepository.findById(userWatchedFilmDTO.getFilmId()).orElseThrow(() -> new FilmNotFoundException("Film not found."));
        User user = userRepository.findById(userWatchedFilmDTO.getUserId()).orElseThrow(() -> new UserNotFoundException("User nor found."));
        userWatchedFilm.setFilm(film);
        userWatchedFilm.setUser(user);
        userWatchedFilm.setTimeSpentForWatching(userWatchedFilmDTO.getTimeSpentForWatching());
        userWatchedFilm.setEndedAt(userWatchedFilmDTO.getEndedAt());
        userWatchedFilm.setStartedAt(userWatchedFilmDTO.getStartedAt());
        return userWatchedFilm;
    }
}
