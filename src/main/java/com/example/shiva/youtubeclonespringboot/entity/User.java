package com.example.shiva.youtubeclonespringboot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User extends AbstractEntity {

    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Channel> channels = new HashSet<>();

    @OneToMany(mappedBy = "user") // default Lazy
    private Set<UserWatchedFilm> watchedFilms = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Reply> replies = new HashSet<>();

    public User(String firstName, String lastName, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
    }
}
