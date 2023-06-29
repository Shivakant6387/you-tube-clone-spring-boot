package com.example.shiva.youtubeclonespringboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmDTO {
    private LocalDateTime uploadDate;
    private String title;
    private String description;
    private String url;
    private double length;
    private String channel;

    public FilmDTO(String title, String description, String url, double length, String channel) {
        this.title = title;
        this.description = description;
        this.url = url;
        this.length = length;
        this.channel = channel;
    }
}
