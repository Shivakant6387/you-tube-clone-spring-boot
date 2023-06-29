package com.example.shiva.youtubeclonespringboot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_watched_films")
public class UserWatchedFilm extends AbstractEntity{
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    private UserWatchedFilm(User user, Film film){
        this.film = film;
        this.user = user;
    }

    private BigDecimal timeSpentForWatching;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;
}
